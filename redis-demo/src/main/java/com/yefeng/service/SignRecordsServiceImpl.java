package com.yefeng.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: 叶枫
 * @Date: 2025/05/22/16:03
 * @Description:
 */
@Slf4j
@Service
public class SignRecordsServiceImpl implements SignRecordsService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static String yyyy_MM_dd = "yyyy-MM-dd";
    private static String yyyy_MM = "yyyy-MM";

    @Override
    public void addSignRecords(String userId, String date) {
        String cacheKey = getCacheKey(userId, date);
        // 获取日期
        DateTime dateTime = DateUtil.parse(date, yyyy_MM_dd);
        int day = dateTime.dayOfMonth();
        // 设置给BitMap对应位标记 其中offset为0表示第一天所以要day-1
        Boolean result = redisTemplate.opsForValue().setBit(cacheKey, day - 1, true);
        // 如果响应true则代表之前已经签到，在Redis指令操作set bit 设置对应位为1的时候，如果之前是0或者不存在会响应0，如果为1则响应1
        if (Boolean.TRUE.equals(result)) {
            log.info("用户userNo={} date={}  已签到", userId, date);
        }
    }

    /**
     * 获取缓存key
     */
    private static String getCacheKey(String userNo, String date) {
        DateTime dateTime = DateUtil.parse(date, yyyy_MM);
        return String.format("USER_SIGN_IN:%s:%s", userNo, dateTime.year() + "" + dateTime.monthBaseOne());
    }
}
