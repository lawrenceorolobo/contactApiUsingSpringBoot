package com.lawrenceorolobo.contactapi.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String userFirstName;

    private String userLastName;

    @Column(unique = true)
    private String userUniqueName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserUniqueName() {
        return userUniqueName;
    }

    public void setUserUniqueName(String userUniqueName) {
        this.userUniqueName = userUniqueName;
    }

}
