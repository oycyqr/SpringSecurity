package com.oycbest.service;

import com.oycbest.util.MD5Util;

/**
 * @Author: oyc
 * @Date: 2018/12/3 10:29
 * @Description: 密码加密类
 */
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {//user Details Service验证
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }

}