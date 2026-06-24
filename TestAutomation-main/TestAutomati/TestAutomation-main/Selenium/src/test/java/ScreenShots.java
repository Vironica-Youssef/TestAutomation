import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShots {
    WebDriver driver;

    @Test
    public void Screenshots (){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      // File dest = new File("")


    }
}
