package com.yefeng.creation.factory.config_fatory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    private static Map<String, Coffee> map = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("yefeng.properties");
        try {
            properties.load(inputStream);
            Set<Object> keySet = properties.keySet();
            for (Object key : keySet) {
                String keyName = properties.getProperty((String) key);
                Class<?> clazz = Class.forName(keyName);
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
