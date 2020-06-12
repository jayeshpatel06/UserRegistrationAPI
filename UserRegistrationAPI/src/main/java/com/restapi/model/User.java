/**
* @author  Jayesh Patel
*/

package com.restapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="USER")
@ApiModel
public class User implements Serializable{

	private static final long serialVersionUID = -5104979996635398511L;

	@Id
	@GeneratedValue
	@ApiModelProperty(hidden=true)
	private long id;
	
	@NotBlank(message="Username is Required")
    @Column(name = "username")
	@Size(max=100)
	@ApiModelProperty(position = 1, required = true)
	private String userName;
	
	@Digits(fraction = 0, integer = 6, message="Pin is not valid length")
	@ApiModelProperty(position = 2, required = true)
	private int pin;
	
	@NotBlank(message="EmailId cannot be blank")
	@Email(message="Enter valid EmailId")
	@Column(name = "emailid")
	@ApiModelProperty(position = 3, required = true)
	private String emailId;
	
	@Column(name = "mobilenumber")
	@Digits(fraction = 0, integer = 10, message="MobileNumber is not valid length")
	@ApiModelProperty(position = 4, required = true)
	private Long mobileNumber;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, int pin, String emailId, Long mobileNumber) {
		super();
		this.userName = userName;
		this.pin = pin;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
