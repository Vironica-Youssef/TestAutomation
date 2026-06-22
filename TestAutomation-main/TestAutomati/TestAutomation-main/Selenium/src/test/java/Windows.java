import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.time.Duration;

public class Windows {
    WebDriver driver;

    //locators
    By ClickHere = By.cssSelector(".example>a");
    By NewTap=By.tagName("h3");

    //Actions
    public void click(By by) {
        driver.findElement(by).click();
    }
    public void type(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    @Test
    public void WindowTaps(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent=driver.getWindowHandle();
        click(ClickHere);
        String Child =driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(Child);

        System.out.println(driver.findElement(NewTap).getText());

    }
}
