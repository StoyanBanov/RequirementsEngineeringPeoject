package uni.fmi.grade;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.grade.models.GradingScreenModel;

public class GradeSteps {
	
	private GradingScreenModel gradingScreenModel;

	@Given("^Администраторът отваря екрана за добавяне на оценка$")
	public void openGradeScreen() throws Throwable {
	    gradingScreenModel = new GradingScreenModel();
	}

	@When("^Въведе оценка: \"([^\"]*)\"$")
	public void addGrade(String value) throws Throwable {
		gradingScreenModel.setValue(Double.parseDouble(value));
	}

	@When("^Въведе имейл на ученик: \"([^\"]*)\"$")
	public void addEmail(String email) throws Throwable {
		gradingScreenModel.setEmail(email);
	}

	@When("^Въведе предмет: \"([^\"]*)\"$")
	public void addSubject(String subject) throws Throwable {
		gradingScreenModel.setSubject(subject);
	}

	@When("^Натисне бутон за добавяне$")
	public void clickAddButton() throws Throwable {
		gradingScreenModel.clickAddButton();
	}

	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, gradingScreenModel.getMessage());
	}
}
