package com.simbirsoft.belousov.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "role")
    private RoleEntity role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private List<TaskEntity> tasks_author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "performerId")
    private List<TaskEntity> tasks_performer;


    public UserEntity(int userId, String name, String surname, RoleEntity role, List<TaskEntity> tasks_author, List<TaskEntity> tasks_performer) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.tasks_author = tasks_author;
        this.tasks_performer = tasks_performer;
    }

    public UserEntity() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<TaskEntity> getTasks_author() {
        return tasks_author;
    }

    public void setTasks_author(List<TaskEntity> tasks_author) {
        this.tasks_author = tasks_author;
    }

    public List<TaskEntity> getTasks_performer() {
        return tasks_performer;
    }

    public void setTasks_performer(List<TaskEntity> tasks_performer) {
        this.tasks_performer = tasks_performer;
    }
}
