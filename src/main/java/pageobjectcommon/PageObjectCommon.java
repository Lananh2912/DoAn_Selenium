package pageobjectcommon;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import hook.DataField;
//import CucumberContext.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
//import junit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCommon {
	    public static WebDriver edriver;
	    private static WebDriver jsWaitDriver;
	    private static WebDriverWait jsWait;
	    private static JavascriptExecutor jsExec;
	  //  public ExcelUtils resultPool = null;
	    //public DataField resultDfInputs = null;
	   // public DataField resultDfOutputs = null;

	    public PageObjectCommon() {
	    }

	    public static void setDriver(WebDriver driver) {
	        edriver = driver;
	        jsWaitDriver = driver;
	        jsWait = new WebDriverWait(jsWaitDriver, 20L);
	        jsExec = (JavascriptExecutor)jsWaitDriver;
	    }


	    public static void waitUntilElementAttributeContainsValue(final WebElement element, final String attribute, final String value) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    return StringUtils.contains(element.getAttribute(attribute), value);
	                }
	            });
	        } catch (StaleElementReferenceException var4) {
	            Thread.sleep(2000L);
	            waitUntilElementAttributeContainsValue(element, attribute, value);
	        }

	    }

	    public static void waitUntilElementIsVisible(WebElement element) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.visibilityOf(element));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(2000L);
	            waitUntilElementIsVisible(element);
	        }

	    }

	    public static void waitUntilElementIsVisible(WebElement element, long timeout) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, timeout)).until(ExpectedConditions.visibilityOf(element));
	        } catch (StaleElementReferenceException var4) {
	            Thread.sleep(2000L);
	            waitUntilElementIsVisible(element, timeout);
	        }

	    }

	    public static void waitUntilElementIsVisible(String path) throws Exception {
	        
	        

	        try {
	            WebElement element = edriver.findElement(By.xpath(path));
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.visibilityOf(element));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(2000L);
	            waitUntilElementIsVisible(path);
	        }

	    }

	    public static void waitUntilElementIsInVisible(WebElement element, long timeout) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, timeout)).until(ExpectedConditions.invisibilityOf(element));
	        } catch (Exception var4) {
	        }

	    }

	    public static void waitUntilElementIsVisibleXpath(String xpath, long timeout) throws Exception {
	        
	        

	        try {
	            (new WebDriverWait(edriver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        } catch (Exception var4) {
	        }

	    }
	    
	    

	    public static void waitUntilElementIsInVisible(WebElement element) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.invisibilityOf(element));
	        } catch (Exception var2) {
	        }

	    }

	    public static void waitUntilElementIsInVisible(String xpath) throws Exception {
	        
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	        } catch (Exception var2) {
	        }

	    }

	    public static void waitUntilElementIsClickable(WebElement element) throws Exception {

	    	 
	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.elementToBeClickable(element));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(1000);
	            waitUntilElementIsClickable(element);
	        }

	    }

	    
	    
	
	    public static void waitUntilElementContainsValue(final WebElement element, final String value) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    if (StringUtils.equals(element.getAttribute("value"), value)) {
	                        PageObjectCommon.getFocusOut(element);
	                    }

	                    return StringUtils.equals(element.getAttribute("value"), value);
	                }
	            });
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            waitUntilElementContainsValue(element, value);
	        }

	    }

	    public static void waitUntilElementContainsText(final WebElement element, final String text) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    if (StringUtils.equals(element.getText(), text)) {
	                        PageObjectCommon.getFocusOut(element);
	                    }

	                    return StringUtils.equals(element.getText(), text);
	                }
	            });
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            waitUntilElementContainsText(element, text);
	        }

	    }

	    public static void waitUntilListContainsValueAtIndex(final List collection, final int index) throws Exception {
	        
	        (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return collection != null && collection.size() > index;
	            }
	        });
	    }

	    public static void waitUntilListContainsValueAtIndex(final String xpath, final int index) throws Exception {
	        try {
	            
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    return PageObjectCommon.edriver.findElements(By.xpath(xpath)) != null && PageObjectCommon.edriver.findElements(By.xpath(xpath)).size() > index;
	                }
	            });
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            waitUntilListContainsValueAtIndex(xpath, index);
	        }

	    }

	    public static void waitUntilValuesAreEqual(final WebElement ele, final String actualValue, final String expectedValue) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    if (StringUtils.equals(actualValue, expectedValue)) {
	                        PageObjectCommon.getFocusOut(ele);
	                    }

	                    return StringUtils.equals(actualValue, expectedValue);
	                }
	            });
	        } catch (StaleElementReferenceException var4) {
	            Thread.sleep(2000L);
	            waitUntilValuesAreEqual(ele, actualValue, expectedValue);
	        }

	    }

	    public static void waitUntilElementIsNotEmpty(WebElement element) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(2000L);
	            waitUntilElementIsNotEmpty(element);
	        }

	    }

	    public static void waitUntilElementIsEmpty(WebElement element) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.attributeToBe(element, "value", ""));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(2000L);
	            waitUntilElementIsEmpty(element);
	        }

	    }

	    public static void waitUntilElementIsDisabled(WebElement element) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.attributeToBe(element, "disabled", "true"));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(2000L);
	            waitUntilElementIsDisabled(element);
	        }

	    }

	    public static void waitUntilSelectDropdownHasValueAtIndex(final Select element, final int index) throws Exception {
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver d) {
	                    return element.getOptions() != null && element.getOptions().size() > index;
	                }
	            });
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            waitUntilSelectDropdownHasValueAtIndex(element, index);
	        }

	 }

	    public static void getFocusOut(WebElement element) {
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].blur();", new Object[]{element});
	    }

	    public static void focus(WebElement element) throws Exception {
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].focus();", new Object[]{element});
	    }

	    public static void doubleClick(WebElement element) throws Exception {
	        waitUntilElementIsClickable(element);
	        ((JavascriptExecutor)edriver).executeScript("var evt = document.createEvent('MouseEvents');evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);arguments[0].dispatchEvent(evt);", new Object[]{element});
	    }

	    public static void doubleClick(String xpath) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        waitUntilElementIsClickable(element);
	        ((JavascriptExecutor)edriver).executeScript("var evt = document.createEvent('MouseEvents');evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);arguments[0].dispatchEvent(evt);", new Object[]{element});
	    }

	    public static void focusWindowAndClick(WebElement element) throws Exception {
	        try {
	            (new WebDriverWait(edriver, 1L)).until(ExpectedConditions.elementToBeClickable(element));
	        } catch (StaleElementReferenceException var2) {
	            Thread.sleep(5000L);
	        } catch (Exception var3) {
	        }

	        ((JavascriptExecutor)edriver).executeScript("window.focus();", new Object[0]);
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].click();", new Object[]{element});
	    }

	    public static void scroll() {
	        ((JavascriptExecutor)edriver).executeScript("window.scrollBy(0,200)", new Object[0]);
	    }

	    public static void scrollDown() {
	        ((JavascriptExecutor)edriver).executeScript("window.scrollBy(0,250)", new Object[0]);
	    }

	    public static void scrollToElement(WebElement element) {
	        ((JavascriptExecutor)edriver).executeScript("window.scrollBy(0,-100)", new Object[0]);
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
	    }

	    public static void waitUntilJQueryReady() {
	        JavascriptExecutor jsExec = (JavascriptExecutor)jsWaitDriver;
	        Boolean jQueryDefined = (Boolean)jsExec.executeScript("return typeof jQuery != 'undefined'", new Object[0]);
	        if (jQueryDefined) {
	            sleep(20);
//	            waitForJQueryLoad();
//	            waitUntilJSReady();
	            sleep(20);
	        }

	    }

	    public static void sleep(Integer seconds) {
	        long secondsLong = (long)seconds;

	        try {
	            Thread.sleep(secondsLong);
	        } catch (InterruptedException var4) {
	            var4.printStackTrace();
	        }

	    }

	    public static void switchToNewWindow(int windowNumber) throws InterruptedException {
	        Thread.sleep(12000L);
	        Set<String> s = edriver.getWindowHandles();
	        Iterator<String> ite = s.iterator();

	        for(int i = 1; ite.hasNext() && i < 10; ++i) {
	            String popupHandle = ((String)ite.next()).toString();
	            edriver.switchTo().window(popupHandle);
	            edriver.manage().window().maximize();
	            edriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
	            if (i == windowNumber) {
	                break;
	            }
	        }

	    }

	    public boolean isElementExist(By locator) throws Exception {
	        

	        try {
	            return edriver.findElement(locator) != null;
	        } catch (Exception var3) {
	            return false;
	        }
	    }

	    public boolean isElementExist(WebElement ele) throws Exception {
	        

	        try {
	            return ele.isDisplayed();
	        } catch (Exception var3) {
	            return false;
	        }
	    }
	    
	    public boolean isElementEnabled(WebElement ele) throws Exception {
	       

	        try {
	            return ele.isEnabled();
	        } catch (NoSuchElementException var3) {
	            return false;
	        }
	    }

	    protected void switchToFrame(By locator) throws Exception {
	        try {
	            edriver.switchTo().defaultContent();
	            WebElement iFrame = (WebElement)(new WebDriverWait(edriver, 20L)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	            edriver.switchTo().frame(iFrame);
	        } catch (Exception var3) {
	            throw var3;
	        }
	    }
	    public void focusClick(WebElement element) throws Exception {
	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.elementToBeClickable(element));
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(5000L);
	        } catch (Exception var4) {
	        }

	        waitUntilElementIsVisible(element);
	        scrollToElement(element);
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].focus();", new Object[]{element});
	        waitUntilElementIsClickable(element);
	        
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].click();", new Object[]{element});
	    }

	    public void focusDoubleClick(WebElement element) throws Exception {
	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.elementToBeClickable(element));
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(5000L);
	        } catch (Exception var4) {
	        }

	        
	        waitUntilElementIsVisible(element);
	        focus(element);
	        doubleClick(element);
	    }

	    public void focusDoubleClick(String xpath) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        this.focusDoubleClick(element);
	    }

	    public void focusClick(String xpath) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        scrollToElement(element);
	        this.focusClick(element);
	    }

	    public void click(WebElement element) throws Exception {
	       
	        

	        try {
	            (new WebDriverWait(edriver, 20L)).until(ExpectedConditions.elementToBeClickable(element));
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(5000L);
	            PageFactory.initElements(edriver, this);
	        } catch (Exception var4) {
	        }

	        waitUntilElementIsVisible(element);
	        waitUntilElementIsClickable(element);
	        scrollToElement(element);
	        element.click();
	        
	    }

	    public void click(String xpath) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        this.click(element);
	    }

	    public void sendKeys(WebElement element, String text) throws Exception {
	        this.focusClick(element);
	        element.clear();
	        if (StringUtils.isNotEmpty(element.getAttribute("value"))) {
	            for(int i = element.getAttribute("value").length(); i > 0; --i) {
	                element.sendKeys(new CharSequence[]{Keys.BACK_SPACE});
	            }
	        }

	        waitUntilElementIsEmpty(element);
	        element.sendKeys(new CharSequence[]{text});
	    }

	    public void sendKeys(String xpath, String text) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        this.sendKeys(element, text);
	    }

	    public void enterTextUsingJavaScript(WebElement element, String text) throws Exception {
	        ((JavascriptExecutor)edriver).executeScript("arguments[0].setAttribute('value',arguments[1]);", new Object[]{element, text});
	    }

	    public void selectByValue(WebElement element, String value) throws Exception {
	        this.focusClick(element);
	        Select select = new Select(element);
	        select.selectByValue(value);
	    }

	    public void selectByValue(String xpath, String value) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        this.selectByValue(element, value);
	    }

	    public void selectByVisibleText(WebElement element, String text) throws Exception {
	        this.focusClick(element);
	        Select select = new Select(element);
	        select.selectByVisibleText(text);
	    }

	    public void selectByVisibleText(String xpath, String text) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        this.selectByVisibleText(element, text);
	    }

	    public void selectByIndex(WebElement element, int index) throws Exception {
	        this.focusClick(element);
	        Select select = new Select(element);
	        waitUntilSelectDropdownHasValueAtIndex(select, index);
	        select.selectByIndex(index);
	    }

	    public String getText(WebElement element) throws Exception {
	        try {
	            return element.getText();
	        } catch (Exception var3) {
	            return "";
	        }
	    }

	    public String getText(String xpath) throws Exception {
	        WebElement element = edriver.findElement(By.xpath(xpath));
	        return this.getText(element);
	    }

	    public List<WebElement> getElements(String xpath) throws Exception {
	        try {
	            if (edriver.findElements(By.xpath(xpath)) != null) {
	                ((WebElement)edriver.findElements(By.xpath(xpath)).get(0)).getTagName();
	            }

	            return edriver.findElements(By.xpath(xpath));
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            this.getElements(xpath);
	            return null;
	        }
	    }

	    public WebElement getElement(String xpath) throws Exception {
	        try {
	            edriver.findElement(By.xpath(xpath)).getTagName();
	            return edriver.findElement(By.xpath(xpath));
	        } catch (StaleElementReferenceException var3) {
	            Thread.sleep(2000L);
	            this.getElement(xpath);
	            return null;
	        }
	    }

	    public void navigateToNextPage() throws Exception {
	        this.focusClick(edriver.findElement(By.xpath("//button[contains(@id,'navigation_button')]")));
	    }

	    public String retrieveElementValueBasedOnType(WebElement webElement) throws Exception {
	        if (StringUtils.contains(webElement.getAttribute("type"), "checkbox")) {
	            return webElement.isSelected() ? "Y" : "N";
	        } else if (StringUtils.contains(webElement.getAttribute("type"), "select")) {
	            return (new Select(webElement)).getFirstSelectedOption().getText().trim();
	        } else {
	            return !StringUtils.contains(webElement.getAttribute("type"), "text") && !StringUtils.contains(webElement.getTagName(), "input") ? this.getText(webElement) : webElement.getAttribute("value");
	        }
	    }

	    public String retrieveElementValueBasedOnType(String xpath) throws Exception {
	        return this.retrieveElementValueBasedOnType(edriver.findElement(By.xpath(xpath)));
	    }

	    public void enterNonEmptyValue(WebElement webElement, String value) throws Exception {
	        if (StringUtils.isNotEmpty(value)) {
	            this.sendKeys(webElement, value);
	        }

	    }

	    public void enterNonEmptyValue(String xpath, String value) throws Exception {
	        if (StringUtils.isNotEmpty(value)) {
	            this.sendKeys(edriver.findElement(By.xpath(xpath)), value);
	        }

	    }

	    public void enterValue(WebElement webElement, String value) throws Exception {
	        if (StringUtils.isNotEmpty(value)) {
	            this.sendKeys(webElement, value);
	        } else if (StringUtils.isEmpty(value)) {
	            this.sendKeys(webElement, "");
	        }

	    }

	    public void enterValue(String xpath, String value) throws Exception {
	        this.enterValue(this.getElement(xpath), value);
	    }

	    public void selectNonEmptyValueByVisibleText(WebElement webElement, String text) throws Exception {
	        if (StringUtils.isNotEmpty(text)) {
	            this.selectByVisibleText(webElement, text);
	        }

	    }

	    public void selectNonEmptyValueByVisibleText(String xpath, String text) throws Exception {
	        this.selectNonEmptyValueByVisibleText(this.getElement(xpath), text);
	    }

	    public void selectNonEmptyValueByValue(WebElement webElement, String text) throws Exception {
	        if (StringUtils.isNotEmpty(text)) {
	            this.selectByValue(webElement, text);
	        }

	    }

	    public void clickCheckBox(WebElement webElement, String text) throws Exception {
	        if ((StringUtils.equalsIgnoreCase(text, "True") || StringUtils.equalsIgnoreCase(text, "Y") || StringUtils.equalsIgnoreCase(text, "Yes")) && !webElement.isSelected()) {
	            this.click(webElement);
	        } else if ((StringUtils.equalsIgnoreCase(text, "false") || StringUtils.equalsIgnoreCase(text, "N") || StringUtils.equalsIgnoreCase(text, "No")) && webElement.isSelected()) {
	            this.click(webElement);
	        }

	    }

	    public void clickCheckBox(String xpath, String text) throws Exception {
	        this.clickCheckBox(edriver.findElement(By.xpath(xpath)), text);
	    }

	    public void clickIfValueIsNotEmpty(WebElement webElement, String text) throws Exception {
	        if (StringUtils.isNotEmpty(text)) {
	            this.click(webElement);
	        }

	    }

	    public void clickIfValueIsNotEmpty(String xpath, String text) throws Exception {
	        if (StringUtils.isNotEmpty(text)) {
	            this.click(edriver.findElement(By.xpath(xpath)));
	        }

	    }

	    public void clickIfValueEquals(WebElement webElement, String expected, String actual) throws Exception {
	        if (StringUtils.equals(expected, actual)) {
	            this.click(webElement);
	        }

	    }

	    public void clickIfValueEquals(String xpath, String expected, String actual) throws Exception {
	        if (StringUtils.equals(expected, actual)) {
	            this.click(edriver.findElement(By.xpath(xpath)));
	        }

	    }
	}
