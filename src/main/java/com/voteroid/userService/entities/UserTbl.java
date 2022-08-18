package com.voteroid.userService.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
@IdClass(UserTblPrimaryKey.class)
public class UserTbl implements Serializable{

	private static final long serialVersionUID = 1232908528895250989L;

	@Id
	@GeneratedValue(generator = "user-sequence-generator")
	@SequenceGenerator(name = "user-sequence-generator", sequenceName = "UserIdSequence", initialValue = 10000, allocationSize = 100)
	@Column(name="USER_ID")
	public int userId;
	
	@Id
	@Column(name="CLIENT_ID")
	private int clientId;
	
	@Column(name="USER_NAME",length=100)
	public String userName;
	
	@Column(name="USER_PHONE_NO",unique=true,length=10)
	public String userPhoneNo;
	
	@Column(name="USER_EMAIL_ID",unique=true,length=100)
	public String userEmailId;
	
	@Column(name="PASSWORD",length=100)
	public String password;
	
	@Column(name="USER_TYPE")
	public int userType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
}
