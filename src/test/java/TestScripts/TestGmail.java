package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestGmail {

    WebDriver driver;
    DesiredCapabilities dp = new DesiredCapabilities();

    @BeforeTest
    public void inti()
    {
        dp.setCapability("deviceName", "ENU7N16324000199");
        dp.setCapability("platform","Android");
        dp.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        dp.setCapability(CapabilityType.VERSION, "8.0.1");

    }

    @Test
    public void testAPP() throws MalformedURLException, InterruptedException {
        driver= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dp);
        driver.get("https://www.gmail.com");
        driver.findElement(By.id("identifierId")).sendKeys("artdesktopauto");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/span/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("artdesktop");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/div[2]")).click();
        Thread.sleep(4000);


    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}

