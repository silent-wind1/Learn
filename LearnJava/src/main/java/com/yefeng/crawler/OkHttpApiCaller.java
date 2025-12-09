package com.yefeng.crawler;

import okhttp3.*;

public class OkHttpApiCaller {
    private final OkHttpClient client = new OkHttpClient();
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36 Edg/143.0.0.0";

    public String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", USER_AGENT)
                .addHeader("Cookie", "Hm_lvt_8ee20a2aadd523108b16b796c34c9ffa=1765248463,1765248656,1765248665; HMACCOUNT=B24BD4F22A123095; Hm_lpvt_8ee20a2aadd523108b16b796c34c9ffa=1765248943")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("请求失败" + response);
                return null;
//                throw new RuntimeException("请求失败: " + response);
            }
            return response.body().string();
        }
    }

    public String post(String url, String json) throws Exception {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder().url(url).post(body).header("User-Agent", USER_AGENT).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("请求失败: " + response);
            }
            return response.body().string();
        }
    }
}