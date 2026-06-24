import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;

//locators
    By leftFram =By.xpath("/html/body");

    @Test
    public void Frames(){
        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
        System.out.println(driver.findElement(leftFram).getText());




    }


}
