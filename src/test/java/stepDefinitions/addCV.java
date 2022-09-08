package stepDefinitions;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.*;		
import io.cucumber.java.en.*;
import pageobjectmodel.AddPage;
import pageobjectmodel.LoginPage;

public class addCV {
	WebDriver driver;
	LoginPage login;
	AddPage addPage;
	@Given("user is already login")
	public void user_is_already_login() {
		System.setProperty("webdriver.chrome.driver", "D:\\chat\\quanLyCongViec_FW\\driver\\chromedriver.exe");					
        driver= new ChromeDriver();
        driver.manage().window().maximize();			
        driver.get("http://localhost:8080/ZKTaskManagement/");
	}

	@Then("user enters valid {string} and {string}")
	public void user_enters_valid_and(String userName, String passWord) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		   login = new LoginPage(driver);
		   login.login(userName, passWord);
		   Thread.sleep(1000);
	}

	@Then("click on login button")
	public void click_on_login_button()  throws Exception {
		login.clicklogin();
		Thread.sleep(500);
	}

	@Then("click tag Quan ly cong viec and click button them moi")
	public void click_tag_quan_ly_cong_viec_and_click_button_them_moi() throws Exception {
	    addPage= new AddPage(driver);
	    addPage.clickadd();
	}

	@Then("user enter input information cong viec {string} and {string} and thong tin khac")
	public void user_enter_input_information_cong_viec_and_and_thong_tin_khac(String tenCongViec, String moTa) throws Exception {
	   addPage.enterInfor(tenCongViec, moTa);
	}

	@Then("clck button them moi")
	public void clck_button_them_moi() throws Exception {
	    addPage.ClickThemMoi();
	    Thread.sleep(1000);
	}

	@Then("Verify new cong viec is correctly displayed on quan ly cong viec window")
	public void verify_new_cong_viec_is_correctly_displayed_on_quan_ly_cong_viec_window() {
		addPage.alert();
		String e_alert="Add Task Complete!";
		String a_alert=addPage.alertMessges.getText();
		org.testng.Assert.assertEquals(a_alert, e_alert);
	}


}
