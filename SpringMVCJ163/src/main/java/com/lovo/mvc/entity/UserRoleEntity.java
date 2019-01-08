package com.lovo.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * UserRoleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_user_role")

public class UserRoleEntity  {


    // Fields    

     private String userRoleId;
     private UserEntity user;
     private RoleEntity role;


    // Constructors

    /** default constructor */
    public UserRoleEntity() {
    }

   
   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="user_role_id", unique=true, nullable=false, length=32)

    public String getUserRoleId() {
        return this.userRoleId;
    }
    
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }


   @ManyToOne
   @JoinColumn(name="user_id")
	public UserEntity getUser() {
		return user;
	}



	public void setUser(UserEntity user) {
		this.user = user;
	}


   @ManyToOne
   @JoinColumn(name="role_id")
	public RoleEntity getRole() {
		return role;
	}



	public void setRole(RoleEntity role) {
		this.role = role;
	}
    
   
}