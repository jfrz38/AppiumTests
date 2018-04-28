package whatsapp_tests;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {
	 
	 WebDriver driver;
	 List<WebElement> chatName;
	 
	 @Test
	 public void whatsAppTest() throws MalformedURLException,
	 InterruptedException {
	 // Set the APK path
	 //File appDir = new File(System.getProperty("user.dir") + "//Apps");
	 // Provide the APK name
	 //File app = new File(appDir, "WhatsApp_com.whatsapp.apk");
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
			//caps.setCapability("unicodeKeyboard", true);
			
	 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	 //Thread.sleep(5000);
	 
	 driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
	 driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Victor");
	 Thread.sleep(5000);
	 List<WebElement> lw;
	 lw = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
	 lw.get(0).click();
	 Thread.sleep(5000);
	 driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Hola");
	 driver.findElement(By.id("com.whatsapp:id/send")).click();
	 driver.findElement(By.id("com.whatsapp:id/back")).click();
	 
	 //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	 
	 driver.quit();
	 }
	 
	}
