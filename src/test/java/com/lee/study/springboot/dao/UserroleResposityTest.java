package com.lee.study.springboot.dao;

import com.lee.study.springboot.SpringbootApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserroleResposityTest extends SpringbootApplicationTests{

    @Autowired
    private UserroleResposity userroleResposity;

    @Test
    public void findByUserId() throws Exception {
        System.out.println(userroleResposity.findByUserid(1));
    }


}