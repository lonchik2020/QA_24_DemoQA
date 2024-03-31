package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StudentFormTests extends TestBase implements HelperStudent {

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void goToPracticeForm(){
        pause(3);
        hideBanner();
        hideFooter();
        selectPracticeForm();
        hideFooter();
    }

    @Test
    public void studentFormPositiveTest(){
        StudentDTO student = StudentDTO.builder()
                .firstName("Frodo")
                .lastName("Baggins")
                .email("frodo123@mail.com")
                .gender("Female")
                .mobile("1234567890")
                .dateOfBirth("22 Aug 2007")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Street 1, app.2")
                .state("NCR")
                .city("Delhi")
                .build();
        fillStudentForm(student);
        clickBtnSubmit();
        //Assert.assertTrue(isElementPresent_titleSubmitForm());
        softAssert.assertTrue(isElementPresent_titleSubmitForm());

        WebElement elementEmail = driver.findElement(By.xpath("//tbody/tr[2]/td[last()]"));
        System.out.println(elementEmail.getText());
        WebElement elementPhone = driver.findElement(By.xpath("//tbody/tr[4]/td[last()]"));
        System.out.println(elementPhone.getText());
        softAssert.assertEquals(elementEmail.getText(), student.getEmail());
        System.out.println("=========================================");
        softAssert.assertEquals(elementPhone.getText(), student.getMobile());
        softAssert.assertAll("stop test");
        //System.out.println("=========================================");
    }

    @Test
    public void studentFormPositiveTest1() {
        StudentDTO student = StudentDTO.builder()
                .firstName("Frodo-1")
                .lastName("Baggins-1")
                .email("frodo123@mail.com")
                .gender("Female")
                .mobile("1234567890")
                .dateOfBirth("22 Aug 2007")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Street 1, app. 2")
                .state("NCR")
                .city("Delhi")
                .build();
        fillStudentForm(student);
        clickBtnSubmit();
        Assert.assertTrue(isElementPresent_titleSubmitForm());
    }


    @Test
    public void studentFormNegativeTest_LastNameEmpty() {
        StudentDTO student = StudentDTO.builder()
                .firstName("Frodo-1")
                .lastName("")
                .email("frodo123@mail.com")
                .gender("Female")
                .mobile("1234567890")
                .dateOfBirth("22 Aug 2007")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Street 1, app. 2")
                .state("NCR")
                .city("Delhi")
                .build();
        fillStudentForm(student);
        clickBtnSubmit();
        Assert.assertFalse(isElementPresent_titleSubmitForm());
    }


    @AfterMethod
    public void afterMethod(){
        pause(1);
        if(isElementPresent_titleSubmitForm())
            clickBtnClose();
        else{
            driver.navigate().refresh();
            hideBanner();
            hideFooter();
        }
    }
}
