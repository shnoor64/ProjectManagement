package com.simbirsoft.belousov.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserEntity> users;

    public RoleEntity(int roleId, String name, List<UserEntity> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }


    public RoleEntity() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
