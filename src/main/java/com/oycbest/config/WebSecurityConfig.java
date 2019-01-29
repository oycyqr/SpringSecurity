package com.oycbest.config;

import com.oycbest.domain.User;
import com.oycbest.service.PasswordEncoder;
import com.oycbest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * @Author: oyc
 * @Date: 2019/1/29 13:45
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService<User> userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许基于HttpServletRequest使用限制访问
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/home","/toLogin","/**/customer/**").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**", "/fronts/**", "/doc/**", "/toLogin").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER")
                //.hasIpAddress()//读取配置权限配置
                .antMatchers("/**").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                //自定义登录界面
                .and().formLogin().loginPage("/toLogin").loginProcessingUrl("/login").failureUrl("/toLogin?error").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedPage("/toLogin?deny")
                .and().httpBasic()
                .and().sessionManagement().invalidSessionUrl("/toLogin")
                .and().csrf().disable();
    }
}