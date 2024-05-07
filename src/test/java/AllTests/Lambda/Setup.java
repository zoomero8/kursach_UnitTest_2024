package AllTests.Lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

abstract public class Setup {
    public EventFiringWebDriver driver;

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.get("https://lambdatest.github.io/sample-todo-app/");
    }

    @BeforeEach
    public void init(){
        initializeDriver();
    }

    @AfterEach
    public void initAfter(){
        driver.close();
    }

}
