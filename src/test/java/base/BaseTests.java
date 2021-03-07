package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // Implicit wait
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Page load timeout
        // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // Script timeout
        // driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        // 1 - Maximize the window
        // driver.manage().window().maximize();

        // 2 - Fullscreen mode
        // driver.manage().window().fullscreen();

        // 3 - Specific width (show Chrome iPhoneX emulator)
        // Dimension size = new Dimension(375, 812);
        // driver.manage().window().setSize(size);

        homePage = new HomePage(driver);
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
