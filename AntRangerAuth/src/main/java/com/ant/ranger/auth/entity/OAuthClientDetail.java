package com.ant.ranger.auth.entity;

/**
 * @packgeName: com.ant.ranger.auth.entity
 * @ClassName: OAuthClientDetail
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/7/4-下午6:15
 * @version: 1.0
 * @since: JDK 1.8
 */
public class OAuthClientDetail {

    private String clientID;
    private String clientSecret;
    private String grantType;
    private String scope;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
