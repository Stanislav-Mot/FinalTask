package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import static com.codeborne.selenide.Selenide.$x;

public class ViewEmployeeListPage {
    private final SelenideElement subUnitButton = $x("//select[@id='empsearch_sub_unit']");
    private final SelenideElement salesButton = $x("//select[@id='empsearch_sub_unit']/child::option[@value='8']");
    private final SelenideElement searchButton = $x("//input[@id='searchBtn']");
    private final SelenideElement salesEmployee = $x("//table[@id='resultTable']/child::tbody/tr/td[2]/a[1]");

    @Step("Click search sales button")
    public ViewEmployeeListPage clickSearchSales() {
        Log.info("Search sales");
        subUnitButton.click();
        salesButton.click();
        searchButton.click();
        return new ViewEmployeeListPage();
    }

    @Step("Click sales employee")
    public void clickSalesEmployee() {
        Log.info("Click sales employee");
        salesEmployee.click();
    }
}
