package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathLocators {
    WebDriver driver;

    @Test
    public void firstXpath(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement buttonHome = driver.findElement(By.xpath("//button[@title='Toggle']"));
        buttonHome.click();

        WebElement checkBoxDesktop = driver.findElement(By.xpath("//label[@for='tree-node-desktop']"));
        System.out.println(checkBoxDesktop.getLocation().getX());
        System.out.println(checkBoxDesktop.getLocation().getY());




        driver.quit();
    }
}
