package com.look.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * AES加密工具类
 *
 * @author wenxing.liang
 * @date 2019/09/07
 */
public class AESHexUtil {

    /**
     * AES加密算法
     */
    private static final String ALGORITHM_AES = "AES";

    /**
     * 私有构造函数，工具类不可被实例化
     *
     */
    private AESHexUtil() {}

    /**
     * 随机生成密钥
     * 
     * @return
     */
    public static String createSecretKey() throws Exception {
        // KeyGenerator提供对称密钥生成器的功能，支持各种算法
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);

        // SecretKey负责保存对称密钥
        SecretKey deskey = keygen.generateKey();
        byte[] key = deskey.getEncoded();
        return Base64.encodeBase64String(key);
    }

    /**
     * base64编码AES加密后的字符串
     *
     * @param content 需要加密的字符串
     * @param strKey 秘钥key
     * @return 经过base64编码后的AES加密的字符串
     */
    public static String encryptBase64DecorateAES(String content, String strKey) throws Exception {
        byte[] encryptAESbytes = encrypt(content, strKey);
        return Base64.encodeBase64String(encryptAESbytes);
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param strKey 加密秘钥
     * @return 加密后的比特流
     */
    private static byte[] encrypt(String content, String strKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(strKey), ALGORITHM_AES);
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);

        byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);

        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // 加密
        return cipher.doFinal(byteContent);
    }

    /**
     * 解密经过base64编码后的AES加密过的字符串
     *
     * @param content 待解密的经过base64编码后的AES加密过的字符串
     * @param strKey 秘钥种子
     */
    public static String decryptBase64DecorateAES(String content, String strKey) throws Exception {
        byte[] decryptResult = decrypt(content, strKey);
        return decryptResult == null ? null : new String(decryptResult);
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param strKey 解密密钥
     * @return 解密后的
     */
    private static byte[] decrypt(String content, String strKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(strKey), ALGORITHM_AES);
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);

        // 初始化
        cipher.init(Cipher.DECRYPT_MODE, key);

        // 转码
        byte[] encrypted = Base64.decodeBase64(content);

        // 解密
        return cipher.doFinal(encrypted);
    }

}