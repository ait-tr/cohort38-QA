
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//features - нужно указать где лежат feature фаилы (тест)
//glue - где лежат стэпы (шаги)
//plugin - надо просто запомнить, настройки того, где лежит отчет об АТ
//tags - тэги для запуска
@CucumberOptions(features = "src/test/resources/features",
        glue = "src/java/com/ilcarro/steps",
        tags = "@navigates",
        plugin = {"pretty", "json:build/cucumber-report/cucumber.java"}

)
public class TestRunner {

}
