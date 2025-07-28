create database yefeng;

use yefeng;

create table employee
(
    id     int primary key auto_increment comment 'id',
    salary int comment '工资'
) comment '员工表';