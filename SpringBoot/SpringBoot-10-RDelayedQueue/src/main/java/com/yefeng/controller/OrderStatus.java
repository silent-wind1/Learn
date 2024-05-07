package com.yefeng.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 订单状态机
public enum OrderStatus {
    NEW(0, "新订单"),
    PAYING(1, "支付中"),
    PAID(2, "已支付"),
    FINISHED(3, "已完成"),
    CANCELED(4, "已取消");

    private final int code;
    private final String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

// 订单实体类
public class Order {
    private String orderId;
    private double money;
    private OrderStatus status;

    public Order(String orderId, double money) {
        this.orderId = orderId;
        this.money = money;
        this.status = OrderStatus.NEW;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

// Redis 客户端
public class RedisClient {
    private static Jedis jedis = new Jedis("localhost");

    public static boolean lock(String key) {
        return jedis.setnx(key, "lock") == 1;
    }

    public static void unlock(String key) {
        jedis.del(key);
    }
}

// 下单服务
public class OrderService {
    private static final String ORDER_KEY_PREFIX = "order:";
    private static final String ORDER_STATUS_KEY_PREFIX = "order:status:";

    public static Order createOrder(String userId, double money) {
        // 生成订单 ID
        String orderId = UUID.randomUUID().toString();
        // 创建订单实体
        Order order = new Order(orderId, money);
        // 保存订单到 Redis
        jedis.hset(ORDER_KEY_PREFIX + userId, orderId, JSON.toJSONString(order));
        // 更新订单状态
        jedis.hset(ORDER_STATUS_KEY_PREFIX + orderId, "status", order.getStatus().getCode());
        return order;
    }

    public static Order getOrder(String userId, String orderId) {
        String orderJson = jedis.hget(ORDER_KEY_PREFIX + userId, orderId);
        if (orderJson == null) {
            return null;
        }
        Order order = JSON.parseObject(orderJson, Order.class);
        return order;
    }

    public static void updateOrderStatus(String orderId, OrderStatus status) {
        jedis.hset(ORDER_STATUS_KEY_PREFIX + orderId, "status", status.getCode());
    }
}

// 支付服务
public class PaymentService {
    private static final String PAYMENT_KEY_PREFIX = "payment:";

    public static boolean pay(String userId, String orderId) {
        // 查询订单
        Order order = OrderService.getOrder(userId, orderId);
        if (order == null) {
            return false;
        }
        // 判断订单状态
        if (order.getStatus() != OrderStatus.NEW) {
            return false;
        }
        // 支付订单
        order.setStatus(OrderStatus.PAYING);
        OrderService.updateOrderStatus(orderId, OrderStatus.PAYING);
        // 保存支付信息到 Redis
        jedis.hset(PAYMENT_KEY_PREFIX + orderId, "userId", userId);
        return true;
    }

    public static boolean isPaid(String orderId) {
        OrderStatus status = OrderStatus.valueOf(jedis.hget(PAYMENT_KEY_PREFIX + orderId, "status"));
        return status == OrderStatus.PAID;
    }
}

// 订单状态机监听器
public class OrderStatusListener {
    private static final String ORDER_STATUS_LISTENER_KEY = "order:status:listener";

    public static void main(String[] args) {
        // 监听订单状态变化
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                // 解析消息
                OrderStatusChangedMessage msg = JSON.parseObject(message, OrderStatusChangedMessage.class);
                // 根据消息更新订单状态
                Order order = OrderService.getOrder(msg.getUserId(), msg.getOrderId());
                if (order != null) {
                    order.setStatus(OrderStatus.values()[msg.getNewStatus()]);
                    OrderService.updateOrderStatus(msg.getOrderId(), order.getStatus());
                }
            }
        };
        jedis.subscribe(jedisPubSub, ORDER_STATUS_LISTENER_KEY);
    }

    // 发送订单状态变化消息
    public static void sendOrderStatusChangedMessage(String userId, String orderId, int newStatus) {
        OrderStatusChangedMessage msg = new OrderStatusChangedMessage(userId, orderId, newStatus);
        jedis.publish(ORDER_STATUS_LISTENER_KEY, JSON.toJSONString(msg));
    }

    private static class OrderStatusChangedMessage {
        private String userId;
        private String orderId;
        private int newStatus;

        public OrderStatusChangedMessage(String userId, String orderId, int newStatus) {
            this.userId = userId;
            this.orderId = orderId;
            this.newStatus = newStatus;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getNewStatus() {
            return newStatus;
        }

        public void setNewStatus(int newStatus) {
            this.newStatus = newStatus;
        }
    }
}

// 下单接口
@RestController
public class OrderController {
    @PostMapping("/order")
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        // 下单
        Order order = OrderService.createOrder(request.getUserId(), request.getMoney());
        // 发送下单事件
        OrderStatusListener.sendOrderStatusChangedMessage(request.getUserId(), order.getOrderId(), order.getStatus().getCode());
        return order;
    }
}

// 支付接口
@RestController
public class PaymentController {
    @PostMapping("/payment")
    public boolean pay(@RequestBody PayRequest request) {
        // 支付
        boolean paid = PaymentService.pay(request.getUserId(), request.getOrderId());
        // 发送支付事件
        if (paid) {
            OrderStatusListener.sendOrderStatusChangedMessage(request.getUserId(), request.getOrderId(), OrderStatus.PAID.getCode());
        }
        return paid;
    }
}

// 创建订单请求类
public class CreateOrderRequest {
    private String userId;
    private double money;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

// 支付请求类
public class PayRequest {
    private String userId;
    private String orderId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}