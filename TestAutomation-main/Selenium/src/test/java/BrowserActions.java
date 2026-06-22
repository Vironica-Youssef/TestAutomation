import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserActions {
    WebDriver driver;

    //Test runner
    @Test
    public void testCase() {

        driver = new EdgeDriver();
        navigateTo("https://www.google.com/");
        maximize();
        getCurrentURL();
        getCurrentTitle();
        getWindowHandle();
        closeBrowser();
        quitBrowser();

        getPageSource();
        fullScreen();
        setPosition(200, 200);
        setSize(430, 932);
        navigateTo("https://www.google.com/");
        navigateTo("https://www.facebook.com/");
        navigateBack();
        navigateForward();
        refreshPage();
    }


    //Methods for browser actions
    public void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void minimize() {
        driver.manage().window().minimize();
    }

    public void setPosition(int x, int y) {
//        Point point = new Point(100, 100);
        driver.manage().window().setPosition(new Point(x, y));
    }

    public void setSize(int width, int height) {
//        Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void getCurrentURL() {
        String URL = driver.getCurrentUrl();
        System.out.println("Current URL: " + URL);
    }

    public void getCurrentTitle() {
        String title = driver.getTitle();
        System.out.println("Current Title: " + title);
    }

    public void getPageSource() {
        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);
    }

    public void getWindowHandle() {
        String windowHandle = driver.getWindowHandle();
        System.out.println("Window Handle: " + windowHandle);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }


}