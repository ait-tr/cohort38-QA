package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadAndDownloadPage extends BasePage{
    public UploadAndDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    public UploadAndDownloadPage download() {
        clickElement(downloadButton);
        return this;
    }
}
