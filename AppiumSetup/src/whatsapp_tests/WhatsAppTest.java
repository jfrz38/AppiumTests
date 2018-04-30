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
	public void whatsAppTestBusqueda() throws InterruptedException {

		// Búsqueda
		driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
		// Escribir texto en la búsqueda
		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("fony");
		Thread.sleep(5000);
		// Coger primer resultado de la búsqueda
		List<WebElement> lw = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
		// Clickar el resultado
		lw.get(0).click();
		// Guardar el nombre de contacto al que se ha accedido
		String contactName = driver.findElement(By.id("com.whatsapp:id/conversation_contact_name")).getText();
		// Comprobar que coincide con el contacto al que queríamos acceder
		Assert.assertEquals(contactName, "Fonyou grupo");

		// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

	}

	@Test
	public void whatsAppTestEscribirContacto() throws InterruptedException {

		// Mensaje a enviar
		String mensaje = "Hola";
		// Repetir proceso anterior
		driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("fony");
		Thread.sleep(5000);
		List<WebElement> lw = driver.findElements(By.id("com.whatsapp:id/contact_row_container"));
		lw.get(0).click();
		// Escribir mensaje
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys(mensaje);
		// Enviar mensaje
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		// Almacenar todos los mensajes que aparecen
		lw = driver.findElements(By.id("com.whatsapp:id/message_text"));
		// Coger el último y comprobar que es el que hemos enviado nosotros
		Assert.assertEquals(lw.get(lw.size() - 1).getText(), mensaje);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
