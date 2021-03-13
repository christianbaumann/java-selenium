package frames;

import base.BaseTests;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {

    @Ignore
    @Test
    public void testWysiwyg() {
        String text1 = "hello ";
        String text2 = "world";

        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        editorPage.setTextArea(text1);
        editorPage.increaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Text from editor is incorrect");
    }

    @Test
    public void testNestedFrames() {
        var nestedFramesPage = homePage.clickFramesPage().clickNestFramesPage();

        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM");
    }

}
