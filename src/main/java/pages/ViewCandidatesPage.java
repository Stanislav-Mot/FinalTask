package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class ViewCandidatesPage {

    private final SelenideElement addButton = $x("//input[@id='btnAdd']");
    private final SelenideElement candidateName = $x("//input[@id='candidateSearch_candidateName']");
    private final SelenideElement searchButton = $x("//input[@id='btnSrch']");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement acceptButton = $x("//input[@id='dialogDeleteBtn']");
    private final SelenideElement resultTable = $x("//table[@id='resultTable']");

    @Step("Click to add candidate")
    public AddCandidatePage clickAddCandidates() {
        Log.info("Click to add candidates");
        addButton.click();
        return new AddCandidatePage();
    }

    @Step("Search candidate")
    public ViewCandidatesPage searchCandidate(String name) {
        Log.info("Search candidates");
        candidateName.sendKeys(name);
        searchButton.click();
        return new ViewCandidatesPage();
    }

    @Step("Delete candidate")
    public void deleteCandidate(String name) {
        Log.info("Delete candidates");
        String checkBox = "//a[contains(text(), '%s')]/../..//input[@type='checkbox']";
        $x(String.format(checkBox, name)).click();
        deleteButton.click();
        acceptButton.click();
    }

    @Step("Search deleting candidate")
    public boolean searchDeleteCandidate(String name) {
        Log.info("Search deleting candidates");
        return resultTable.find(By.name(name)).exists();
    }
}
