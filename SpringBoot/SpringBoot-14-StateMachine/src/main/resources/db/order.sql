CREATE TABLE IF NOT EXISTS `order`
(
    id           BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    order_id     BIGINT      NOT NULL COMMENT '业务订单号',
    order_status VARCHAR(32) NOT NULL COMMENT '订单状态',
    deleted      TINYINT     NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    create_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_order_id (order_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='订单表';