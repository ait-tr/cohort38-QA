package com.ait.qa.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    Logger LOG = LoggerFactory.getLogger(SelectMenuPage.class);

    @FindBy(id="oldSelectMenu")
    WebElement oldSelectMenu;
    @FindBy(id="react-select-4-input")
    WebElement multiSelect;
    @FindBy(css="html")
    WebElement html;

    public SelectMenuPage selectOldMenuColor(String color) {
//        Класс для работы с элементом select (Выпадающий список)
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);

//        Метод для получения всех значений в выпадающем списке (элемент option)
//        List<WebElement> options = select.getOptions();
//        LOG.info(select.getFirstSelectedOption().getText() + " - Это первый элемент объекта селект");
//        for (WebElement option : options) {
//            LOG.info( option.getText()+ " - Это все остальные элементы option");
//        }
        return this;
    }

    public SelectMenuPage multiSelectColor(String... colors) {
        for (String color : colors) {
            multiSelect.sendKeys(color);
            multiSelect.sendKeys(Keys.ENTER);
        }
        clickOnElement(html);
        return this;
    }
}
