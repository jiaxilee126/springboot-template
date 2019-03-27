package com.lee.study.springboot.security;

import com.lee.study.springboot.dao.RoleResposity;
import com.lee.study.springboot.dao.UserResposity;
import com.lee.study.springboot.dao.UserroleResposity;
import com.lee.study.springboot.entity.Role;
import com.lee.study.springboot.entity.User;
import com.lee.study.springboot.entity.Userrole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/3/27 10:58
 */
@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserResposity userResposity;

    @Autowired
    private UserroleResposity userroleResposity;

    @Autowired
    private RoleResposity roleResposity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            log.error("{} 用户名不存在", username);
            throw  new UsernameNotFoundException("用户名不存在");
        }

        //数据库查出来用户
        User user = userResposity.findByName(username);
        //权限赋值
        Set<GrantedAuthority> authorities = new HashSet<>();

        List<Userrole> userroles = userroleResposity.findByUserid(user.getId());

        userroles.forEach( e -> {
            Optional optional = roleResposity.findById(e.getRoleid());
            Role role = (Role) optional.get();
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
