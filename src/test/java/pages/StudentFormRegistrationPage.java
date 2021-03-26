package pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentFormRegistrationPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            mobile = faker.numerify("##########"),
            monthOfBirth = "May",
            yearOfBirth = "1988",
            dayOfBirth = "10",
            dayOfWeekOfBirth = "Tuesday",
            subject1 = "Chemistry",
            subject2 = "Commerce",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            picture = "1.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillForm(){
        $("#firstName").setValue(firstName);   //name
        $("#lastName").setValue(lastName);    //lastname
        $("#userEmail").setValue(email);   //emeil

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(mobile);   //phone

        setDate(yearOfBirth, monthOfBirth, dayOfBirth, dayOfWeekOfBirth);

        $("#subjectsContainer").click();   //Subject
        $("#subjectsInput").setValue(subject1).pressEnter();

        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#uploadPicture").uploadFromClasspath(picture);

        $("#currentAddress").val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
    }

    public void setDate(String year, String month, String day, String dayOfWeek){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format("[aria-label='Choose %s, %s %sth, %s']",
                dayOfWeek, month, day, year)).click();
    }

    public void checkData(){
        $(".modal-content").shouldHave(text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(mobile),
                text(subject1),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(hobby1),
                text(picture),
                text(currentAddress),
                text(state + " " + city));
    }
}