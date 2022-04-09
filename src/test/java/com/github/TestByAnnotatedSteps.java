package com.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestByAnnotatedSteps {

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
    public void testAnnotatedSteps () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        AnnotatedSteps steps = new AnnotatedSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.searchIssuesText();
        steps.takeScreenshot();
    }

    @Test
    public void doNothingMethod () {
    }

    @Test
    public void doNothingMethodSecond () {
    }

    @Test
    public void doNothingMethodThird () {
    }

}
