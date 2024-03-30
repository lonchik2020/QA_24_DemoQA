package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentFormTests extends TestBase implements HelperStudent {

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

    }
}
