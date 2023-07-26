package com.validation.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {

	//this annotation used to give validations but not trigger unless we add valid annotation in mycontroller
	@NotBlank(message="User Name can not be empty !!")
	@Size(min=3,max=12,message="User Name must be between 3-12 chracters !!")
	private String userName;
	
	//email should match with regexp
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Invalid Email !!")
	private String email;
	
	@AssertTrue(message="Must agree terms and condition")
	private boolean agreed;
	
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
