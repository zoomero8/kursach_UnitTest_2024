package AllTests.MosPoly;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MosPolyTest {

    private WebDriver driver;

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mospolytech.ru/");
    }

    @Test
    public void test1(){

    }
}
