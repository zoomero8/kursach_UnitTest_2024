package LambdaTestSample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LambdaTest {

    private WebDriver driver;

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lambdatest.github.io/sample-todo-app/");
    }

    @Test
    public void test1() {
        initializeDriver();
        WebElement pageTitle = driver.findElement(By.xpath("/html/body/div/div/h2"));
        if (pageTitle.getText().equalsIgnoreCase("LambdaTest Sample App")) {
            System.out.println("Заголовок соответствует");
        } else {
            System.out.println("Заголовок не соответствует");
        }
        driver.quit();
    }

    @Test
    public void test2() {
        initializeDriver();
        WebElement ofremain = driver.findElement(By.xpath("/html/body/div[1]/div/div/span"));
        if (ofremain.getText().equalsIgnoreCase("5 of 5 remaining")) {
            System.out.println("Текст есть");
        } else {
            System.out.println("Текста нет, или не соответствует");
        }
        driver.quit();
    }

    @Test
    public void test3() {
        initializeDriver();
        WebElement firstCheckbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[1]/span"));
        String classAttributeValue = firstCheckbox.getAttribute("class");
        if (classAttributeValue.contains("done-false")) {
            System.out.println("Первый элемент списка не зачеркнут");
        } else {
            System.out.println("Первый элемент списка зачеркнут или не найден");
        }
        driver.quit();
    }

    @Test
    public void test4() {
        initializeDriver();

        // Находим чекбокс
        WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[1]/input"));

        // Проверяем, установлена ли галочка, и устанавливаем ее, если нужно
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        // Проверяем, что класс элемента изменился на "done-true"
        WebElement elementWithDoneTrueClass = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[1]/span"));
        String classAttributeValue = elementWithDoneTrueClass.getAttribute("class");
        if (classAttributeValue.contains("done-true")) {
            System.out.println("Элемент списка становится зачеркнутым");
        } else {
            System.out.println("Ошибка: Элемент списка не зачеркнут или класс не найден");
        }

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div[1]/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        int remainingItemsCount = Integer.parseInt(remainingItemsText.substring(0, 1));
        if (remainingItemsCount == 4) {
            System.out.println("Отображаемое число оставшихся элементов уменьшилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1");
        }
    }

    @Test
    public void test31() {
        initializeDriver();
        for (int i = 2; i <= 5; i++) {
            // Находим чекбокс
            WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + i + "]/span"));
            // Проверяем, что чекбокс не зачеркнут
            String classAttributeValue = checkbox.getAttribute("class");
            if (classAttributeValue.contains("done-false")) {
                System.out.println("Чекбокс " + (i) + " не зачеркнут");
            } else {
                System.out.println("Ошибка: Чекбокс " + (i) + " зачеркнут или не найден");
            }
        }
        driver.quit();
    }

    @Test
    public void test41() {
        initializeDriver();

        // Находим чекбоксы с индексами от 2 до 5
        for (int i = 2; i <= 5; i++) {
            // Находим чекбокс
            WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + i + "]/input"));

            // Проверяем, установлена ли галочка, и устанавливаем ее, если нужно
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            // Проверяем, что класс элемента изменился на "done-true"
            WebElement elementWithDoneTrueClass = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + i + "]/span"));
            String classAttributeValue = elementWithDoneTrueClass.getAttribute("class");
            if (classAttributeValue.contains("done-true")) {
                System.out.println("Элемент списка " + (i - 1) + " становится зачеркнутым");
            } else {
                System.out.println("Ошибка: Элемент списка " + (i - 1) + " не зачеркнут или класс не найден");
            }
        }

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div[1]/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        int remainingItemsCount = Integer.parseInt(remainingItemsText.substring(0, 1));
        if (remainingItemsCount == 1) {
            System.out.println("Отображаемое число оставшихся элементов уменьшилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1");
        }

        driver.quit();
    }

    @Test
    public void test6() {
        initializeDriver();

        // Находим поле ввода нового элемента списка
        WebElement inputField = driver.findElement(By.xpath("//*[@id='sampletodotext']"));

        // Вводим новый элемент
        inputField.sendKeys("New item");

        // Находим кнопку "Add"
        WebElement addButton = driver.findElement(By.xpath("//*[@id='addbutton']"));

        // Нажимаем на кнопку "Add"
        addButton.click();

        // Проверяем, что новый элемент списка не зачеркнут
        WebElement newItem = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[last()]/span"));
        String classAttributeValue = newItem.getAttribute("class");
        if (classAttributeValue.contains("done-false")) {
            System.out.println("Новый элемент списка не зачеркнут");
        } else {
            System.out.println("Ошибка: Новый элемент списка зачеркнут или класс не найден");
        }

        // Проверяем, что отображаемое общее число элементов увеличилось на 1
        WebElement totalItems = driver.findElement(By.xpath("/html/body/div[1]/div/div/span"));
        String totalItemsText = totalItems.getText();
        int totalItemsCount = Integer.parseInt(totalItemsText.split(" ")[0]); // Получаем первый элемент после разделения по пробелу
        if (totalItemsCount == 6) {
            System.out.println("Отображаемое общее число элементов увеличилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое общее число элементов не увеличилось на 1");
        }

        // Проверяем, что отображаемое число оставшихся элементов увеличилось на 1
        int remainingItemsCount = Integer.parseInt(totalItemsText.split(" ")[2]); // Получаем третий элемент после разделения по пробелу
        if (remainingItemsCount == 6) {
            System.out.println("Отображаемое число оставшихся элементов увеличилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не увеличилось на 1");
        }
    }

    @Test
    public void test7() {
        initializeDriver();

        // Находим поле ввода для нового элемента списка и вводим текст
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"sampletodotext\"]"));
        inputField.sendKeys("New Item");
        System.out.println("Добавлен новый элемент");

        // Нажимаем кнопку "Add"
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"addbutton\"]"));
        addButton.click();

        // Находим новый элемент списка (пятый) и кликаем на него
        WebElement newItemCheckbox = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[last()]/input"));
        newItemCheckbox.click();

        // Проверяем, что новый элемент списка становится зачеркнутым
        WebElement newItem = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[last()]/span"));
        String classAttributeValue = newItem.getAttribute("class");
        if (classAttributeValue.contains("done-true")) {
            System.out.println("Новый элемент списка становится зачеркнутым");
        } else {
            System.out.println("Ошибка: Новый элемент списка не зачеркнут или класс не найден");
        }

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        String[] remainingItemsArray = remainingItemsText.split(" ");
        int remainingItemsCount = Integer.parseInt(remainingItemsArray[0]); // Получаем первый элемент после разделения по пробелу
        int totalItemsCount = Integer.parseInt(remainingItemsArray[2]); // Получаем третий элемент после разделения по пробелу
        if (remainingItemsCount < totalItemsCount) {
            System.out.println("Отображаемое число оставшихся элементов уменьшилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1");
        }
    }



}
