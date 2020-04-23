import static org.junit.Assert.*;


import org.junit.Test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Caso1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Espacio\\PruebasKatalon\\lib\\geckodriver.exe");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
    capabilities.setCapability("binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(300000, TimeUnit.SECONDS); 
    
  }
  

  @Test
  public void testCaso1() throws Exception {
	  driver.get("https://www.youtube.com/?gl=CO&hl=es-419");
	    driver.findElement(By.name("search_query")).click();
	    driver.findElement(By.name("search_query")).clear();
	    driver.findElement(By.name("search_query")).sendKeys("como funciona selemiun");
	    driver.findElement(By.name("search_query")).sendKeys(Keys.DOWN);
	    driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
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


