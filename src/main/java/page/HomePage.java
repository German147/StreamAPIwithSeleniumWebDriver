package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By links = By.cssSelector("a[href^='https']");
    private final By rows = By.cssSelector(" tbody > tr");
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getLinks() {
        return driver.findElements(links);
    }

    public void openCheckBoxPage() {
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }

    private List<WebElement> getTableRaws() {
        return driver.findElements(rows);
    }

    public void selectRows(String gender) {
        List<WebElement> tableRaws = getTableRaws();
        tableRaws.stream()
                .skip(1)
                .map(tr->tr.findElements(By.tagName("td")))
                .filter(tdList->tdList.get(1).getText().equalsIgnoreCase(gender))
                .map(tdList->tdList.get(3))
                .map(td->td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
    }
}
