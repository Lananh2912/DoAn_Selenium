package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import pageobjectcommon.PageObjectCommon;

public class LoginPage extends PageObjectCommon {

	    WebDriver driver;
	    @FindBy(how = How.XPATH, using= "//div[@class='z-row-content']//input[@type='text']")
	    public WebElement userLogin;
	    @FindBy(how = How.XPATH, using= "//div[@class='z-row-content']//input[@type='password']")
	    public WebElement passWordLogin;
	    @FindBy(how = How.XPATH, using="//div[@class='z-row-content']//button[@type='button']")
	    //@FindBy(how = How.XPATH, using="//button[text()='Đăng nhập']")
	    public WebElement btnLogin;
	    public String btnlogins="//div[@class='z-row-content']//button[@type='button']";
	    @FindBy(how = How.XPATH, using="(//div[@class='z-vlayout-inner']//span)[1]")
	    public WebElement title;
	    
	    @FindBy(how = How.XPATH, using="//span[@class='warn z-label']")
	    public WebElement validation;
	    public LoginPage (WebDriver driver) {
	         edriver = driver;
	         PageFactory.initElements(driver, this);
	         setDriver(edriver);
	    }
	    public void login(String username, String password) {
	    	//wait.until(ExpectedConditions.visibilityOfElementLocated(u));
	    	try {
				waitUntilElementIsVisible(userLogin);
				waitUntilElementIsClickable(userLogin);
		    	waitUntilElementIsVisible(passWordLogin);
		    	waitUntilElementIsClickable(passWordLogin);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	        // enter password
	        userLogin.clear();
	        userLogin.click();
	        userLogin.sendKeys(username);
	        
	        // password
	        passWordLogin.clear();
	        passWordLogin.click();
	        passWordLogin.sendKeys(password);
	    }
	    
	    public void clicklogin() {
			try {			
				waitUntilElementIsVisibleXpath(btnlogins, 30);
				waitUntilElementIsClickable(btnLogin);
				 btnLogin.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	
	    public void verify_validation()
	    {
	    	try {
	    		waitUntilElementIsVisible(validation);
	    		
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }
	    public void verify()
	    {
	    	try {
				waitUntilElementIsVisible(title);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
