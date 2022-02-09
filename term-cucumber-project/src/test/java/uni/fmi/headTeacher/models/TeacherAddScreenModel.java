package uni.fmi.headTeacher.models;

import uni.fmi.headTeacher.service.HeadTeacherService;

public class TeacherAddScreenModel {

	private String classRoom;
	private String teacher;
	private String message;

	public void setClass(final String classRoom) {
		this.classRoom = classRoom;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void clickAddButton() {
		message = HeadTeacherService.addTeacher(classRoom, teacher);
	}

	public Object getMessage() {
		return message;
	}

}
