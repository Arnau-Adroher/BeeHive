package models;

import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements java.io.Serializable {
	
	/*
	 DROP DATABASE IF EXISTS lab2;

	CREATE DATABASE lab2; 

	USE lab2;
	DROP TABLE if exists users;
	CREATE TABLE `users` (   
  	`usrName` varchar(255) NOT NULL,    
  	`name` varchar(255) NOT NULL,    	 
  	`birthDate` varchar(255) NOT NULL,    
  	`pwd` varchar(255) NOT NULL,    
  	PRIMARY KEY (`usrName`)  
  	);
	*/
	
	private static final long serialVersionUID = 1L;
	
	private String userName = "";
	private String name = "";
	private String birthDate = "";
	private String pwd1 = "";
	private String pwd2 = "";
	private Integer id = 0;
	private Integer isAdmin = 0;
	private Integer likes = 0;
	private Integer followers = 0;
	private boolean isFollowed = false;
	
	private boolean[] error  = {false,false,false,false,false,false};
	
	public User() {
		
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIsAdmin() {
		return this.isAdmin;
	}
	
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		/*Check unique*/
		try {
			if(userName.matches("[a-zA-Z0-9._]{2,16}")){
					
				this.userName = userName;
					
				System.out.println(userName);
			}
			else {
				error[0] = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if(name.matches("[a-zA-Z0-9._]{2,16}")){
			this.name = name;
				
			System.out.println(name);
		}
		else {
			error[1] = true;
		}
		
	}
	
	public String getBirthDate() {
		return this.birthDate;
	}
	
	public void setBirthDate(String BirthDate) {
		Year currentYear = Year.now();
		int year = currentYear.getValue();
		if(year-Integer.valueOf(BirthDate) > 17) {
			this.birthDate = BirthDate;
			System.out.println(BirthDate);
		}
		else {
			error[2] = true;
		}
	}
	
	public String getPwd1() {
		return this.pwd1;
	}
	
	public void setPwd1(String pwd1) {
		if(pwd1.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
			this.pwd1 = pwd1;
		
		}
		else {
			error[3] = true;
		}
	}
	
	public String getPwd2() {
		return this.pwd2;
	}
	
	public void setPwd2(String pwd2) {
		if(pwd2.equals(this.pwd1)) {
			this.pwd2 = pwd2;
			System.out.println(pwd2);
		}
		else {
			error[4] = true;
		}
	}
	
	public Integer getLikes() {
		return this.likes;
	}
	
	
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	public Integer getFollowers() {
		return this.followers;
	}
	
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	
	public Boolean getIsFollowed() {
		return this.isFollowed;
	}
	
	public void setIsFollowed(Boolean isFollowed) {
		this.isFollowed = isFollowed;
	}
	
	public boolean[] getError() {
		return error;
	}
		
}
