-- auto-generated definition
create table orders
(
    id              bigint         not null comment '主键'
        primary key,
    number          varchar(50)    null comment '订单号',
    status          int default 1  not null comment '订单状态 1待付款，2待派送，3已派送，4已完成，5已取消',
    user_id         bigint         not null comment '下单用户',
    address_book_id bigint         not null comment '地址id',
    order_time      datetime       not null comment '下单时间',
    checkout_time   datetime       not null comment '结账时间',
    pay_method      int default 1  not null comment '支付方式 1微信,2支付宝',
    amount          decimal(10, 2) not null comment '实收金额',
    remark          varchar(100)   null comment '备注',
    phone           varchar(255)   null,
    address         varchar(255)   null,
    user_name       varchar(255)   null,
    consignee       varchar(255)   null
)
    comment '订单表' collate = utf8_bin;

create index idx_id_number_userid
    on orders (id, number, user_id);

create index idx_number_userid_address_book_id
    on orders (number, user_id, address_book_id);



explain
select id, number, user_id
from orders
where user_id = 1585833925538791425
  and id = 1587366161090199553;

explain
select id, number, user_id
from orders
where id = 1587366161090199553
  and user_id = 1585833925538791425;


explain
select number, user_id, address_book_id
from orders
where address_book_id = 1587366113665204225
  and number = 1587366161090199553;

explain
select number, user_id, address_book_id
from orders
where number > 1417091739309864860
  and address_book_id = 1587366113665204225;

explain
select number, user_id, address_book_id
from orders
where user_id = 1585833925538791425
  and address_book_id = 1587366113665204225;


explain
select number, user_id, address_book_id
from orders where number > 1586000000000001021 and user_id > 1585277977920271142 and address_book_id > 1417203638708118125;




