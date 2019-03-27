package com.lee.study.springboot.dao;

import com.lee.study.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName UserResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:19
 */
public interface UserResposity extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByName(@Param("username") String username);

}
