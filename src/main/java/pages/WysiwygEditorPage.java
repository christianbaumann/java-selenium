package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends BasePage {

    private By increaseIndentButton = By.cssSelector("#button[title='Increase indent']");
    private By textArea = By.id("tinymce");
    private String editorIframeId = "mce_0_ifr";

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseIndention(){
        driver.findElement(increaseIndentButton).click();
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}