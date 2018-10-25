package com.troytan.sixpack.util;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESUtils {

    /**
     * aes解密
     *
     * @author troytan
     * @date 2018年7月9日
     * @param encryptedData 加密数据
     * @param iv 解密向量
     * @param sessionKey 解密key
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedData, String iv, String sessionKey) throws Exception {

        Decoder decoder = Base64.getDecoder();
        byte[] keyBytes = decoder.decode(sessionKey);
        byte[] contentBytes = decoder.decode(encryptedData);
        byte[] ivBytes = decoder.decode(iv);

        Key keySpec = new SecretKeySpec(keyBytes, "AES");
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(ivBytes));
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");

        cipher.init(Cipher.DECRYPT_MODE, keySpec, params);
        return new String(cipher.doFinal(contentBytes), "utf-8");
    }

    public static void main(String[] args) throws Exception {
         String sessionKey ="VHQ5myeI80LrSz4pEPixrw==";
         String encryptedData=
         "cy7BkSSfMC6ZqTIC/JmDAmJFCaavcT8d6DuscOQdci+CqY6Cidl6FM622zua3oubDxHxHHDi/k2PVA06UNmB2DoD262IJ9d0TKtqOh53drK9d1eJAS6LBz9jr8R/Wl7Yn6rStQRcKI3j5limFi7KNg==";
         String iv= "0UF5ABuTzWboP12o1xH+zA==";
        
         System.out.println(decrypt(encryptedData, iv, sessionKey));
    }

}
