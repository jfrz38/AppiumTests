package whatsapp_tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConfigurarWhatsAppTest {

	WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException, InterruptedException {

		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "hwG7-L01");// Nombre dispositivo
		caps.setCapability("udid", "f4e3fbea5a03"); // Dispositivo donde ejecutar las pruebas
		caps.setCapability("platformName", "Android");// OS
		caps.setCapability("platformVersion", "4.4");// Versión
		caps.setCapability("appPackage", "com.whatsapp");// App donde ejecutar las pruebas
		caps.setCapability("appActivity", "com.whatsapp.Main");// Método Main de la App
		caps.setCapability("noReset", "true");

		// Driver con la URL configurada en Appium
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}

	@Test
	public void whatsAppTestEscribirContacto() throws InterruptedException {
		// Mock
		Thread.sleep(5000);
		Assert.assertEquals(true, true);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}