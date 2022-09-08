package stepDefinitions;
import java.util.List;

import org.junit.Assert;
	
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.*;		
import io.cucumber.java.en.*;
import pageobjectmodel.LoginPage;

public class Login_invalid {
	WebDriver driver;
	LoginPage login;
	@Given("user is already on Login Page quuan ly cong viec")
	public void user_is_already_on_login_page_quuan_ly_cong_viec() {
		System.setProperty("webdriver.chrome.driver", "D:\\chat\\quanLyCongViec_FW\\driver\\chromedriver.exe");					
        driver= new ChromeDriver();
        driver.manage().window().maximize();			
        driver.get("http://localhost:8080/ZKTaskManagement/");
	}

	@Then("user enters input invalid {string} and {string}")
	public void user_enters_input_invalid_and(String userName, String passWord) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		   login = new LoginPage(driver);
		   login.login(userName, passWord);
		   Thread.sleep(1000);
	}

	@Then("user clicks on đăng nhâp button")
	public void user_clicks_on_đăng_nhâp_button() throws Exception {
		login.clicklogin();
		Thread.sleep(500);
	}

	@Then("Ui is show validatioon")
	public void ui_is_show_validatioon() {
		login.verify_validation();
		String e_validation="Tên đăng nhập hoặc mật khẩu không đúng!";
		String a_validation=login.validation.getText();
		org.testng.Assert.assertEquals(a_validation, e_validation);
	}

}
