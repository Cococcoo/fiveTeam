package com.lovo.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * PowerEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_power")

public class PowerEntity{


    // Fields    

     private String powerId;
     private String powerName;
     private String powerResource;
     private String powerMessage;
     private String powerTag;
     private Integer powerState;


    @GenericGenerator(name="generator", strategy="uuid")@Id @GeneratedValue(generator="generator")
    
    @Column(name="power_id", unique=true, nullable=false, length=32)

    public String getPowerId() {
        return this.powerId;
    }
    
    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }
    
    @Column(name="power_name", length=64)

    public String getPowerName() {
        return this.powerName;
    }
    
    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
    
    @Column(name="power_resource", length=240)

    public String getPowerResource() {
        return this.powerResource;
    }
    
    public void setPowerResource(String powerResource) {
        this.powerResource = powerResource;
    }
    
    @Column(name="power_message", length=240)

    public String getPowerMessage() {
        return this.powerMessage;
    }
    
    public void setPowerMessage(String powerMessage) {
        this.powerMessage = powerMessage;
    }
    
    @Column(name="power_tag", length=1)

    public String getPowerTag() {
        return this.powerTag;
    }
    
    public void setPowerTag(String powerTag) {
        this.powerTag = powerTag;
    }
    
    @Column(name="power_state")

    public Integer getPowerState() {
        return this.powerState;
    }
    
    public void setPowerState(Integer powerState) {
        this.powerState = powerState;
    }
   








}