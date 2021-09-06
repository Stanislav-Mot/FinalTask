package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SaveJobTitleUserPage {
    public SelenideElement getJobTitleCreated() {
        return jobTitleCreated;
    }

    public SelenideElement getJobDescriptionCreated() {
        return jobDescriptionCreated;
    }

    public SelenideElement getJobSpecificationCreated() {
        return jobSpecificationCreated;
    }

    public SelenideElement getNoteCreated() {
        return noteCreated;
    }

    private final SelenideElement jobTitleCreated = $x("//input[@id='jobTitle_jobTitle']");
    private final SelenideElement jobDescriptionCreated = $x("//textarea[@id='jobTitle_jobDescription']");
    private final SelenideElement jobSpecificationCreated = $x("//span[@id='fileLink']/a");
    private final SelenideElement noteCreated = $x("//textarea[@id='jobTitle_note']");
}
