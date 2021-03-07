package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyTests extends BaseTests {

    @Test
    public void testBackspace() {
        var keyPage = homePage.clickKeyPresses();

        keyPage.enterText("A" + Keys.BACK_SPACE);

        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi() {
        var keyPage = homePage.clickKeyPresses();

        keyPage.enterPi();

        assertEquals(keyPage.getResult(), "You entered: 4");
    }

    @Test
    public void testHorizontalSlider() {
        int valueToBeSet = 3;

        var horizontalSliderPage = homePage.clickHorizontalSlider();

        horizontalSliderPage.moveSliderRight(valueToBeSet);

        assertEquals(horizontalSliderPage.sliderValue(), String.valueOf(valueToBeSet));
    }
}
