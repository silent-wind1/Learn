create database yefeng;

use yefeng;

create table employee
(
    id     int primary key auto_increment comment 'id',
    salary int comment '工资'
) comment '员工表';


insert into employee
values (1, 100),
       (2, 200),
       (3, 300);

-- 通过max()函数获取第二高的薪水
select max(salary) as SecondHighestSalary
from employee
where salary < (select max(salary) from employee);

-- 通过limit获取第二高的薪水
select ifNull((select distinct salary from employee order by Salary Desc limit 1,1), null) as SecondHighestSalary;