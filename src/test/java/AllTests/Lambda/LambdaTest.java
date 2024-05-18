package AllTests.Lambda;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LambdaTest extends Setup {
    @Test
    public void test1() {
        init();
        Assert.assertTrue("Заголовок 'LambdaTest Sample App' не найден", startPage.isPageTitle());
        initAfter();
    }

    @Test
    public void test2() {
        init();
        Assert.assertTrue("Заголовок '5 of 5 remaining' не найден", startPage.isRemainingText());
        initAfter();
    }

    @Test
    public void test3() {
        init();
        Assert.assertTrue("Первый элемент списка зачеркнут", startPage.isCheckboxNotDone());
        initAfter();
    }

    @Test
    public void test4() {
        init();
        // Проверяем, установлена ли галочка, и устанавливаем ее
        startPage.isCheckboxDoneCheck();

        // Проверяем, что элемент списка зачеркнут
        Assert.assertTrue("Ошибка: Элемент списка не зачеркнут или класс не найден",
                startPage.isCheckboxNotDone());

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        Assert.assertTrue("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1",
                startPage.isRemainingItemCountDecreased());
    }

    @Test
    public void test31() {
        init();
        for (int i = 2; i <= 5; i++) {
            WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + i + "]/span"));
            Assert.assertTrue("Первый элемент списка зачеркнут", startPage.isCheckboxNotDone1());
        }
        initAfter();
    }

    @Test
    public void test41() {
        init();

        // Находим чекбоксы с индексами от 2 до 5
        for (int i = 2; i <= 5; i++) {
            startPage.checkAndMarkCheckbox(i);
            String classAttributeValue = startPage.getClassAttributeForItem(i);
            if (classAttributeValue.contains("done-true")) {
                System.out.println("Элемент списка " + (i - 1) + " становится зачеркнутым");
            } else {
                System.out.println("Ошибка: Элемент списка " + (i - 1) + " не зачеркнут или класс не найден");
            }
        }

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        int remainingItemsCount = startPage.getRemainingItemCount();
        if (remainingItemsCount == 1) {
            System.out.println("Отображаемое число оставшихся элементов уменьшилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1");
        }
        initAfter();
    }

    @Test
    public void test6() {
        init();

        startPage.addItemToList1("New item");

        // Проверяем, что новый элемент списка не зачеркнут
        if (startPage.isNewItemNotDone()) {
            System.out.println("Новый элемент списка не зачеркнут");
        } else {
            System.out.println("Ошибка: Новый элемент списка зачеркнут или класс не найден");
        }

        // Проверяем, что отображаемое общее число элементов увеличилось на 1
        int totalItemsCount = startPage.getTotalItemsCount();
        if (totalItemsCount == 6) {
            System.out.println("Отображаемое общее число элементов увеличилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое общее число элементов не увеличилось на 1");
        }

        // Проверяем, что отображаемое число оставшихся элементов увеличилось на 1
        int remainingItemsCount = startPage.getRemainingItemsCount();
        if (remainingItemsCount == 6) {
            System.out.println("Отображаемое число оставшихся элементов увеличилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не увеличилось на 1");
        }
    }

    @Test
    public void test7() {
        init();
        startPage.addItem("New Item");
        System.out.println("Добавлен новый элемент");

        // Кликаем по чекбоксу нового элемента
        startPage.clickLastItemCheckbox();

        // Проверяем, что новый элемент списка становится зачеркнутым
        if (startPage.isLastItemDone()) {
            System.out.println("Новый элемент списка становится зачеркнутым");
        } else {
            System.out.println("Ошибка: Новый элемент списка не зачеркнут или класс не найден");
        }

        // Проверяем, что отображаемое число оставшихся элементов уменьшилось на 1
        int remainingItemsCount = startPage.getRemainingItemsCount();
        int totalItemsCount = startPage.getTotalItemsCount();
        if (remainingItemsCount < totalItemsCount) {
            System.out.println("Отображаемое число оставшихся элементов уменьшилось на 1");
        } else {
            System.out.println("Ошибка: Отображаемое число оставшихся элементов не уменьшилось на 1");
        }
    }

}
