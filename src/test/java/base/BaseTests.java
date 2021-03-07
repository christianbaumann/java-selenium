package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

//    private WebDriver driver;
    private EventFiringWebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

//        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());

        goHome();

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
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("resources/screenshots/" + result.getName() + ".png");
            try {
                FileUtils.copyFile(screenshot, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
