package extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_helpers.BaseHelper;

public class RunnerExtension implements AfterTestExecutionCallback, BeforeTestExecutionCallback {
    private final Logger logger = LoggerFactory.getLogger(RunnerExtension.class);

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Boolean testResult = context.getExecutionException().isPresent();
        //false - SUCCESS, true - FAILED
        if (!testResult) {
            logger.info(String.format("Тест %s в %s успешно завершен", context.getDisplayName(), context.getTestClass().get()));
        } else {
            logger.error(String.format("Тест %s в %s завершен с ошибкой. Скриншот - %s", context.getDisplayName(), context.getTestClass().get(), BaseHelper.takeScreenshot()));
        }
        logger.info("======================================================================");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        logger.info(String.format("Запуск теста %s в %s", context.getDisplayName(), context.getTestClass().get()));
    }
}
