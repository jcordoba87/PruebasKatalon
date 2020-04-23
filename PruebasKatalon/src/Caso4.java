import static org.junit.Assert.*;

import org.junit.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Caso4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Espacio\\PruebasKatalon\\lib\\chromedriver.exe");
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability("marionette", true);
	    capabilities.setCapability("binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
  }

  @Test
  public void testCaso4() throws Exception {
	  driver.get("https://www.rottentomatoes.com/");
	    driver.findElement(By.id("fullscreen-search-term")).click();
	    driver.findElement(By.id("fullscreen-search-term")).clear();
	    driver.findElement(By.id("fullscreen-search-term")).sendKeys("The invisible");
	    driver.findElement(By.xpath("//div[@id='fullscreen-search-results-container']/div/section/ul/li[5]/a/div/div[2]/div")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

