package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase{

    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.cssSelector("input[placeholder='name@example.com']");
    By fieldMobile = By.id("userNumber");
    By fieldDateOfBirth = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");
    By checkBoxSport = By.xpath("//label[@for='hobbies-checkbox-1']");
    By checkBoxReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");

    By textAreaCurrentAddress = By.id("currentAddress");

    By fieldState = By.id("react-select-3-input");

    By fieldCity = By.id("react-select-4-input");

    By btnForms = By.xpath("//div[@class='category-cards']/div[2]");
    By btnPracticeForm = By.xpath("//span[text()='Practice Form']");

    By btnSubmit = By.id("submit");

    By titleSubmitForm = By.id("example-modal-sizes-title-lg");

    By btnClose = By.id("closeLargeModal");


    default void selectPracticeForm(){
        clickBase(btnForms);
        clickBase(btnPracticeForm);
    }

    default void fillStudentForm(StudentDTO student){
        typeBase(fieldFirstName, student.getFirstName());
        typeBase(fieldLastName, student.getLastName());
        typeBase(fieldEmail, student.getEmail());
        selectGender(student.getGender());
        typeBase(fieldMobile,student.getMobile());
        //typeBase(fieldDateOfBirth,student.getDateOfBirth());
        typeBDayByKeys(student.getDateOfBirth());
        addSubjects(student.getSubjects());
        selectHobby(student.getHobbies());
        typeBase(textAreaCurrentAddress, student.getAddress());
        typeState(student.getState());
        typeCity(student.getCity());
    }


    default void clickBtnSubmit(){
        clickBase(btnSubmit);
    }

    default void typeCity(String city){
        WebElement element = driver.findElement(fieldCity);
        //element.click();
        element.sendKeys(city);
        element.sendKeys(Keys.ENTER);
    }


    default void typeState(String state){
        WebElement element = driver.findElement(fieldState);
        //element.click();
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
    }




    default void selectHobby(String hobbies){
        String[] splitArray = hobbies.split(",");
        for(String str: splitArray){
            switch (str){
                case "Sports":
                    clickBase(checkBoxSport);
                    break;
                case "Reading":
                    clickBase(checkBoxReading);
                    break;
                case "Music":
                    clickBase(checkBoxMusic);
                    break;
            }

        }


    }

    default void addSubjects(String subjects){ //Maths,Physics,Arts
        String[] splitArray = subjects.split(",");
        WebElement element = driver.findElement(fieldSubject);
        element.click();
        for(String sub: splitArray) {
            element.sendKeys(sub);
            element.sendKeys(Keys.ENTER);
        }
    }

    default void typeBDayByKeys(String dateOfBirth){
        WebElement element = driver.findElement(fieldDateOfBirth);
        element.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS --- >" + operationSystem);
        if (operationSystem.startsWith("Win")){
            element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }else if(operationSystem.startsWith("Mac")){
            element.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }
        element.sendKeys(dateOfBirth);
        element.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender){
        if(gender.equals("Male")){
            clickBase(By.xpath("//label[@for='gender-radio-1']"));
        }else if(gender.equals("Female")){
            clickBase(By.xpath("//label[@for='gender-radio-2']"));
        }else{
            clickBase(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

    default boolean isElementPresent_titleSubmitForm(){
        return isElementPresent(titleSubmitForm);
    }

    default void clickBtnClose(){
        clickBase(btnClose);
    }
}
