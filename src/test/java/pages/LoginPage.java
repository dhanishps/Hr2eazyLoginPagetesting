package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	 WebDriver driver;
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

By userLoginname =By.id("txtLanId");  // User login user name
By userLoginPass =By.id("txtPassword");  // User login user password
By signBtn =By.id("btnSubmit");  // User clicking Sign in button
By informationPanel =By.xpath("(//button[@class='close'])[3]"); //Information panel pop up x path
By logo =By.xpath("(//*[@type='image'])[1]"); // Hr2eazy Logo X path

//Normal Click Action
public void Click(By locator) {
	WebElement element = driver.findElement(locator);
	element.click();		
}

// Action method used to click action
public void clickAction(By locator) {
    WebElement element = driver.findElement(locator);
    Actions act = new Actions(driver);
    act.moveToElement(element).click().perform();
}

//SendKeys Method
public void SendKeysMethod(By locator, String value) {
	WebElement element = driver.findElement(locator);
	element.sendKeys(value);
}


public String GetCurrecntUrl() {
	@Nullable
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
return currentUrl;
}

public void HardAssertEquals(String actual, String expected) {
	
	Assert.assertEquals(actual, expected);

}

// Soft Assert Method
public void SoftAssertContains(String actual, String expectedText) {

    SoftAssert soft = new SoftAssert();

    soft.assertTrue(actual.contains(expectedText));

    soft.assertAll();
}

//Soft Assert is Displayed Method
public void SoftAssertisDisplayed(By Locator) {
	WebElement element = driver.findElement(Locator);
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(element.isDisplayed());
	soft.assertAll();
}

//Soft Assert is Selected Method
public void SoftAssertisSelected(By Locator) {
	WebElement element = driver.findElement(Locator);
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(element.isSelected());
	soft.assertAll();
}

//Soft Assert is Enabled Method
public void SoftAssertisEnabled(By Locator) {
	WebElement element = driver.findElement(Locator);
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(element.isEnabled());
	soft.assertAll();
}

public void LoginUserName(String lName) {
	SendKeysMethod(userLoginname, lName);
}
public void LoginUserPass(String lPass) {
	SendKeysMethod(userLoginPass, lPass);
}

public void SigninBtnClick() {
	Click(signBtn);
}
public void InformationPanelPopupClick() {
	clickAction(informationPanel);
}
public void LogoisDisplayed() {
	SoftAssertisDisplayed(logo);

}

}
