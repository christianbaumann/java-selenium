package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage {

    private By horizontalSlider = By.cssSelector(".sliderContainer input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSliderRight(int value) {
        for (int i = 0; i < value * 2; i++) {
            driver.findElement(horizontalSlider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String sliderValue() {
        return driver.findElement(range).getText();
    }
}
