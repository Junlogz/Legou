package com.service.auth.serviceauth.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import
        org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/19 20:22
 */
public class AdminToken {

    public static String adminToken() throws IOException {
        //证书⽂件
        String key_location = "legoushop.jks";
        //密钥库密码
        String keystore_password = "legoushop";
        //访问证书路径
        ClassPathResource resource = new ClassPathResource(key_location);
        //密钥⼯⼚
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, keystore_password.toCharArray());
        //密钥的密码，此密码和别名要匹配
        String keypassword = "legoushop";
        //密钥别名
        String alias = "legoushop";
        //密钥对（密钥和公钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias,
                keypassword.toCharArray());
        //私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //定义payload信息
        Map<String, Object> tokenMap = new HashMap<String, Object>();
        tokenMap.put("user_name", "admin");
        tokenMap.put("client_id", "client");
        tokenMap.put("authorities", new String[] {"ROLE_ADMIN"});
        //⽣成jwt令牌
        Jwt jwt = JwtHelper.encode(new ObjectMapper().writeValueAsString(tokenMap), new RsaSigner(aPrivate));
        //取出jwt令牌
        String token = jwt.getEncoded();
        return token;
    }

}
