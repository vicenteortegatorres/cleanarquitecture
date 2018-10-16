package com.coconutcode.user.adapter.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    public UserData(){
    }

    public UserData(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
