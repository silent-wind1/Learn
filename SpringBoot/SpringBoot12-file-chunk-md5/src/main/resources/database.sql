#附件表
CREATE TABLE `archive`
(
    `id`              bigint                                                                 DEFAULT NULL,
    `sid`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL  COMMENT '字符串编号',
    `path`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件路径',
    `size`            bigint                                                        NOT NULL DEFAULT '0' COMMENT '文件大小',
    `duration`        bigint                                                                 DEFAULT NULL COMMENT '文件时长',
    `original_name`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '原始名,带扩展名',
    `file_name`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT '' COMMENT '存储名称',
    `file_type`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '类型',
    `full_path`       varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         DEFAULT NULL COMMENT '服务器储存路径',
    `merge_flag`      tinyint                                                                DEFAULT NULL COMMENT '是否合并',
    `md5_value`       varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '文件MD5值',
    `zone_flag`       tinyint                                                                DEFAULT NULL COMMENT '是否分片 0 否 1是',
    `zone_total`      int                                                                    DEFAULT NULL COMMENT '分片总数',
    `zone_date`       datetime                                                               DEFAULT NULL COMMENT '分片时间',
    `zone_merge_date` datetime                                                               DEFAULT NULL COMMENT '分片合并时间',
    `create_time`     datetime                                                               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据创建时间',
    `update_time`     datetime                                                               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新时间',
    PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='附件表';

# 分片记录表
CREATE TABLE `archive_zone_record`
(
    `sid`                varchar(36) NOT NULL COMMENT '唯一标识：分片记录ID',
    `id`                 varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT 'webupload生成的分片文件ID',
    `zone_name`          varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分片名称',
    `zone_path`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分片的文件路径',
    `type`               varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分片所属的文件类型',
    `zone_md5`           varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '当前分片的MD5',
    `last_modified_date` datetime                                                      DEFAULT NULL COMMENT '分片记录MD5校验日期',
    `zone_check_date`    datetime                                                      DEFAULT NULL COMMENT '上传完成校验日期',
    `zone_total_count`   int                                                           DEFAULT NULL COMMENT '全部分片数量',
    `zone_total_md5`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '总分片的MD5值',
    `zone_now_index`     int                                                           DEFAULT NULL COMMENT '当前分片序号',
    `zone_start_size`    int                                                           DEFAULT NULL COMMENT '文件开始位置',
    `zone_end_size`      int                                                           DEFAULT NULL COMMENT '文件结束位置',
    `zone_total_size`    int                                                           DEFAULT NULL COMMENT '文件总大小',
    `file_md5`           varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '文件的md5',
    `zone_suffix`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '分片文件后缀',
    `archive_sid`        varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '文件记录ID',
    `create_time`        datetime                                                      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime                                                      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`sid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='文件分片记录表';
