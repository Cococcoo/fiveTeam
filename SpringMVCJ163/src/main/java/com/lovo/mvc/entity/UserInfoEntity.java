package com.lovo.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_info")
public class UserInfoEntity {
    @Id
    @Column(length=32)
    @GenericGenerator(name="infouuid",strategy="uuid")
    @GeneratedValue(generator="infouuid")
	private String infoId;
    @Column(length=48)
	private String  createDate;
    @Column(length=48)
	private String info;
	@ManyToOne
	@JoinColumn(name="user_id")
    private UserEntity user;
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
    
	
	
}
