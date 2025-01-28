操作表
```SQL

CREATE TABLE `user_membership_history` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
  `membership_level_id` INT UNSIGNED NOT NULL COMMENT '对应 membership_levels.id',
  `effective_year` YEAR NOT NULL COMMENT '等级生效的年份',
  `effective_month` TINYINT UNSIGNED NOT NULL COMMENT '等级生效的月份(1-12)',
  `assigned_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分配(确定)该等级的时间',
  `comment` VARCHAR(255) DEFAULT NULL COMMENT '备注',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户每个月实际拥有的等级历史记录'

CREATE TABLE `user_monthly_stats` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
  `stat_year` YEAR NOT NULL COMMENT '统计年份',
  `stat_month` TINYINT UNSIGNED NOT NULL COMMENT '统计月份（1-12）',
  `required_points` INT UNSIGNED DEFAULT NULL COMMENT '直营订单量',
  `required_revenue` INT DEFAULT NULL COMMENT '团队订单量',
  `other_metric` INT UNSIGNED DEFAULT 0 COMMENT '可自定义的其他指标，如活跃度、贡献值等',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户每个月的各项统计指标表'

CREATE TABLE `membership_levels` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `level_name` VARCHAR(255) NOT NULL COMMENT '等级名称',
  `required_points` INT UNSIGNED DEFAULT NULL COMMENT '直营订单量',
  `required_revenue` INT DEFAULT NULL COMMENT '团队订单量',
  `price` INT UNSIGNED DEFAULT NULL COMMENT '奖励金额',
  `level_order` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '等级顺序, 0表示最低级',
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员/合伙人等级配置表'


CREATE PROCEDURE generate_initial_membership_history()
BEGIN
  -- 声明变量
  DECLARE done INT DEFAULT 0;
  DECLARE user_id INT;
  DECLARE level_id INT DEFAULT 1; -- 默认会员等级ID (假设为1)
  DECLARE current_year INT;
  DECLARE current_month INT;
  
  -- 游标定义：遍历 hk_member1 表中的所有有效用户
  DECLARE user_cursor CURSOR FOR
SELECT id
FROM hk_member1
WHERE del_fag = '0';  -- 假设 del_fag = '0' 表示有效用户

-- 定义异常处理：当游标没有更多数据时，结束循环
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  -- 获取当前年和月
  SET current_year = YEAR(CURRENT_DATE);
  SET current_month = MONTH(CURRENT_DATE);
  
  -- 打开游标
OPEN user_cursor;

-- 游标循环：遍历每个用户，插入到 user_membership_history 表和 user_monthly_stats 表
read_loop: LOOP
    FETCH user_cursor INTO user_id;
    
    -- 如果游标没有更多数据，退出循环
    IF done THEN
      LEAVE read_loop;
END IF;
    
    -- 插入历史记录到 user_membership_history 表
INSERT INTO user_membership_history (
    user_id,
    membership_level_id,
    effective_year,
    effective_month,
    assigned_date,
    created_at,
    updated_at
)
VALUES (
           user_id,
           level_id,                          -- 默认等级ID
           current_year,                       -- 当前年份
           current_month,                      -- 当前月份
           NOW(),                              -- 分配时间
           NOW(),                              -- 创建时间
           NOW()                               -- 更新时间
       );

-- 插入初始化数据到 user_monthly_stats 表
INSERT INTO user_monthly_stats (
    user_id,
    stat_year,
    stat_month,
    required_points,
    required_revenue,
    created_at,
    updated_at
)
VALUES (
           user_id,
           current_year,                      -- 当前年份
           current_month,                     -- 当前月份
           0,                                 -- required_points 设置为0
           0,                                 -- required_revenue 设置为0
           NOW(),                             -- 创建时间
           NOW()                              -- 更新时间
       );

END LOOP;

  -- 关闭游标
CLOSE user_cursor;

END



CALL generate_initial_membership_history();


CREATE PROCEDURE update_user_membership_level()
BEGIN
  -- 声明变量
  DECLARE done INT DEFAULT 0;
  DECLARE user_id INT;
  DECLARE required_points INT;
  DECLARE required_revenue INT;
  DECLARE user_points INT;
  DECLARE user_revenue INT;
  DECLARE current_year INT;
  DECLARE current_month INT;
  DECLARE last_level INT;
  DECLARE new_level INT;
  DECLARE level_order INT;
  
  -- 游标定义：遍历 user_monthly_stats 表中的所有用户
  DECLARE user_cursor CURSOR FOR
SELECT ums.user_id, ums.required_points, ums.required_revenue
FROM user_monthly_stats ums
         JOIN hk_member1 hm ON ums.user_id = hm.id
WHERE hm.del_fag = '0' AND hm.status = '1';  -- 假设 del_fag = '0' 和 status = '1' 表示有效用户

-- 定义异常处理：当游标没有更多数据时，结束循环
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  -- 获取当前年和月
  SET current_year = YEAR(CURRENT_DATE);
  SET current_month = MONTH(CURRENT_DATE);

  -- 如果是 1 月份，则需要考虑上一年
  IF current_month = 1 THEN
    SET current_year = current_year - 1;  -- 如果是 1 月份，上一月为 12 月，即跨年
    SET current_month = 12;
ELSE
    SET current_month = current_month - 1;  -- 不是 1 月份，上一月是正常的前一月
END IF;
  
  -- 打开游标
OPEN user_cursor;

-- 游标循环：遍历每个用户，检查是否满足升级条件
read_loop: LOOP
    FETCH user_cursor INTO user_id, required_points, required_revenue;
    
    -- 如果游标没有更多数据，退出循环
    IF done THEN
      LEAVE read_loop;
END IF;
    
    -- 获取用户的当前等级
SELECT membership_level_id INTO last_level
FROM user_membership_history
WHERE user_id = user_id
  AND effective_year = current_year
  AND effective_month = current_month
ORDER BY id DESC LIMIT 1;

-- 如果用户没有当前等级记录，则跳过该用户
IF last_level IS NULL THEN
      SET last_level = 0; -- 默认等级
END IF;
    
    -- 获取用户的上个月的统计数据
SELECT required_points, required_revenue INTO user_points, user_revenue
FROM user_monthly_stats
WHERE user_id = user_id
  AND stat_year = current_year
  AND stat_month = current_month;

-- 从最高等级开始判断
SET level_order = (SELECT MAX(level_order) FROM membership_levels);  -- 获取最大等级
    
    -- 循环检查是否满足每个等级的条件，从最高等级到最低等级逐一判断
    level_check_loop: LOOP
      -- 获取当前等级的要求
SELECT required_points, required_revenue INTO required_points, required_revenue
FROM membership_levels
WHERE level_order = level_order
    LIMIT 1;

-- 如果用户满足当前等级的要求
IF (user_points >= required_points OR user_revenue >= required_revenue) THEN
        -- 获取当前等级的 ID
SELECT id INTO new_level
FROM membership_levels
WHERE level_order = level_order
    LIMIT 1;

-- 插入新的等级记录到 user_membership_history
INSERT INTO user_membership_history (
    user_id,
    membership_level_id,
    effective_year,
    effective_month,
    assigned_date,
    created_at,
    updated_at
)
VALUES (
           user_id,
           new_level,
           current_year,
           current_month,
           NOW(),
           NOW(),
           NOW()
       );

-- 插入新的统计数据到 user_monthly_stats，设置 required_points 和 required_revenue 为 0
INSERT INTO user_monthly_stats (
    user_id,
    stat_year,
    stat_month,
    required_points,
    required_revenue,
    created_at,
    updated_at
)
VALUES (
           user_id,
           current_year,
           current_month,
           0,  -- 设置 required_points 为 0
           0,  -- 设置 required_revenue 为 0
           NOW(),
           NOW()
       );

-- 如果满足升级条件，停止判断下一个等级
LEAVE level_check_loop;
END IF;

      -- 如果没有满足当前等级的条件，检查下一个等级
      SET level_order = level_order - 1;

      -- 如果已经达到最低等级，则退出
      IF level_order < 1 THEN
        LEAVE level_check_loop;
END IF;
END LOOP;

END LOOP;

  -- 关闭游标
CLOSE user_cursor;

END


-- 这里需要做定时任务
CALL update_user_membership_level();

```
1. 新用户注册都需要生成一个默认的等级
2. 结算的时候，需要根据这个等级，添加结算金额
3. 下单成功后，才会添加相关的订单数据
