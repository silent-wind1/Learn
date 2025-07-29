create table weather
(
    id          int primary key auto_increment comment '主键',
    record_date  date comment '日期',
    temperature int comment '温度'
) comment '天气';


insert into weather
values (1, '2025-07-01', 10),
       (2, '2025-07-02', 25),
       (3, '2025-07-03', 20),
       (4, '2025-07-04', 30),
       (5, '2025-07-05', 40),
       (6, '2025-07-06', 35),
       (7, '2025-07-27', 35),
       (8, '2025-07-28', 25),
       (9, '2025-07-29', 35);

select a.id
from weather as a,
     weather as b
where datediff(a.record_date, b.record_date) = 1
  and a.temperature > b.temperature;

-- datediff() 函数 计算两个日期之间的天数差
select a.id, a.temperature, a.record_date
from weather as a
         inner join weather as b
where datediff(a.record_date, b.record_date) = 1
  and a.temperature > b.temperature;
