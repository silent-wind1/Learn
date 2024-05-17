package com.yefeng.demo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;

public class Test {
    public static void main(String[] args) {
        GeneratorEditRequest generatorEditRequest = new GeneratorEditRequest();
        generatorEditRequest.setId(12L);
        editGenerator(generatorEditRequest, GeneratorEditRequest.class);
    }

    public static <E> Generator editGenerator(E object, Class<E> clazz) {
        Generator generator = new Generator();
        System.out.println(object);
        Long id;
        try {
            id = (Long) object.getClass().getMethod("getId").invoke(object);
            System.out.println(object);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (object == null || id <= 0) {

        }
        generator.setTags(JSONUtil.toJsonStr(generator.getTags()));
        generator.setFileConfig(JSONUtil.toJsonStr(generator.getFileConfig()));
        generator.setModelConfig(JSONUtil.toJsonStr(generator.getModelConfig()));
        return generator;

    }
}
