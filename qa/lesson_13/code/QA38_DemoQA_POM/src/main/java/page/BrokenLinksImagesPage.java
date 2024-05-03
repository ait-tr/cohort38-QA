package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//p[contains(text(), 'Valid')]/following-sibling::img[1]")
    WebElement validImage;
    @FindBy(xpath = "//p[contains(text(), 'Broken')]/following-sibling::img[1]")
    WebElement brokenImage;
    @FindBy(xpath = "//p[contains(text(), 'Broken Link')]/following-sibling::a")
    WebElement brokenLink;
    @FindBy(xpath = "//p[contains(text(), 'Valid')]/following-sibling::a[1]")
    WebElement validLink;

    public BrokenLinksImagesPage checkValidLink() {
        String url = validLink.getAttribute("href");
        assertTrue(isLinkValid(url), String.format("Ссылка %s не валидна!", url));
        return this;
    }

    public BrokenLinksImagesPage checkBrokenLink() {
        String url = brokenLink.getAttribute("href");
        assertFalse(isLinkValid(url), String.format("Ссылка %s валидна!", url));
        return this;
    }

    public BrokenLinksImagesPage checkValidImage() {
        String url = validImage.getAttribute("src");
        assertTrue(isLinkValid(url), String.format("Ссылка %s не валидна!", url));
        assertTrue(isImageValid(validImage), String.format("Изображение по ссылке %s не валидно!", url));
        return this;
    }

    public BrokenLinksImagesPage checkBrokenImage() {
        String url = brokenImage.getAttribute("src");
        assertTrue(isLinkValid(url), String.format("Ссылка %s не валидна!", url));
        assertFalse(isImageValid(brokenImage), String.format("Изображение по ссылке %s валидно!", url));
        return this;
    }

}
