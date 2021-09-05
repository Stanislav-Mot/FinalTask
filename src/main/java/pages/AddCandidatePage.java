package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class AddCandidatePage {
    private final SelenideElement firstName = $x("//input[@id='addCandidate_firstName']");
    private final SelenideElement middleName = $x("//input[@id='addCandidate_middleName']");
    private final SelenideElement lastName = $x("//input[@id='addCandidate_lastName']");
    private final SelenideElement email = $x("//input[@id='addCandidate_email']");
    private final SelenideElement contactNo = $x("//input[@id='addCandidate_contactNo']");
    private final SelenideElement jobVacancy = $x("//select[@id='addCandidate_vacancy']");
    private final SelenideElement vacancyName = $x("//option[contains(text(), 'Senior QA Lead')]");
    private final SelenideElement resume = $x("//input[@id='addCandidate_resume']");
    private final SelenideElement keywords = $x("//input[@id='addCandidate_keyWords']");
    private final SelenideElement comment = $x("//textarea[@id='addCandidate_comment']");
    private final SelenideElement consentToKeepData = $x("//input[@id='addCandidate_consentToKeepData']");
    private final SelenideElement saveButton = $x("//input[@id='btnSave']");
    private final SelenideElement errorFirstName = $x("//span[@for='addCandidate_firstName']");
    private final SelenideElement errorLastName = $x("//span[@for='addCandidate_lastName']");

    public SelenideElement getErrorFirstName() {
        return errorFirstName;
    }

    public SelenideElement getErrorLastName() {
        return errorLastName;
    }

    public SelenideElement getErrorEmail() {
        return errorEmail;
    }

    private final SelenideElement errorEmail = $x("//span[@for='addCandidate_email']");

    @Step("Enter data candidate's")
    public void enterCandidateData(String name, String mail, File file, String contact) {
        Log.info("Enter candidates data");
        firstName.sendKeys(name);
        middleName.sendKeys(name);
        lastName.sendKeys(name);
        email.sendKeys(mail);
        contactNo.sendKeys(contact);
        jobVacancy.click();
        vacancyName.click();
        resume.uploadFile(file);
        keywords.sendKeys(name);
        comment.sendKeys(name);
        consentToKeepData.click();
        saveButton.click();
    }

    @Step("Click save button")
    public void clickSave() {
        Log.info("Click save button");
        saveButton.click();
    }
}