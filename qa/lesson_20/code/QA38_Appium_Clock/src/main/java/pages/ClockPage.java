package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ClockPage extends BasePage {

    @AndroidFindBy(accessibility = "Cities")
    WebElement citiesButton;
    @AndroidFindBy(accessibility = "Search")
    WebElement searchButton;
    @AndroidFindBy(accessibility = "Berlin")
    WebElement checkBoxBerlin;
    @AndroidFindBy(accessibility = "Navigate up")
    WebElement navigateUpButton;
    @AndroidFindBy(id = "search_src_text")
    WebElement searchSrcTextField;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.deskclock:id/city_name\")")
    WebElement cityNameField;

    public ClockPage tapCitiesButton() {
        tap(citiesButton);
        return this;
    }

    public ClockPage tapSearchButton() {
        tap(searchButton);
        return this;
    }

    public ClockPage typeBerlinInSearchField() {
        type(searchSrcTextField, "Berlin");
        tap(checkBoxBerlin);
        tap(navigateUpButton);
        return this;
    }

    public ClockPage checkAddBerlinInClockPage() {
        Assertions.assertEquals("Berlin", cityNameField.getText());
        return this;
    }
}
