package com.voteroid.userService.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

public class UserTblPrimaryKey implements Serializable{
	
	private static final long serialVersionUID = 420852393704406628L;

	
	public int userId;
	
	private int clientId;

	
	
	

}
