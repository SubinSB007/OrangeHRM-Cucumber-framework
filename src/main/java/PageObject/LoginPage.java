package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@name=\"username\"]") WebElement txtUsername;
	@FindBy(xpath="//input[@name=\"password\"]") WebElement txtPassword;
	@FindBy(xpath = "//button[@type=\"submit\"]") WebElement btnLogin;
	@FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]") WebElement invalidCred;
	@FindBy(xpath = "//img[@alt=\"company-branding\"]") WebElement logoOrange;
	
	public void enterUsername(String user) {
		txtUsername.sendKeys(user);
	}
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public boolean testInvalidCred() {
		boolean status=invalidCred.isDisplayed();
		return status;
	}
	public boolean testLogoPresent()  {
		boolean present=logoOrange.isDisplayed();
		return present;
	}
	

}
