package com.ant.ranger.auth;

import com.ant.ranger.auth.entity.Authority;
import com.ant.ranger.auth.entity.Group;
import com.ant.ranger.auth.entity.User;
import com.ant.ranger.auth.repository.AuthorityRepository;
import com.ant.ranger.auth.repository.GroupRepository;
import com.ant.ranger.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @packgeName: PACKAGE_NAME
 * @ClassName: AuthServerApplaction
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/6/29-下午1:53
 * @version: 1.0
 * @since: JDK 1.8
 */
@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class AuthServerApplaction {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @RequestMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }

    @RequestMapping("/public/test")
    public Object test(){
        try{
            User user = new User("admin","admin",Boolean.TRUE);
            Authority authority = new Authority("ADMIN","管理员");
            Group group = new Group("ADMINGROUP","管理员组");

            Set<User> users = new HashSet<User>();
            users.add(user);

            Set<Authority> authorities = new HashSet<Authority>();
            authorities.add(authority);

            user.setAuthorities(authorities);

            authority.setUsers(users);

            group.setGroupAuthorities(authorities);

            group.setGroupMembers(users);


            userRepository.save(user);
            authorityRepository.save(authority);
            groupRepository.save(group);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "hello,world test";
    }




    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplaction.class,args);
    }
}
