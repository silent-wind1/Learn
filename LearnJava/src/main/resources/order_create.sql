# 有一个订单表，一个产品表，一个产品订单表。你会如何设计表的映射关系
CREATE TABLE Order_Products
(
    order_id   INT,                    -- 订单ID
    product_id INT,                    -- 产品ID
    quantity   INT,                    -- 产品数量
    price      DECIMAL(10, 2),         -- 产品价格（订单中可能有折扣或变化，和产品表的价格可能不同）
    PRIMARY KEY (order_id, product_id) -- 订单ID和产品ID组合唯一
);


CREATE TABLE Products
(
    product_id   INT AUTO_INCREMENT PRIMARY KEY, -- 产品ID
    product_name VARCHAR(255),                   -- 产品名称
    price        DECIMAL(10, 2),                 -- 产品单价
    stock        INT                             -- 库存数量
);

CREATE TABLE Orders
(
    order_id     INT AUTO_INCREMENT PRIMARY KEY, -- 订单ID
    customer_id  INT,                            -- 客户ID，假设有用户表来存储客户信息
    order_date   DATETIME,                       -- 订单创建日期
    total_amount DECIMAL(10, 2),                 -- 订单总金额
    status       VARCHAR(20)                     -- 订单状态（例如：待处理、已完成、已取消等）
);
