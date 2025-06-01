package TestBase;


import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import PageObjects.HomePage;
import PageObjects.LoginPage;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	Faker faker = new Faker();
	public Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException {
		//loading properties file
		FileReader fr = new FileReader(".//src//test/resources//config.properties");
		prop = new Properties();
		prop.load(fr);
		
		//creating logger
		logger=LogManager.getLogger(this.getClass());
		
		String br = "chrome";
		switch(br.toLowerCase()) {
		case "chrome"  : driver=  new ChromeDriver(); 
						 logger.info("Testing in Chrome");
						 break;
		case "firefox" : driver = new FirefoxDriver();
						 logger.info("Testing in Firefox");
						 break;
		case "edge"    : driver = new EdgeDriver();
						 logger.info("Testing in Edge");
						 break;
		default        : logger.error("Invalid browser"); 
						 return;
		}
		
		driver.get(prop.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	public String randomEmail() {		
		return faker.internet().emailAddress();				
	}
	
	public String randomName() {
		return faker.name().firstName();		
	}
	
	public String randomLastName() {
		return faker.name().lastName();
	}
	
	public String randomMobile() {
		return faker.phoneNumber().subscriberNumber();
	}
	public String randomPass() {
		return faker.internet().password();
	}
	
	public String randomInvalidEmail() {
		String invalidEmailId = randomName()+"#"+"gmal.co.in";
		return invalidEmailId;
	}
	
	public String invalidPhoneNumber() {
		return faker.phoneNumber().subscriberNumber(2);
	}
	
	public String alphaNumericPhoneNumber() {
		return faker.bothify("??##??##");
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	public WebDriver Login(WebDriver driver) {
		 	HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLogin(driver);
			
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(prop.getProperty("username"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			return driver;
	}
}

