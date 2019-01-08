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
 * RolePowerEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_role_power")

public class RolePowerEntity  {


    // Fields    

     private String rolePowerId;
     private RoleEntity role;
     private PowerEntity power;

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="role_power_id", unique=true, nullable=false, length=32)

    public String getRolePowerId() {
        return this.rolePowerId;
    }
    
    public void setRolePowerId(String rolePowerId) {
        this.rolePowerId = rolePowerId;
    }
    @ManyToOne
    @JoinColumn(name="role_id")
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
   @ManyToOne
   @JoinColumn(name="power_id")
	public PowerEntity getPower() {
		return power;
	}

	public void setPower(PowerEntity power) {
		this.power = power;
	}
    
 
   








}