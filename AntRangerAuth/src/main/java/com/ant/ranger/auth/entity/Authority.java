package com.ant.ranger.auth.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @packgeName: com.ant.ranger.auth.entity
 * @ClassName: Authority
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/6/29-下午1:21
 * @version: 1.0
 * @since: JDK 1.8
 */
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String code;

    private String cnDesc;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "authorities",
            joinColumns = @JoinColumn(name="authority_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    private Set<User> users;


    @ManyToMany(mappedBy = "code",cascade = CascadeType.ALL)
    private Set<Group> authorityGroups;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCnDesc() {
        return cnDesc;
    }

    public void setCnDesc(String cnDesc) {
        this.cnDesc = cnDesc;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getAuthorityGroups() {
        return authorityGroups;
    }

    public void setAuthorityGroups(Set<Group> authorityGroups) {
        this.authorityGroups = authorityGroups;
    }

    public Authority(String code, String cnDesc) {
        this.code = code;
        this.cnDesc = cnDesc;
    }

    public Authority() {
    }
}
