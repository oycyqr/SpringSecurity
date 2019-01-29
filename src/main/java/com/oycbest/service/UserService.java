package com.oycbest.service;

import com.oycbest.domain.User;
import com.oycbest.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oyc
 * @Date: 2019/1/29 14:19
 * @Description: 用户服务类
 */
@Service
public class UserService<T extends User> implements UserDetailsService {

    @Resource
    private UserRepository<User> repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = repository.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户名不存在");
            }
            //用户权限
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if (StringUtils.isNotBlank(user.getRoles())) {
                String[] roles = user.getRoles().split(",");
                for (String role : roles) {
                    if (StringUtils.isNotBlank(role)) {
                        authorities.add(new SimpleGrantedAuthority(role.trim()));
                    }
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}