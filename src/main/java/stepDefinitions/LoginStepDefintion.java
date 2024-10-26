package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.HomePage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDefintion {
	WebDriver driver;
	LoginPage LP;
	HomePage HP;
	
	@Given("User can navigate to loginpage")
	public void user_can_navigate_to_loginpage() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}

	@When("User can enter username and password")
	public void user_can_enter_username_and_password() {
		LP=new LoginPage(driver);
		LP.enterUsername("Admin");
		LP.enterPassword("admin123");
	}
	@When("User can enter {string} and {string}")
	public void user_can_enter_and(String username, String password) {
		LP=new LoginPage(driver);
		LP.enterUsername(username);
		LP.enterPassword(password);
	}
	@Then("click on login")
	public void click_on_login() {
		LP.clickLogin();
	}
	@And("User can see the home page")
	public void user_can_see_the_home_page() {
		HP=new HomePage(driver);
		String dashbd=HP.getDashboard();
		Assert.assertEquals(dashbd, "Dashboard");
	}
	@And("invalid credintals message should be seen")
	public void invalid_credintals_message_should_be_seen()  {
	  Assert.assertTrue(LP.testInvalidCred());
	}
	@And("User can see ornageHrm logo")
	public void user_can_see_ornage_hrm_logo() throws InterruptedException {
		LP=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(LP.testLogoPresent());
	}
	@Then("Close the driver")
	public void close_the_driver() {
		//driver.close();
		driver.quit();	}
}
