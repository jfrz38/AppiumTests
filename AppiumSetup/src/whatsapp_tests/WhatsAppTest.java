package whatsapp_tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WhatsAppTest {

	WebDriver driver;
	List<WebElement> chatName;

	@Before
	public void setUp() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "hwG7-L01");
		caps.setCapability("udid", "f4e3fbea5a03");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.4");
		caps.setCapability("appPackage", "com.whatsapp");
		caps.setCapability("appActivity", "com.whatsapp.Main");
		caps.setCapability("noReset", "true");
		// caps.setCapability("unicodeKeyboard", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}

	@Test
	public void whatsAppTestBusqueda() throws InterruptedException {

		driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("ramon");
		Thread.sleep(5000);
		List<WebElement> lw = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
		lw.get(0).click();
		String contactName = driver.findElement(By.id("com.whatsapp:id/conversation_contact_name")).getText();
		Assert.assertEquals(contactName,"Ramón UAL");
		
		/*lw.get(0).click();

		Thread.sleep(5000);
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Hola");
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		driver.findElement(By.id("com.whatsapp:id/back")).click();*/

		// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}
	
	@Test
	public void whatsAppTestEscribirContacto() throws InterruptedException {
		
		String mensaje = "Hola";
		driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("ramon");
		Thread.sleep(5000);
		List<WebElement> lw = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
		lw.get(0).click();
		lw = driver.findElements(By.id("com.whatsapp:id/message_text"));
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys(mensaje);
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		Assert.assertEquals(lw.get(lw.size()-1).getText(),mensaje);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
