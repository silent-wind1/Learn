use yefeng;

create table customers
(
    id   int primary key auto_increment comment '主键',
    name varchar(20) comment '姓名'
) comment '客户表';


insert into customers
values (1, '张三'),
       (2, '李四'),
       (3, '王五'),
       (4, '赵六');

create table orders
(
    id          int primary key auto_increment comment '主键',
    customer_id int comment '客户id'
) comment '订单表';

insert into orders
values (1, 1),
       (2, 4);

-- 查找不在订单表里的客户
select c.id, c.name
from customers as c
         left join orders as o on c.id = o.customer_id
where o.customer_id is null;

-- 查找在订单表里的客户
select c.id, c.name
from customers as c
         left join orders as o on c.id = o.customer_id
where o.customer_id is not null;