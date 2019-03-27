package com.lee.study.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Role
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:14
 */
@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean available;
    private Date createtime;
    private Date updatetime;

}
