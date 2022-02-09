package uni.fmi.login;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.login.model.LoginScreenModel;

public class LoginSteps {
	
	private LoginScreenModel loginModel;

	@Given("^Потребителят отваря екрана за вход в ситемата$")
	public void openLoginScreen() throws Throwable {
	    loginModel = new LoginScreenModel();
	}
	
	@When("^Въведе \"([^\"]*)\" имейл адрес$")
	public void addEmail(final String email) throws Throwable {
		loginModel.setEmail(email);
	}
	
	@When("^въведе \"([^\"]*)\" парола$")
	public void addPassword(String password) throws Throwable {
	    loginModel.setPassword(password);
	}
	
	@When("^натисне бутона за вход в системата$")
	public void clickLoginButton() throws Throwable {
	    loginModel.cickLoginButton();
	}
	
	@Then("^Вижда съжбщение: \"([^\"]*)\"$")
	public void checkMessage(String expectedMessage) throws Throwable {
	    assertEquals(expectedMessage, loginModel.getMessage());
	}
}
