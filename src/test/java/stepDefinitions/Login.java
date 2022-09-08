package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.*;		
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageobjectmodel.LoginPage;

import org.openqa.selenium.WebElement;
//import utils.DriverFactory;

public class Login  {	
	WebDriver driver;
	LoginPage login;
	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\chat\\quanLyCongViec_FW\\driver\\chromedriver.exe");					
        driver= new ChromeDriver();
        driver.manage().window().maximize();			
        driver.get("http://localhost:8080/ZKTaskManagement/");
	}

	@When("title of login page is Quan Ly cong Viec")
	public void title_of_login_page_is_quan_ly_cong_viec() {
		 String title = driver.getTitle();
		 System.out.println(title);
	}

	@Then("user enters {string} and {string}")
	public void user_enters_and(String userName, String passWord) throws Exception {
	   login = new LoginPage(driver);
	   login.login(userName, passWord);
	   Thread.sleep(1000);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() throws Throwable {
	   login.clicklogin();
	}

	@Then("user is on home pag")
	public void user_is_on_home_pag() {
		login.verify();
		String title=login.title.getText();
		assertEquals("Task Management", title);
	}
}		
