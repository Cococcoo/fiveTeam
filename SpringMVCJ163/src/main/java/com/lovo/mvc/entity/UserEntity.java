package com.lovo.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * UserEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_user")

public class UserEntity{


    // Fields    

     private String userId;
     private String userName;
     private String userPassword;
     private String userTel;
     private Integer userState;


   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="user_id", unique=true, nullable=false, length=32)

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="user_name", length=64)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_password", length=32)

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="user_tel", length=11)

    public String getUserTel() {
        return this.userTel;
    }
    
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
    
    @Column(name="user_state")

    public Integer getUserState() {
        return this.userState;
    }
    
    public void setUserState(Integer userState) {
        this.userState = userState;
    }
   








}