package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserTest {
    public WebDriver driver;
    String browserName = "chrome";

    public WebDriver initializeDriver(){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;

    }

//    @BeforeMethod(alwaysRun = true)
//    public void launchApplication(){
//        driver = initializeDriver();
//        driver.get("https://www.costco.com");
//        //driver.navigate().forward();
//    }

    @BeforeMethod
    public void launchApplication1(){
        driver = initializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        // driver.get("http://www.deadlinkcity.com/");
        //driver.get("https://www.orangehrm.com/");
        //driver.get("https://opensource-demo.orangehrmlive.com/");
        //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        //driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        //driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //driver.get("https://demo.nopcommerce.com");
        //driver.get("https://www.amazon.com/");
        //driver.get("https://demo.nopcommerce.com/");
        //driver.get("https://www.opencart.com/");
        //driver.get("https://www.costco.com");
        // driver.get("https://demo.nopcommerce.com/");
        //driver.get("https://opensource-demo.orangehrmlive.com/");
        //driver.navigate().forward();
    }

    @AfterMethod(alwaysRun = true)
    public void driverClose(){
        //driver.close();
        driver.quit();
    }


}
