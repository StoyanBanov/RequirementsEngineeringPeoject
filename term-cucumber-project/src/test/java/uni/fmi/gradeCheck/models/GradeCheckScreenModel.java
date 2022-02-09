package uni.fmi.gradeCheck.models;

import uni.fmi.gradeCheck.service.GradeCheckService;

public class GradeCheckScreenModel {

	private String email;
	private String message;
	private String role ;

	public void setRole(final String role) {
		this.role = role;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void clickCheckButton() {
		message = GradeCheckService.checkGrades(email, message, role);
	}

	public String getMessage() {
		return message;
	}

}
