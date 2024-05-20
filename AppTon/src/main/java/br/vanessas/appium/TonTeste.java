package br.vanessas.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TonTeste {

  private AndroidDriver driver;

  @Before
  public void test() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "637042d6");
    desiredCapabilities.setCapability("automationName", "uiautomator2");

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void Login() {
	  
	  //EncontrarApp
	  driver.findElement(MobileBy.AccessibilityId("Ton")).click();
	  
	  //Login
	 driver.findElement(By.xpath("//android.widget.TextView[@text= 'Ton']")).click();
	 driver.findElement(By.xpath("//android.widget.TextView[@text= 'Entrar']")).click();
	 
	 MobileElement email = (MobileElement) driver.findElementByXPath("/android.widget.EditText[@text= 'Email']");
	 email.click();
	 email.sendKeys("vanessasteste@gmail.com");
	 
	 MobileElement senha = (MobileElement) driver.findElementByXPath("/android.view.ViewGroup[2]/android.widget.EditText[@text= 'Senha']");
	 senha.click();
	 senha.sendKeys("floresta123*");
	
    MobileElement entrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup//android.widget.EditText[@text= 'Entrar']");
    entrar.click();

   //Chegar nome Escrito
    String text = email.getText();
    Assert.assertEquals("vanessasteste@gmail.com", text);
    
    String text1 = email.getText();
    Assert.assertEquals("floresta123", text1);
 }

  @After
  public void tearDown() {
    driver.quit();
  }
}
