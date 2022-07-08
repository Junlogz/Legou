package com.service.auth.serviceauth.interceptor;

import com.service.auth.serviceauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/19 20:41
 */
@Component
public class TokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = null;
        try {
            token = AdminToken.adminToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
