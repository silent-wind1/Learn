package com.hmall.gateway.route;

import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.hmall.common.utils.CollUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * @Author: 叶枫
 * @Date: 2025/01/14/16:50
 * @Description:
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouteLoader {
    private final RouteDefinitionWriter writer;
    private final NacosConfigManager nacosConfigManager;
    // 保存更新过的路由id
    private final Set<String> routeIds = new HashSet<>();

    @PostConstruct
    public void initRouteConfigListener() throws NacosException {
        // 配置文件的dataId和group
        String DATA_ID = "gateway-routes.json";
        String GROUP = "DEFAULT_GROUP";
        String configInfo = nacosConfigManager.getConfigService()
                .getConfigAndSignListener(DATA_ID, GROUP, 5000, new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        updateConfigInfo(configInfo);
                    }
                });
        // 项目启动，更新一次配置
        updateConfigInfo(configInfo);
    }

    private void updateConfigInfo(String configInfo) {
        List<RouteDefinition> list = JSONUtil.toList(configInfo, RouteDefinition.class);
        // 删除旧的路由
        for (String id : routeIds) {
            writer.delete(Mono.just(id)).subscribe();
        }
        routeIds.clear();
        if (CollUtils.isEmpty(list)) {
            return;
        }
        // 路由更新
        list.forEach(routeDefinition -> {
            // 更新路由
            writer.save(Mono.just(routeDefinition)).subscribe();
            // 保存路由id
            routeIds.add(routeDefinition.getId());
        });
    }
}
