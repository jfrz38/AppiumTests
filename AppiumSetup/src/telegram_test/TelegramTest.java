package telegram_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TelegramTest {
	
	public static void main(String[] args) {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("deviceName", "My Phone");
		caps.setCapability("deviceName", "hwG7-L01");
		caps.setCapability("udid", "f4e3fbea5a03"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4");
		caps.setCapability("appPackage", "org.telegram.messenger");
		//caps.setCapability("appActivity", "org.telegram.messenger.OpenChatReceiver");
		caps.setCapability("appActivity", "org.telegram.ui.LaunchActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver 
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
				//driver.quit();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());

		}
		
		
	}

}