package scenario;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentFormRegistrationPage;

public class StudentFormRegistrationTest {
    StudentFormRegistrationPage studentFormRegistrationPage = new StudentFormRegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void automationPractiseFormTest(){
        studentFormRegistrationPage.openPage();
        studentFormRegistrationPage.fillForm();
        studentFormRegistrationPage.checkData();
    }


}
