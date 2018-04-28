package whatsapp_tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WhatsAppTest2 {

	public static AppiumDriver<MobileElement> driver;
	public String contactName = "Ramón UAL";
	
	@Before
	public void setUp () throws MalformedURLException, IOException{
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("deviceName", "My Phone");
		caps.setCapability("deviceName", "hwG7-L01");
		caps.setCapability("udid", "f4e3fbea5a03"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4");
		caps.setCapability("appPackage", "com.whatsapp");
		//caps.setCapability("appActivity", "org.telegram.messenger.OpenChatReceiver");
		caps.setCapability("appActivity", "com.whatsapp.Main");
		//caps.setCapability("appActivity", "com.whatsapp.Settings");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver 
		try {
				//AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				//driver.quit();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());

		}
	}
	@After
	public void TearDown() {
		driver.quit();
	}
	@Test
	public void test() {
		//clickOnSearchBtn();
		searchContact(contactName);
		//sendText("Probando, probando");
		//clickAndSendImage("New Image");
		//takeScreenShot(driver);
		
	}
	
	@Test
	public void CerrarApp() {
		driver.closeApp();
	}
	
	public static void searchContact(String str) {
		driver.findElement(By.id("android:id/search_src_text")).sendKeys(str);
		driver.findElement(By.id("com.whatsapp:id/single_msg_tv")).click();
	}
	
	public static void sendText(String txt) {
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys(txt);
		driver.findElement(By.id("com.whatsapp:id/send")).click();
	}
	
	public static void clickAndSendImage(String img) {
		driver.findElement(By.id("com.whatsapp:id/camera_btn")).click();
		driver.findElement(By.id("com.whatsapp:id/shutter")).click();
		driver.findElement(By.id("com.whatsapp:id/caption")).sendKeys(img);
		clickDoneBtn();
		driver.findElement(By.id("com.whatsapp:id/ok")).click();
	}
	
	public static void horizontalswipe() {
		
	}
	
	public static void clickDoneBtn() {
		JavascriptExecutor search = (JavascriptExecutor) driver;
		HashMap<String,Double>sObject = new HashMap<String, Double>();
		sObject.put("tapCount",(double)1);
		sObject.put("touchCount",(double)1);
		sObject.put("duration",0.5);
		sObject.put("x",(double)995);
		sObject.put("y",(double)1819);
		search.executeScript("mobile: tap",sObject);
	}
	
	public static void clickOnSearchBtn() {
		WebElement frameLayout = driver.findElement(By.id("android:id/action_bar_container"));
		List<WebElement> textView = (List<WebElement>) frameLayout.findElement(By.className("android.widget.TextView"));
		System.out.println(textView.size());
		textView.get(1).click();
	}

}
