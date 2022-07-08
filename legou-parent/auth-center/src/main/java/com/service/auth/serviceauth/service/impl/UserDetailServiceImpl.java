package com.service.auth.serviceauth.service.impl;

import com.service.auth.serviceauth.client.UserClient;
import com.zjl.legou.security.po.Role;
import com.zjl.legou.security.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/9 21:49
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过feign调用用户微服务
        User user = userClient.getByUserName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user != null) {
            logger.debug("current user = " + user);
            // 获取用户的权限也就是角色
            List<Role> roles = userClient.selectRolesByUserId(user.getId());
            for (Role role : roles) {
                if (role != null && role.getName() != null) {
                    // spring security要求权限名称ROLE_ADMIN ROLE_MANAGER 有前缀ROLE
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }

}
