package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public String URL;

	@BeforeClass(groups = {"Sanity","Regression","Master","Datadriven"})
	@Parameters({"OS","Browser"})
	public void setUp(String os, String br) throws Exception {
		
		FileInputStream file = new FileInputStream("./src//test//resources//commonData.properties");
		prop = new Properties();
		prop.load(file);
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}
		
		logger = LogManager.getLogger(this.getClass());
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		URL = prop.getProperty("appURL");
		driver.get(URL);
	}

	@AfterClass(groups = {"Sanity","Regression","Master","Datadriven"})
	public void tearDown() {
		driver.quit();
	}
	
	public String nameValue() {
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}

	public String emailValue() {
		String firstHalf = RandomStringUtils.randomAlphabetic(5);
		String lastHalf = RandomStringUtils.randomNumeric(2);
		return (firstHalf + lastHalf + "@Fastor7.com");

	}
	
	public String passwordValue() {
		String firstHalf = RandomStringUtils.randomAlphabetic(5);
		String lastHalf = RandomStringUtils.randomNumeric(2);
		return (firstHalf + lastHalf + "@F");
	}
	

	public void navigate() {
		driver.navigate().to(URL);
	}
	
	public String captureScreenshot(String screenshotName) {
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss");
		Date date = new Date();
		String time = timestamp.format(date);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+"-"+time+".png";
		File taergetFile = new File(targetFilePath);
		sourceFile.renameTo(taergetFile);
		
		return targetFilePath;
		
	}

}
