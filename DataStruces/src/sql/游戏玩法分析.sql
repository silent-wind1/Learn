create table activity
(
    player_id    int comment '玩家id',
    device_id    int comment '设备id',
    event_date   date comment '事件日期',
    games_played int comment '当天玩的游戏数量'
) comment '活动表';


insert into activity
values (1, 2, '2025-06-11', 5),
       (1, 2, '2025-06-13', 6),
       (2, 3, '2025-06-25', 1),
       (3, 1, '2025-03-02', 0),
       (3, 4, '2025-01-13', 5),
       (2, 4, '2022-04-11', 2);

select player_id, min(event_date) as first_login
from activity
group by player_id


