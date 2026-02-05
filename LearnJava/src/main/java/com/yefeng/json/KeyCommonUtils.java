package com.yefeng.json;

import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @author wind
 * @description:
 * @date 2026/2/5 13:08
 */
@Slf4j
public class KeyCommonUtils {

    /**
     * 使用AES-128-CBC加密模式 pkcs#5补码方式
     * 向量iv 需16位
     *
     * @param content     需要加密的内容
     * @param securityKey 加密秘钥     utf-8编码格式16字节
     * @param cKey        设置向量iv的key值    utf-8编码格式16字节
     * @return
     */
    public static String encrypt(String content, String securityKey, String cKey) throws Exception {
        // 判断Key是否正确
        if (StringUtils.isEmpty(securityKey)) {
            return "加密秘钥为空";
        }
        // 判断Key是否为16位
        if (securityKey.length() != 16) {
            return "加密秘钥长度错误";
        }
        // 判断cKey是否为16位
        if (cKey.length() != 16) {
            return "初始向量长度错误";
        }
        byte[] raw = securityKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");//"算法/模式/补码方式"
        //IvParameterSpec iv = new IvParameterSpec(cKey.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        GCMParameterSpec ivSpec = new GCMParameterSpec(128, cKey.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return new Base64().encodeToString(encrypted);
    }


    /**
     * AES解密
     *
     * @param secCtx 密文
     * @param securityKey 加密秘钥  utf-8编码格式16字节
     * @param cKey 设置向量iv的key值   utf-8编码格式16字节
     *
     * @return
     */
    public static String decrypt(String secCtx, String securityKey, String cKey) throws Exception {
        try {
            // 判断Key是否正确
            if (StringUtils.isEmpty(securityKey)) {
                return "加密秘钥为空";
            }
            // 判断Key是否为16位
            if (securityKey.length() != 16) {
                return "加密秘钥长度错误";
            }
            // 判断cKey是否为16位
            if (cKey.length() != 16) {
                return "初始向量长度错误";
            }
            byte[] raw = securityKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec ivSpec = new GCMParameterSpec(128, cKey.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);
            byte[] encrypted1 = new Base64().decode(secCtx);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return new String(original, StandardCharsets.UTF_8);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw new Exception("解密失败", e);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new Exception(ex.getMessage(), ex);
        }
    }


    public static void main(String[] args) {
        try {
            String encrypt = encrypt("123456", "cpiQ6OBNIO6U#@..", "cpiJEUU7IQO2#@..");
            System.out.println(encrypt);
            String decrypt = decrypt(encrypt, "cpiQ6OBNIO6U#@..", "cpiJEUU7IQO2#@..");
            System.out.println(decrypt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
