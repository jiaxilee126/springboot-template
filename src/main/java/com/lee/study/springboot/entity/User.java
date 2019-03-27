package com.lee.study.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName User
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:09
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
}
