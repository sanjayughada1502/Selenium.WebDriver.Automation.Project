package testBase;

import java.io.IOException;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import General_Library.Utilities;
import pageObjects.LoginPage;

public class BaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@BeforeTest
	public void setup() throws IOException {
		Utilities ul = new Utilities();
		String browser = ul.getData("browser");
		
		if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		String URL = ul.getData("url");
		driver.get(URL);
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		Utilities ul = new Utilities();
		LoginPage lp = new LoginPage(driver);
		lp.enter_username(ul.getData("username"));
		lp.enter_password(ul.getData("password"));
		lp.click_signIn();

		
		
		Alert alert = driver.switchTo().alert();
		//System.out.println("Alert text: " + alert.getText()); // Optional
		Thread.sleep(Duration.ofSeconds(1));
		alert.accept(); // Clicks OK
		
		
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "http://49.249.28.218:8098/dashboard");
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}
}
