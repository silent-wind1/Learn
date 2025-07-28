create table person
(
    id    int primary key auto_increment comment '主键',
    email varchar(20) comment '邮箱'
) comment '人员表';


insert into person
values (1, 'a@b.com'),
       (2, 'c@d.com'),
       (3, 'e@b.com'),
       (4, 'w@b.com'),
       (5, 'c@d.com');

-- 查找重复的电子邮箱
select email
from person
group by email
having count(email) > 1;