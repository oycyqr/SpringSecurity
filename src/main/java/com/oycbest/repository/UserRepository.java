package com.oycbest.repository;

import com.oycbest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: oyc
 * @Date: 2019/1/29 14:34
 * @Description: 用户持久类
 */

@Repository
public interface UserRepository<T extends User>  extends JpaRepository<User, Integer> {
    /**
     * 根据用户名获取用户详情信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}