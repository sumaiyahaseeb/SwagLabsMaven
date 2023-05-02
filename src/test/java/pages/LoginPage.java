package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver pagedriver; // driver declaration

	// ======================================objects==========================================

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginbuttton;

	// ========================================Methods=========================================
	// default action to be taken whenever creating new page
	// initailising pagedriver which was null and passing the value as chrome driver
	// to in login page (testcase driver)
	public LoginPage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(pagedriver, this);

	}

	public void Loginfunction(String usernameval, String pwdval) {

		username.sendKeys(usernameval);

		password.sendKeys(pwdval);

		loginbuttton.click();
	}
}
