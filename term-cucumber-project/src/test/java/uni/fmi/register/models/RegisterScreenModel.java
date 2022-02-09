package uni.fmi.register.models;

import uni.fmi.register.service.RegisterService;

public class RegisterScreenModel {

	private String email;
	private String password;
	private String secondPassword;
	private String name;
	private String role ;
	private String message;

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	
	public void setSecondPassword(final String password) {
		this.secondPassword = password;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setRole(final String role) {
		this.role = role;
	}
	
	public void clickRegisterButton() {
		message = RegisterService.register(email, password, secondPassword, name, role);
	}

	public String getMessage() {
		return message;
	}

}
