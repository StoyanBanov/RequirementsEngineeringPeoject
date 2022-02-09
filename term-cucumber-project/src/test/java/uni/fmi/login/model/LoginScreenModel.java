package uni.fmi.login.model;

import uni.fmi.login.service.LoginService;

public class LoginScreenModel {

	private String email;
	private String password;
	private String message;

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void cickLoginButton() {
		message = LoginService.login(email, password);
		
	}

	public String getMessage() {
		return message;
	}
}
