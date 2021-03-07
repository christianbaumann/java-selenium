package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//TODO Add AShot screenshot comparison
//TODO Add other browsers (Firefox, mobiles, etc.), and how to run them at once
//TODO Update readme: How to run from cmd

public class BaseTests {

    //    private WebDriver driver;
    private EventFiringWebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

//        driver = new ChromeDriver();
//        driver = new ChromeDriver(getChromeOptions());
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        goHome();

//        setCookie();

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
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
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

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("chriss", "baumann")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
