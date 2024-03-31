package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{

    default void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('div[id=\"fixedban\"]').style.display='none'");
    }

    default void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"footer\").style.display='none'");
    }

    default void pause(int sec){
        try {
            Thread.sleep(1000L*sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void clickBase(By locator){
        driver.findElement(locator).click();
    }

    default void typeBase(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    default boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

}
