package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePage {

    private String topFrameId = "frame-top";
    private String leftFrameId = "frame-left";
    private String bottomFrameId = "frame-bottom";
    private By body = By.cssSelector("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameText() {
        switchToFrame(topFrameId);
        switchToFrame(leftFrameId);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getBottomFrameText() {
        switchToFrame(bottomFrameId);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        return text;
    }

    private void switchToFrame(String identifier) {
        driver.switchTo().frame(identifier);
    }
}
