package com.lee.study.springboot.dao;

import com.lee.study.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RoleResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:20
 */
public interface RoleResposity extends JpaRepository<Role, Integer> {
}
