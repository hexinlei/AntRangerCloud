package com.ant.ranger.auth.service.impl;

import com.ant.ranger.auth.data.MyClientDetail;
import com.ant.ranger.auth.entity.OAuthClientDetail;
import com.ant.ranger.auth.service.ClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @packgeName: com.ant.ranger.auth.service.impl
 * @ClassName: ClientDetailServiceImpl
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/7/4-下午6:26
 * @version: 1.0
 * @since: JDK 1.8
 */
@Service("clientDetailService")
public class ClientDetailServiceImpl implements ClientDetailService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
//        OAuthClientDetail authClientDetail = oauthClientDetailRepository.findByClientId(s);


        OAuthClientDetail authClientDetail = findByClientId(s);

        if (null == authClientDetail){
            throw new ClientRegistrationException("无效的Client ID");
        }
        return new MyClientDetail(authClientDetail);
    }


    /**
     * 查询clientDetail
     * @param clientId
     * @return
     */
    protected OAuthClientDetail findByClientId(String clientId){
        Object args [] = {clientId};

        final OAuthClientDetail clientDetail = jdbcTemplate.queryForObject("select client_id,client_secret,scope,authorized_grant_types from oauth_client_details where client_id =?", args, new RowMapper<OAuthClientDetail>() {
            @Override
            public OAuthClientDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                OAuthClientDetail client = new OAuthClientDetail();
                client.setClientID(resultSet.getString(1));
                client.setClientSecret(resultSet.getString(2));
                client.setScope(resultSet.getString(3));
                client.setGrantType(resultSet.getString(4));
                return client;
            }
        });
        return clientDetail;
    }
}
