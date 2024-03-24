package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public interface AppManager {

    WebDriver driver = new ChromeDriver();

     default void init(){
         driver.navigate().to("https://demoqa.com/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    default void stop(){
         driver.quit();
    }

}
