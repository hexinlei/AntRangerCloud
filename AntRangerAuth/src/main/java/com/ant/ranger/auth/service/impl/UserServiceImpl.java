package com.ant.ranger.auth.service.impl;

import com.ant.ranger.auth.data.MyUserData;
import com.ant.ranger.auth.entity.User;
import com.ant.ranger.auth.repository.UserRepository;
import com.ant.ranger.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @packgeName: com.ant.ranger.auth.service.impl
 * @ClassName: UserServiceImpl
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/7/13-下午1:33
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(s);

        if (null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new MyUserData(user);
    }
}
