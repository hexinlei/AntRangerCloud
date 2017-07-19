package com.ant.ranger.auth.data;

import com.ant.ranger.auth.entity.OAuthClientDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

/**
 * @packgeName: com.ant.ranger.auth.data
 * @ClassName: MyClientDetail
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/7/13-下午2:03
 * @version: 1.0
 * @since: JDK 1.8
 */
public class MyClientDetail implements ClientDetails{

    private OAuthClientDetail clientDetail;

    public MyClientDetail(OAuthClientDetail clientDetail) {

        this.clientDetail = clientDetail;
    }

    @Override
    public String getClientId() {
        return clientDetail.getClientID();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientDetail.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        String scopes[] = clientDetail.getScope().split(",");
        return new HashSet<String>(Arrays.asList(scopes));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        String grantType[] = clientDetail.getGrantType().split(",");
        return new HashSet<String>(Arrays.asList(grantType));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
