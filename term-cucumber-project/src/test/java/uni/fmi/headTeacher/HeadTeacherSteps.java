package uni.fmi.headTeacher;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.headTeacher.models.TeacherAddScreenModel;

public class HeadTeacherSteps {
	
	private TeacherAddScreenModel teacherAddScreenModel;

	@Given("^Администраторът отваря екран за добавяне на класен ръководител$")
	public void openAddScreen() throws Throwable {
	    teacherAddScreenModel = new TeacherAddScreenModel();
	}
	
	@When("^Избере клас: \"([^\"]*)\"$")
	public void chooseClass(final String classRoom) throws Throwable {
		teacherAddScreenModel.setClass(classRoom);
	}

	@When("^Избере учител: \"([^\"]*)\"$")
	public void chooseTeacher(final String teacher) throws Throwable {
		teacherAddScreenModel.setTeacher(teacher);
	}

	@When("^Натисне бутон за добавяне$")
	public void clickAddButton() throws Throwable {
		teacherAddScreenModel.clickAddButton();
	}

	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(final String message) throws Throwable {
	    assertEquals(message, teacherAddScreenModel.getMessage());
	}
}
