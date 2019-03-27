package com.lee.study.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName Userrole
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:16
 */
@Data
@Entity
@Table(name = "userrole")
public class Userrole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private Integer roleid;
    private Date createtime;
    private Date updatetime;

}
