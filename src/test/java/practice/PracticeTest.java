package practice;

import base.BaseTests;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeTest extends BaseTests {

    @Test
    public void getGoogleLinks() {
        List<WebElement> links = homePage.getLinks();
        links.stream()
                .filter(e -> e.getText().trim().length() > 0)
                .filter(e -> !e.getText().toLowerCase().contains("r"))
                .map(e -> e.getText().toUpperCase())
                .forEach(System.out::println);

    }

    @Test(dataProvider = "gender")
    public void tickCheckBoxByGenderTest(String gender) {
        homePage.openCheckBoxPage();
        homePage.selectRows(gender);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @DataProvider(name = "gender")
    public Object[] genderProviderCheckBox() {
        return new Object[]{
                "male",
                "female"
        };
    }
}
