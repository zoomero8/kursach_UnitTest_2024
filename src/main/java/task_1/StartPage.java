package task_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StartPage {
    public WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div/h2")
    private WebElement pageTitle;

    @FindBy(xpath = "/html/body/div[1]/div/div/span")
    private WebElement ofRemain;

    @FindBy(xpath = "/html/body/div[1]/div/div/ul/li[1]/input")
    private WebElement firstCheckbox;

    @FindBy(xpath = "//*[@id='sampletodotext")
    private WebElement inputField;

    @FindBy(xpath = "/html/body/div[1]/div/div/span")
    private WebElement totalItems;

    @FindBy(xpath = "/html/body/div[1]/div/div/ul/li[last()]/span")
    private WebElement newItem;

    @FindBy(xpath = "/html/body/div[1]/div/div/ul/li[1]/span")
    private WebElement elementWithDoneTrueClass;

    @FindBy(xpath = "/html/body/div[1]/div/div/span")
    private WebElement remainingItems;

    @FindBy(xpath = "//*[@id=\"addbutton\"]")
    private WebElement addButton;

    @FindBy(xpath = "/html/body/div/div/div/ul/li[last()]/input")
    private WebElement newItemCheckbox;

    @FindBy(xpath = "/html/body/div[1]/div/div/ul/li/input")
    private List<WebElement> checkboxes;

    public boolean isPageTitle() {
        return pageTitle.isDisplayed() && pageTitle.getText().contains("LambdaTest Sample App");
    }

    public boolean isRemainingText() {
        return ofRemain.isDisplayed() && ofRemain.getText().contains("5 of 5 remaining");
    }

    public boolean isCheckboxNotDone() {
        String classAttributeValue = firstCheckbox.getAttribute("class");
        return !classAttributeValue.contains("done-false");
    }

    public boolean isCheckboxDoneCheck() {
        String classAttributeValue = firstCheckbox.getAttribute("class");
        if(!classAttributeValue.contains("done-false"))
            firstCheckbox.click();
        return classAttributeValue.contains("done-false");
    }

    public boolean isRemainingItemCountDecreased() {
        String remainingItemsText = remainingItems.getText();
        int remainingItemsCount = Integer.parseInt(remainingItemsText.substring(0, 1));
        return remainingItemsCount == 4;
    }

    public boolean isCheckboxNotDone1() {
        String classAttributeValue = firstCheckbox.getAttribute("class");
        return !classAttributeValue.contains("done-false");
    }

    public void checkAndMarkCheckbox(int index) {
        WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + index + "]/input"));
        String classAttribute = checkbox.getAttribute("class");
        if (!classAttribute.contains("done-true")) {
            checkbox.click();
        }
    }

    public String getClassAttributeForItem(int index) {
        WebElement item = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[" + index + "]/span"));
        return item.getAttribute("class");
    }

    public int getRemainingItemCount() {
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div[1]/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        return Integer.parseInt(remainingItemsText.substring(0, 1));
    }

    public void addItemToList1(String itemText) {
        WebElement inputField = driver.findElement(By.xpath("//*[@id='sampletodotext']"));
        inputField.sendKeys(itemText);
        WebElement addButton = driver.findElement(By.xpath("//*[@id='addbutton']"));
        addButton.click();
    }

    public boolean isNewItemNotDone() {
        WebElement newItem = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[last()]/span"));
        return newItem.getAttribute("class").contains("done-false");
    }

    public void addItem(String itemText) {
        WebElement inputField = driver.findElement(By.xpath("//*[@id='sampletodotext']"));
        inputField.sendKeys(itemText);
        WebElement addButton = driver.findElement(By.xpath("//*[@id='addbutton']"));
        addButton.click();
    }

    public void clickLastItemCheckbox() {
        WebElement newItemCheckbox = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[last()]/input"));
        newItemCheckbox.click();
    }

    public boolean isLastItemDone() {
        WebElement newItem = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[last()]/span"));
        return newItem.getAttribute("class").contains("done-true");
    }

    public int getRemainingItemsCount() {
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        return Integer.parseInt(remainingItemsText.split(" ")[0]);
    }

    public int getTotalItemsCount() {
        WebElement remainingItems = driver.findElement(By.xpath("/html/body/div/div/div/span"));
        String remainingItemsText = remainingItems.getText();
        return Integer.parseInt(remainingItemsText.split(" ")[2]);
    }
}


