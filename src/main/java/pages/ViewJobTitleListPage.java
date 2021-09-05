package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class ViewJobTitleListPage {
    private final SelenideElement addButton = $x("//input[@id='btnAdd']");
    private final SelenideElement titleList = $x("//div[@id='jobTitleList']");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement acceptButton = $x("//input[@id='dialogDeleteBtn']");

    @Step("Click to add job")
    public SaveJobTitlePage clickAddJob() {
        Log.info("Click adding job");
        addButton.click();
        return new SaveJobTitlePage();
    }

    @Step("Search adding job")
    public void searchAddedJob(String job) {
        Log.info("Search the added job");
        titleList.find(By.linkText(job)).click();
    }

    @Step("Search deletion job")
    public boolean searchDeleteJob(String jobs) {
        Log.info("Search the deleting job");
        return titleList.find(By.name(jobs)).exists();
    }

    @Step("Delete job")
    public void deleteJob(String name) {
        Log.info("Delete the job");
        String clickBox = "//a[contains(text(), '%s')]/../..//input[@type='checkbox']";
        $x(String.format(clickBox, name)).click();
        deleteButton.click();
        acceptButton.click();
    }
}
