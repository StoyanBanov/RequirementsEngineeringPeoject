package uni.fmi.gradeCheck;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.gradeCheck.models.GradeCheckScreenModel;

public class GradeCheckSteps {
	
	private GradeCheckScreenModel gradeCheckScreenModel;
	
	@Given("^отваря екран за достъп до оценки на дете$")
	public void openGradeCheckScreen() throws Throwable {
		gradeCheckScreenModel = new GradeCheckScreenModel();
	}

	@Given("^Потребителят има роля: \"([^\"]*)\"$")
	public void hasParentRole(String role) throws Throwable {
		gradeCheckScreenModel.setRole(role);
	}

	@When("^Въведе имейл на дете: \"([^\"]*)\";$")
	public void addEmail(String email) throws Throwable {
		gradeCheckScreenModel.setEmail(email);
	}

	@When("^Натисне бутон за проверка$")
	public void clickCheckButton() throws Throwable {
		gradeCheckScreenModel.clickCheckButton();
	}

	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(String message) throws Throwable {
		assertEquals(message, gradeCheckScreenModel.getMessage());
	}
}
