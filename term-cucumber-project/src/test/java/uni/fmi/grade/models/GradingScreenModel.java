package uni.fmi.grade.models;

import uni.fmi.grade.service.GradingService;

public class GradingScreenModel {

	private Double value;
	private String email;
	private String subject ;
	private String message ;

	public void setValue(Double value) {
		this.value = value;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void clickAddButton() {
		message = GradingService.grade(value, email, subject);
	}

	public String getMessage() {
		return message;
	}

}
