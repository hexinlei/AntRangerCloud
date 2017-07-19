package com.ant.ranger.auth.repository;

import com.ant.ranger.auth.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @packgeName: com.ant.ranger.auth.repository
 * @ClassName: UserRepository
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/6/29-下午6:52
 * @version: 1.0
 * @since: JDK 1.8
 */
public interface UserRepository extends CrudRepository<User,Integer>{

    User findUserByUsername(String username);
}
