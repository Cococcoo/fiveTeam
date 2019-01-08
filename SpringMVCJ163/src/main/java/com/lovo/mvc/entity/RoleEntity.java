package com.lovo.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * RoleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_role")

public class RoleEntity {


    // Fields    

     private String roleId;
     private String roleName;
     private String roleInfo;
     private Integer roleState;


 
   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="role_id", unique=true, nullable=false, length=32)

    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    @Column(name="role_name", length=64)

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    @Column(name="role_info", length=160)

    public String getRoleInfo() {
        return this.roleInfo;
    }
    
    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }
    
    @Column(name="role_state")

    public Integer getRoleState() {
        return this.roleState;
    }
    
    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }
   








}