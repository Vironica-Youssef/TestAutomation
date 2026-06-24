import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    //locators
    By confirmAlert = By.cssSelector("[onclick=\"jsAlert()\"]");
    By DismissAlert = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By PromptAlert = By.cssSelector("[onclick=\"jsPrompt()\"]");


    @Test
    public void confirm (){
        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(confirmAlert).click();
        driver.switchTo().alert().accept();

    }

    @Test
    public void Dismiss (){
        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(DismissAlert).click();
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void prompt (){
        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(PromptAlert).click();
        driver.switchTo().alert().sendKeys("Hi");
        driver.switchTo().alert().accept();

    }

    @Test
    public void GetTesxt (){
        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(confirmAlert).click();
        String Alert = driver.switchTo().alert().getText();
        System.out.println(Alert);

    }
}
