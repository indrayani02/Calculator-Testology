package Policies;


import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


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
	   // driver.findElement(By.xpath("//*[@id=\\\"sm-16164829672666956-1\\\"]/b")).click();
	    Thread.sleep(3000);
	   //WebElement dropElement = driver.findElement(By.xpath("//*[@id=\"sm-16164838005089707-1\"]"));
	  // dropElement.click();
	  //  Thread.sleep(3000);
	     driver.findElement(By.xpath("//a[contains(text(),'Financial')]")).click();
		// Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//a[contains(text(),'Investment')]")).click();
		// Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[contains(text(),'Simple Interest Calculator')]")).click();
		 Thread.sleep(3000);

	   // driver.findElement(By.id("//a[@id='sm-16164173167616555-1']")).click();
	  //  driver.findElement(By.id("sm-16164849740138628-1")).click();
	    
	  //  driver.findElement(By.xpath("//a[@id='sm-16164849740138628-1']")).click();
	    
	    
	    
	    //driver.findElement(By.xpath("//*[@id=\\\"sm-16164829672666956-1\\\"]/b")).click();
	   // Select dropdown = new Select(dropElement);
	    //dropdown.selectByValue("Simple Interest Calculator");
	  	//dropdown.selectByVisibleText("Simple Interest Calculator");
	    //driver.findElement(By.xpath("//li[@id='financial_category']/a')]")).click();
//	    driver.findElement(By.xpath("//a[contains(text(),'Simple Interest Calculator")).click();

	  //driver.findElement(By.linkText("financial_category")).click();
      //driver.findElement(By.linkText("Simple Interest Calculator")).click();    
	  //driver.findElement(By.id("//li[@id='simple_interest_calculator']/a")).click();
	  //driver.findElement(By.xpath("//a[contains(@href, '/financial/simple-interest-calculator')]")).click();
	  //sm-16163482675003179-1
      //WebElement dropElement = driver.findElement(By.id("financial_category"));	
	  //driver.findElement(By.linkText("Simple Interest Calculator")).click();
	  //Locating dropDown	    
	   	driver.findElement(By.id("principal")).clear();
	    driver.findElement(By.id("principal")).sendKeys("100000");
	    driver.findElement(By.id("calculate-button")).click();
	    // driver.findElement(By.xpath("//ul[@id='social-buttons']/li/a")).click();
	    driver.findElement(By.xpath("//div[@id='results']/h2")).click();
	    // Warning: waitForTextPresent may require manual changes
	    for (int second = 0;; second++) {
	  	if (second >= 60) fail("timeout");
	   	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*//div\\[@id='results'\\]/h2[\\s\\S]*$")) break; } catch (Exception e) {}
	   	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//a[@id='sm-16163448104576313-1']/b")).click();
	    driver.findElement(By.xpath("//a[@id='sm-16163449739024976-1']/b")).click();
	    driver.findElement(By.linkText("Simple Interest Calculator")).click();
	    driver.findElement(By.xpath("//body")).click();
	    
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
