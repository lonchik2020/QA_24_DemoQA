package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public interface HelperStudent extends HelperBase{

    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.cssSelector("input[placeholder='name@example.com']");
    By fieldMobile = By.id("userNumber");
    By fieldDateOfBirth = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");
    By checkBoxSport = By.id("hobbies-checkbox-1");
    By checkBoxReading = By.id("hobbies-checkbox-2");
    By checkBoxMusic = By.id("hobbies-checkbox-3");
    By btnForms = By.xpath("//div[@class='category-cards']/div[2]");
    By btnPracticeForm = By.xpath("//span[text()='Practice Form']");


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
        typeBase(fieldDateOfBirth,student.getDateOfBirth());
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
}
