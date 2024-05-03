package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    public DroppablePage dragAndDrop() {
//        Объект класса действия, для переноса, двойного щелчка или для списка действий
        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(draggable, droppable)// действие захвата и переноса одного веб элемента в другой веб элемент
                .perform();// Конечный метод для выполнения всех действий

        Assertions.assertEquals("Dropped!", droppable.getText(), "Объект не перенесен!");
        return this;
    }

}
