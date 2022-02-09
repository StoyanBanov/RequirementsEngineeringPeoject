package uni.fmi.register;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.register.models.RegisterScreenModel;

public class RegisterSteps {
	
	private RegisterScreenModel registerScreenModel;

	@Given("^Администраторът отваря екрана за регистрация$")
	public void openRegisterScreen() throws Throwable {
	    registerScreenModel = new RegisterScreenModel();
	}

	@When("^Въведе имейл \"([^\"]*)\" в полето имейл$")
	public void addEmail(final String email) throws Throwable {
		registerScreenModel.setEmail(email);
	}

	@When("^Въведе парола \"([^\"]*)\" в полето парола$")
	public void addPassword(final String password) throws Throwable {
		registerScreenModel.setPassword(password);
	}

	@When("^Въведе парола \"([^\"]*)\" в полето за втора парола$")
	public void addSecondPassword(final String password) throws Throwable {
		registerScreenModel.setSecondPassword(password);
	}

	@When("^Въведе име \"([^\"]*)\" в полето за име$")
	public void addName(final String name) throws Throwable {
		registerScreenModel.setName(name);
	}

	@When("^Въведе роля \"([^\"]*)\" в полето за роля$")
	public void addRole(final String role) throws Throwable {
		registerScreenModel.setRole(role);
	}
	
	@When("^Натисне бутон за регистрация$")
	public void clickRegisterButton() throws Throwable {
		registerScreenModel.clickRegisterButton();
	}

	@Then("^Вижда съобщение \"([^\"]*)\" in step$")
	public void checkMessage(final String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, registerScreenModel.getMessage()); 
	}
}
