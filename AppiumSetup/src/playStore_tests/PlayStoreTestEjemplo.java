package playStore_tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PlayStoreTestEjemplo {

	WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException, InterruptedException {

		// Set the Desired Capabilities

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "hwG7-L01");// Nombre dispositivo
		caps.setCapability("udid", "f4e3fbea5a03"); // Dispositivo donde ejecutar las pruebas
		caps.setCapability("platformName", "Android");// OS
		caps.setCapability("platformVersion", "4.4");// Versi�n
		caps.setCapability("appPackage", "com.android.vending");// App donde ejecutar las pruebas
		caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");// M�todo Main de la App
		caps.setCapability("noReset", "true");
		
		// Driver con la URL configurada en Appium
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}

	@Test
	public void PlayStoreBusquedaUAL() throws InterruptedException {
		// B�squeda
		String busqueda = "Universidad de Almeria";	//Sin tildes
		driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();
		// Escribir texto en la b�squeda
		driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys(busqueda);
		Thread.sleep(5000);
		// Coger primer resultado de la b�squeda
		List<WebElement> lw = driver.findElements(By.id("com.android.vending:id/play_search_container"));
		// Clickar el resultado
		lw.get(0).click();
		List<WebElement> lwr = driver.findElements(By.id("com.android.vending:id/search_results_list"));
		lwr.get(0).findElement(By.id("com.android.vending:id/li_title")).click();
		// Guardar el nombre de la App a la que se ha accedido
		String contactName = driver.findElement(By.id("com.android.vending:id/title_title")).getText();
		// Comprobar que coincide con la aplicaci�n a la que quer�amos acceder
		Assert.assertEquals(contactName, "Universidad de Almer�a");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}