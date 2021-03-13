package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    //TODO Use smaller file to decrease upload time
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();

        uploadPage.uploadFile("C:\\git_repos\\java-selenium\\resources\\chromedriver.exe");

        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded files incorrect");
    }
}