package com.service.auth.serviceauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/11 19:35
 */
public class JWTTest {

    @Test
    public void testCreateJwt() throws Exception {
        // 存储密钥的工厂对象
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("legoushop.jks"), "legoushop".toCharArray());
        // 密钥对 公钥 -> 私钥
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("legoushop", "legoushop".toCharArray());
        // 私钥
        RSAPrivateCrtKey privateCrtKey = (RSAPrivateCrtKey) keyPair.getPrivate();
        // 自定义payload
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", 123);
        tokenMap.put("name", "legoushop");
        tokenMap.put("role", "r01, r02, admin");
        // 使用工具类 通过私钥颁发JWT令牌
        Jwt jwt = JwtHelper.encode(new ObjectMapper().writeValueAsString(tokenMap), new RsaSigner(privateCrtKey));
        String token = jwt.getEncoded();
        System.out.println(token);
    }

    @Test
    public void testVerify() {
        // 生成的令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTMwNDA3MTYsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9NQU5BR0VSIiwiUk9MRV9BRE1JTiJdLCJqdGkiOiIyMmU4YjBlMi00YTdiLTRiNTQtOTgzOC00MGIxMDVlNjA5MjgiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJyZWFkIl19.EtaGLdOZ6WbQ8CoT7wm6gheeAaLehiD0dJq8CgNMXx8BEsczds7cZO7SA4rJ8WwcxMFGMUULY5zN7MbkN3qTaldQHGFIvA7aK7x5wvsns3XTad4Y3qVzMZilNRARgaB5kB3v7_-Zf8SDadd6WRzyGYZutSg1cw1ifgjtiyxK-jDEw1Rdjiu0oioXQ7ANtDPrijxVK92Tjtp6I-iyd-FsggjJOFP2WBEssiuH--o33OBQYnSzzOVPJ4Pdk4zS7ixd_L0YK10YI5ac4PUxQHJnwRpQtk2Bh2jDDTEges20S_1uN6bycZInSFbX_baCgGc9GM0l6qyiwjj68WshRitfpw";

        // 公钥
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtO+x+TFydXj2Q0JRhmR/\n" +
                "6R9LRPk0WEGaGy4H3gp/jxUU174SzqtriMpuFGO6ULh1iDvebaFQO8IJtH3ZMYQk\n" +
                "MCTPp1KraJm4x1KV8MzYvYPqNGVIcX+yXJKpgWWKT2bIoOjoIGyr1YEyO/Z6Un6r\n" +
                "khjfu2XH/4MUskRA0q8HTw0gQHUzq473VcZHaKGqPWhhdpLY+QfBkg2jwj5X+Wpn\n" +
                "5fqSpnpnbBpXEPLw00rM1jBzdHh2ybC25cZpLOGuHRrnoVR3NmgSTUpd4vQbChHg\n" +
                "D8VdXrpTMBpQVb9ngtklXS2a49lT81pZFq4pdRVo55mHIgZRy9C8dfrkbs7LBj4e\n" +
                "eQIDAQAB\n" +
                "-----END PUBLIC KEY-----";

        //校验令牌
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publicKey));
        String claims = jwt.getClaims();
        System.out.println(claims);

        try {
            Map<String, String> map = new ObjectMapper().readValue(claims,Map.class);
            System.out.println(map.get("user_name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateAdminJwt() throws Exception {
        // 存储密钥的工厂对象
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("legoushop.jks"), "legoushop".toCharArray());
        // 密钥对 公钥 -> 私钥
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("legoushop", "legoushop".toCharArray());
        // 私钥
        RSAPrivateCrtKey privateCrtKey = (RSAPrivateCrtKey) keyPair.getPrivate();
        // 自定义payload
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("user_name", "admin");
        tokenMap.put("client_id", "client");
        tokenMap.put("authorities", new String[] {"ROLE_ADMIN"});
        // 使用工具类 通过私钥颁发JWT令牌
        Jwt jwt = JwtHelper.encode(new ObjectMapper().writeValueAsString(tokenMap), new RsaSigner(privateCrtKey));
        String token = jwt.getEncoded();
        System.out.println(token);
    }
}