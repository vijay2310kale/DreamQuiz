package com.dreamQuiz.android.DreamQuizAndroid.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Registration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long user_id;
	
	 @Column(name = "username") 
		private String username;

	 
	 @Column(name="phone_no")
	 private String phone_no;
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="password")
	 private String password;
	 
	 
	 @Column(name="referal_contact")
	 private String referal_contact;


	 @Column(name="otp")
	 private String otp;


	 
	 @Column(name="device_token")
	 private String device_token;

	 
	 @Column(name="device_type")
	 private String device_type;
	 
	 @Column(name="token")
	 private String token;

	 @Column(name="datetimespan")
	 private String datetimespan;

	 
	 
	 public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getReferal_contact() {
		return referal_contact;
	}


	public void setReferal_contact(String referal_contact) {
		this.referal_contact = referal_contact;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public String getDevice_token() {
		return device_token;
	}


	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}


	public String getDevice_type() {
		return device_type;
	}


	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	 
	 
	 
	
}
