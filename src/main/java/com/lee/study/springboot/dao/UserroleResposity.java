package com.lee.study.springboot.dao;

import com.lee.study.springboot.entity.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName UserroleResposity
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 11:20
 */
public interface UserroleResposity extends JpaRepository<Userrole, Integer> {

    @Query(name = "Select * from userrole where userid=:userid", nativeQuery = true)
    List<Userrole> findByUserid(@Param("userid") Integer userid);
}
