
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class weather_details {

    public static AndroidDriver driver = null;
    DesiredCapabilities capabilities;
    static Dimension size;


    @BeforeTest

    public void beforeTest() throws Exception {

        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME","Android");
        capabilities.setCapability("deviceName", "adb:TA-1021");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");

        // This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appPackage","com.climate.farmrise");

        // This is activity name of your app
        // This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity","com.climate.farmrise.SplashScreen");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
        };
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void A1_TestClass_HorizontalAction() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='checkWeatherDetails']")).click();//Click on Access whether details
        Thread.sleep(500);
        Boolean isFoundElement;
        isFoundElement = driver.findElement(By.xpath("//*[@index='23']")).isDisplayed();

        do{
            driver.swipe(835,1254,96,1254,5000);
            System.out.println(isFoundElement);
            isFoundElement = driver.findElement(By.xpath("//*[@index='23']")).isDisplayed();
            System.out.println(isFoundElement);

        }while (isFoundElement == false);
    }

    @Test
    public void A2_TestClass_VerticalAction() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='action_more']")).click();//Click on More
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@text='Government Schemes']")).click();//Click on government schemes
        Thread.sleep(500);

        Boolean isFoundElement;
        isFoundElement = driver.findElements(By.xpath("//*[@id='loadMore']")).size() > 0;
        do{
            driver.swipe(477,1521,477,447 ,5000);
            System.out.println(isFoundElement);
            isFoundElement = driver.findElements(By.xpath("//*[@id='loadMore']")).size()>0;

        }while (isFoundElement == false);

    }


    @Test
    public void A3_TestClass_Search() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='action_more']")).click();//Click on  More
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@text='Government Schemes']")).click();//Click on government schemes
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@resource-id='android:id/search_button']")).sendKeys("scheme");//Click on search and send the element
        driver.findElement(By.xpath("//*[@resource-id='com.google.android.inputmethod.latin:id/icon']")).click();//click on search


    }


    @AfterTest
    //Quit the driver
    public void afterTest() {
        System.out.println("Hello");
        driver.quit();
    }
}
