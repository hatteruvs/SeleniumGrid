
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {

    static WebDriver driver;
    static DesiredCapabilities capabilities;

    @BeforeTest
    public static void setUp() throws MalformedURLException {
        capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://192.168.0.106:6666/wd/hub"), capabilities);
    }

    @org.testng.annotations.Test
        public void testTestFirst() throws Exception {
        driver.get("https://pn.com.ua/");
        driver.findElement(By.xpath("//*[@id='column-center']/section/div[1]/a")).click();
        assert(driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[4]/article[3]/div/div")).getText().equals("IT услуги"));
    }

    @AfterTest
    public static void simpleTest()
    {
        driver.quit();
    }

}
