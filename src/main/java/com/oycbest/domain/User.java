package com.oycbest.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: oyc
 * @Date: 2019/1/29 14:20
 * @Description: 用户实体类
 */
@Data
@Entity
@Table(name = "user")
public class User implements Cloneable, Serializable {
    /**
     * 用户信息ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id ;

    /**
     * 登录名称
     */
    @Column(name = "username")
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    private String roles;
}