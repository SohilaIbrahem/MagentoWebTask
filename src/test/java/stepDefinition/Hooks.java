package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Hooks {
    public static WebDriver driver;
    @Before()
    public void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
       // WebDriverManager.firefoxdriver().setup();
       // driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
        driver.get("https://magento.softwaretestingboard.com/");

    }

      @After
      public void tearDown ()
    {
       this.driver.quit();
   }

}
