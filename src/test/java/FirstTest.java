import org.openqa.selenium.By;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {
    @Test
    public void zipCode4DigtsCheck() {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("input[name=\"zip_code\"]")).sendKeys("234");
        browser.findElement(By.cssSelector("input[value=\"Continue\"]")).click();
        String ErrorMsg = browser.findElement(By.xpath("//span[@class ='error_message']")).getText();
        assertEquals(ErrorMsg, "Oops, error on page. ZIP code should have 5 digits");

    }

    @Test
    public void zipCode5DigtsCheck() {

        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("input[name=\"zip_code\"]")).sendKeys("23456");
        browser.findElement(By.cssSelector("input[value=\"Continue\"]")).click();
        boolean regButtonIsPresent = browser.findElement(By.cssSelector("input[value='Register']")).isDisplayed();
        assertTrue(regButtonIsPresent);

    }
}
