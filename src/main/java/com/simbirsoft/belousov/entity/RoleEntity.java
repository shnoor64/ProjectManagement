package com.simbirsoft.belousov.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Set<UserEntity> users;

    public RoleEntity(int roleId, String name, Set<UserEntity> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }

    public RoleEntity(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
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

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }
}
