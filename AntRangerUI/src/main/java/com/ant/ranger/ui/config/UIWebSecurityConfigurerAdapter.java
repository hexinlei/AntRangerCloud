package com.ant.ranger.ui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @packgeName: com.ant.ranger.ui.config
 * @ClassName: UIWebSecurityConfigurerAdapter
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/7/13-下午6:32
 * @version: 1.0
 * @since: JDK 1.8
 */
//@EnableOAuth2Sso
public class UIWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","login**").permitAll()
                .anyRequest().authenticated();
    }

//    @Bean
//    public RequestContextListener requestContextListener(){
//        return new RequestContextListener();
//    }
}
