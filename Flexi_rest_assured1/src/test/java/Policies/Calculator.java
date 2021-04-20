package Policies;

import static org.testng.Assert.fail;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class Calculator {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
	    baseUrl = "https://www.calculatestuff.com/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testCalculator() throws Exception {
	    driver.get(baseUrl);
	     driver.findElement(By.xpath("//a[contains(text(),'Financial')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Investment')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Simple Interest Calculator')]")).click();
		 wait(3000);   
	   	driver.findElement(By.id("principal")).clear();
	    driver.findElement(By.id("principal")).sendKeys("100000");
	    driver.findElement(By.id("calculate-button")).click();
	    driver.findElement(By.xpath("//div[@id='results']/h2")).click();
	    for (int second = 0;; second++) {
	  	if (second >= 60) fail("timeout");
	   	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div\\[@id='results'\\]/h2[\\s\\S]*$")) break; } catch (Exception e) {}
	   	Thread.sleep(1000);
	    } 
	    driver.findElement(By.xpath("//div[@id='results']/div[2]/div/p")).click();
	    try {
	    assertEquals(driver.findElement(By.xpath("//div[@id='results']/div[2]/div/p/strong")).getText(), "After 10 years your investment will be worth $18,000.00.");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	      
	    }
	  
	  }

	  @AfterClass(alwaysRun = true)
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
