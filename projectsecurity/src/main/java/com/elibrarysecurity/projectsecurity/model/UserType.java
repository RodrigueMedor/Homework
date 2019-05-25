package com.elibrarysecurity.projectsecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roles")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="userTypeName", nullable=true)
    private String userTypeName;


//    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
//    private List<User> users = new ArrayList<User>();


//    public List<User> getUsers() {
//        return users;
//    }

//    public void setUsers(List<User> users) {
////        this.users = users;
////    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

}
