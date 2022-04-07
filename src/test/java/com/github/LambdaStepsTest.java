package com.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String REPOSITORY = "Stalnyetapki/qa_guru_11_7_homework";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    public void searchIssueTest (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем новую страницу", () -> {
            Selenide.open("https://github.com/");
        });

        step("Ищем репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Открываем репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Проверяем, что в репозитории " + REPOSITORY + " существует таб c текстом \"Issues\"", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }
}
