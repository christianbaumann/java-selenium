package pages;

import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestFramesPage(){
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }
}
