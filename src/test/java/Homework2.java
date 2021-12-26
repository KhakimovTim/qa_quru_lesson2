import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homework2 {
    @Test
    void fillingFields() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[id=firstName]").setValue("Khakimov");

        $("[id=lastName]").setValue("Timur");

        $("[id=userEmail]").setValue("kyubi9@gmail.com");

        $(".custom-control-label").shouldHave(text("Male")).click();

        $("#userNumber").setValue("8999134935");

        $("#dateOfBirthInput").scrollTo();
        $("#dateOfBirthInput").click();
        //  $(".aria-label=Choose Monday, December 6th, 2021").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label='Choose Tuesday, July 29th, 2008']").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Eng");
        // $(".subjects-auto-complete__menu css-2613qy-menu").shouldHave(text("English")).click();
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("1.png");

        $("#currentAddress").setValue("no current address");

        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        //$(". css-2613qy-menu").$(byText("Panipat")).click();

        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Khakimov Timur"), text("kyubi9@gmail.com"),
                text("Male"), text("8999134935"), text("29 July,2008"), text("English"),
                text("Music"), text("1.png"), text("no current address"), text("Haryana Panipat"));
    }

}