package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static ThreadLocal<WebDriver> tdriver =
	            new ThreadLocal<WebDriver>();

	    public WebDriver getDriver() {

	        return tdriver.get();
	    }

	    @BeforeMethod
	    public void setUp() {

	        WebDriverManager.chromedriver().setup();

	        WebDriver driver = new ChromeDriver();

	        tdriver.set(driver);

	        getDriver().manage().window().maximize();

	        getDriver().manage().timeouts()
	                .implicitlyWait(Duration.ofSeconds(10));
	    }

	    @AfterMethod
	    public void tearDown() {

	        getDriver().quit();
	    }

}