package BaseClass;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;



public class ProductBase {
	
	protected WebDriver driver ;
	public static Properties prop = null; 
	
	
	
	public WebDriver LaunchDriver() throws IOException {
	
		System.setProperty("webdriver.chrome.driver","C:\\software\\eclipse\\com.Home_RetailProduct\\Driver\\Webdriver9\\chrome_proxy.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("aspx");
		driver.get("https://ipartner.icicilombard.com/WebPages/Login.aspx");
	    return driver;
	}
	
	@BeforeTest
	public void  LoadConfig() {
    	
    	try {
    		
    		prop = new Properties();
    		System.out.println("properties File read successfully ");
    		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
    		prop.load(ip);
    		System.out.println("driver: " + driver);
    	}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
    	
 
	public void takeScreenshot(WebDriver webdriver,String screenshotName) throws Exception{

            TakesScreenshot scrShot =((TakesScreenshot)webdriver);

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            File DestFile=new File(System.getProperty("user.dir") + "\\Test Screenshot\\"+"\\Home_Insurance_ScreenShot\\" +screenshotName + ".jpg");
                
            FileUtils.copyFile(SrcFile, DestFile);

    }
	
}
