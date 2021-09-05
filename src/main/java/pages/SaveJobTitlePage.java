package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class SaveJobTitlePage {
    private final SelenideElement jobTitle = $x("//input[@id='jobTitle_jobTitle']");
    private final SelenideElement jobDescription = $x("//textarea[@id='jobTitle_jobDescription']");
    private final SelenideElement jobSpecification = $x("//input[@id='jobTitle_jobSpec']");
    private final SelenideElement note = $x("//textarea[@id='jobTitle_note']");
    private final SelenideElement saveButton = $x("//input[@id='btnSave']");

    public SelenideElement getErrorSave() {
        return errorSave;
    }

    private final SelenideElement errorSave = $x("//span[@for='jobTitle_jobTitle']");

    @Step("Enter data job's")
    public ViewJobTitleListPage enterJobFields(String jobTitlePar, File picture) {
        Log.info("Enter job fields");
        jobTitle.sendKeys(jobTitlePar);
        jobDescription.sendKeys(jobTitlePar);
        jobSpecification.uploadFile(picture);
        note.sendKeys(jobTitlePar);
        saveButton.click();
        return new ViewJobTitleListPage();
    }

    @Step("Click save button")
    public void clickSaveButton() {
        Log.info("Click save button");
        saveButton.click();
    }
}
