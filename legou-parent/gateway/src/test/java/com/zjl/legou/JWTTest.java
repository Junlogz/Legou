package com.zjl.legou;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/3 19:12
 */
public class JWTTest {

    /****
     * 创建Jwt令牌
     */
    @Test
    public void testCreateJwt(){
        JwtBuilder builder= Jwts.builder()
                .setId("888") //设置唯一编号
                .setSubject("小白") //设置主题 可以是JSON数据
                .setIssuedAt(new Date()) //设置签发日期
                .signWith(SignatureAlgorithm.HS256,"zhangsan");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //构建 并返回一个字符串
        System.out.println( builder.compact() );
    }
}
