package org.jbros.webro.models;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
	
	@JsonProperty("id")
	private String inputId;
	
	@JsonProperty("email")
	private String inputEmail;
	
	@JsonProperty("passwd")
	private String inputPassword;
	
	@JsonProperty("name")
	private String inputName;
	
	@JsonProperty("phone")
	private String inputPhone;
	
	@JsonProperty("birth")
	private String inputBirth;
	
	public MultipartFile getFileInput() {
		return fileInput;
	}

	public void setFileInput(MultipartFile fileInput) {
		this.fileInput = fileInput;
	}

	private MultipartFile fileInput;

	public String getInputId() {
		return inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputPhone() {
		return inputPhone;
	}

	public void setInputPhone(String inputPhone) {
		this.inputPhone = inputPhone;
	}

	public String getInputBirth() {
		return inputBirth;
	}

	public void setInputBirth(String inputBirth) {
		this.inputBirth = inputBirth;
	}
	
	


}
