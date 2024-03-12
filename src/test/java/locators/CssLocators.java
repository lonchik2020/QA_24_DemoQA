package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CssLocators {
    WebDriver driver;


    @Test
    public void start(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement elementFullName = driver.findElement(By.cssSelector("input"));
        System.out.println("----> " + elementFullName.getAttribute("placeholder"));

        WebElement elementEmail = driver.findElement(By.cssSelector("input[type='email']"));
        System.out.println("----> " + elementEmail.getAttribute("placeholder"));

        WebElement elementCurrAdd = driver.findElement(By.cssSelector("#currentAddress"));
        System.out.println("----> " + elementCurrAdd.getTagName());



        driver.quit();
    }

    @Test
    public void buttons(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement elementBtn1 = driver.findElement(By.cssSelector("#doubleClickBtn"));
        System.out.println("----> " + elementBtn1.getText());

        WebElement elementBtn2 = driver.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6'] div[class='mt-4']>button"));
        System.out.println("----> " + elementBtn2.getText());

        List<WebElement>elementList = driver.findElements(By.cssSelector
                ("div[class='col-12 mt-4 col-md-6'] div[class='mt-4']>button"));
        System.out.println("size ----> " + elementList.size());

        for (WebElement el:elementList) {
            System.out.println("text ----> " + el.getText());
        }

        //tree search
        WebElement elementSpan = driver.findElement(By.cssSelector("ul.menu-list>#item-3>span"));
        System.out.println("----> " + elementSpan.getText());


        //driver.quit();
    }




}
