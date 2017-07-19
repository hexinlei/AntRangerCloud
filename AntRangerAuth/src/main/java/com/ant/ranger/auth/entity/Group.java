package com.ant.ranger.auth.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @packgeName: com.ant.ranger.auth.entity
 * @ClassName: group
 * @copyright: Copyright 2016-2027 Markor Investment Group Co. LTD. All Rights Reserved.
 * @description:<描述>
 * @author: hexinlei
 * @date: 2017/6/29-下午1:01
 * @version: 1.0
 * @since: JDK 1.8
 */
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String code;

    @Column(name = "group_name",length = 50)
    private String groupname;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_members",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> groupMembers;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_authorities",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> groupAuthorities;

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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Set<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<User> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Set<Authority> getGroupAuthorities() {
        return groupAuthorities;
    }

    public void setGroupAuthorities(Set<Authority> groupAuthorities) {
        this.groupAuthorities = groupAuthorities;
    }

    public Group(String code, String groupname) {
        this.code = code;
        this.groupname = groupname;
    }

    public Group() {
    }
}
