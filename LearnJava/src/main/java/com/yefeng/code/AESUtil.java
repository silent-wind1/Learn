package com.yefeng.code;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESUtil {

    // 指定 AES 算法
    private static final String AES = "AES";
    // ECB 模式 + PKCS5 填充
    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    // 密钥长度  128、192 或 256
    private static final int AES_KEY_SIZE = 256;

    /**
     * **生成 AES 密钥**
     */
    public static String generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(AES_KEY_SIZE, new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * AES 加密
     */
    public static String encrypt(String data, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), AES);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // Base64 编码
    }

    /**
     * **AES 解密**
     */
    public static String decrypt(String encryptedData, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), AES);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    // 测试
    public static void main(String[] args) {
        try {
            String data = "Hello, AES!";

            // **生成密钥**
            String secretKey = generateKey();
            System.out.println("AES 密钥: " + secretKey);

            // **加密**
            String encryptedData = encrypt(data, secretKey);
            System.out.println("加密后: " + encryptedData);

            // **解密**
            String decryptedData = decrypt("ff67843586fb345a01c882a138dfb02644cac3860d8c9cd0f13a04376427b052", secretKey);
            System.out.println("解密后: " + decryptedData);
        } catch (Exception e) {
            System.out.println("加密解密失败");
        }
    }
}
