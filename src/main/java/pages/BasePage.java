package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    public void alert_setInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

}
