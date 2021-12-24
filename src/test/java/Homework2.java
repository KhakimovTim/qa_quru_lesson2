import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework2 {
    @Test
    void fillingFields() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").shouldBe(visible);
        $("[id=firstName]").setValue("Khakimov");

        $("[id=lastName]").shouldBe(visible);
        $("[id=lastName]").setValue("Timur");

        $("[id=userEmail]").shouldBe(visible);
        $("[id=userEmail]").setValue("kyubi9@gmail.com");

        $(".custom-control-label").shouldBe(visible);
        $(".custom-control-label").shouldHave(text("Male")).click();

        $("#userNumber").shouldBe(visible);
        $("#userNumber").setValue("89991349355");

        $("#dateOfBirthInput").scrollTo();
        $("#dateOfBirthInput").shouldBe(visible);
        $("#dateOfBirthInput").click();
        //  $(".aria-label=Choose Monday, December 6th, 2021").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2022");
        $("[aria-label='Choose Tuesday, March 22nd, 2022']").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Eng");
        // $(".subjects-auto-complete__menu css-2613qy-menu").shouldHave(text("English")).click();
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").shouldBe(visible);
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").shouldBe(visible);
        $("#uploadPicture").uploadFile(new File("src/test/resources/images/1.png"));

        $("#currentAddress").shouldBe(visible);
        $("#currentAddress").setValue("no current address");

        $("#state").scrollTo();
        $("#state").shouldBe(visible);
        $("#city").shouldBe(visible);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        //$(". css-2613qy-menu").$(byText("Panipat")).click();

        $("#submit").click();
        sleep(10000);
    }

    @Test
    void assertTest(){
        $("#example-modal-sizes-title-lg").shouldBe(visible);

        $(".table-responsive").shouldHave(text("Khakimov"), text("Timur"), text("kyubi9@gmail.com"),
                text("Male"), text("9789678967"), text("25 December,2021"), text("English, Computer Science"),
                text("Music"), text("1.png"), text("no current address"), text("Haryana Panipat"));
    }
}