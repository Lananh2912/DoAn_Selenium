package pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import pageobjectcommon.PageObjectCommon;

public class AddPage  extends PageObjectCommon{
	  WebDriver driver;
	    
	    @FindBy(how = How.XPATH, using= "//span[text()='Quản lý công việc']")
	    public WebElement tagQLCV;
	    @FindBy(how = How.XPATH, using="//button[text()='Thêm mới']")
	    //@FindBy(how = How.XPATH, using="//button[text()='Đăng nhập']")
	    public WebElement btnThemMoi;
	   
	    @FindBy(how = How.XPATH, using="//tr[@class='z-row'][1]//input")
	    public WebElement tencongviec;
	    
	    @FindBy(how = How.XPATH, using="//tr[@class='z-row'][2]//input")
	    public WebElement mota;
	    
	    @FindBy(how = How.XPATH, using="//tr[@class='z-row z-grid-odd'][2]//input")
	    public WebElement mdut;
	    
	    @FindBy(how = How.XPATH, using="//tr[@class='z-row'][3]//input")
	    public WebElement bomon;
	  
	    @FindBy(how = How.XPATH, using="//div[@class='z-window-content']//button")
	    public WebElement btnthemmoi;
	    
	    @FindBy(how = How.XPATH, using="//div[@class='z-messagebox z-div']")
	    public WebElement alertMessges;
	   
	    
	  //div[@class='z-window-content']//button
	    public AddPage (WebDriver driver) {
	         edriver = driver;
	         PageFactory.initElements(driver, this);
	         setDriver(edriver);
	    }
	    public void clickadd() throws Exception
	    {
	    	tagQLCV.click();
	    	focusClick(btnThemMoi);
	    }
	    
	    public void enterInfor(String tenCongViec, String moTa ) throws Exception
	    {
	      	enterNonEmptyValue(tencongviec, tenCongViec);
	    	enterNonEmptyValue(mota, moTa);
	    	enterNonEmptyValue(mdut, "Hight");
	    	enterNonEmptyValue(bomon, "bmkhmt");
	    //	focus(btnthemmoi);
	    	//sendKeys(tencongviec, tenCongViec);
	    	//sendKeys(moTa, moTa);
	    }
	    
	    public void ClickThemMoi()
	    {
	    	try {
				waitUntilElementIsVisible(btnthemmoi);
				focusClick(btnthemmoi);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }
	    public void alert()
	    {
	    	try {
				waitUntilElementIsVisible(alertMessges);
				//focusClick(btnthemmoi);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }
}
