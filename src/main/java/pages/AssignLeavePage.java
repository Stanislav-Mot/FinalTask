package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import static com.codeborne.selenide.Selenide.$x;

public class AssignLeavePage {
    private final SelenideElement employeeName = $x("//input[@id='assignleave_txtEmployee_empName']");
    private final SelenideElement leaveType = $x("//select[@id='assignleave_txtLeaveType']");
    private final SelenideElement leaveBalance = $x("//div[@id='assignleave_leaveBalance']");
    private final SelenideElement fromDate = $x("//input[@id='assignleave_txtFromDate']");
    private final SelenideElement toDate = $x("//input[@id='assignleave_txtToDate']");
    private final SelenideElement comment = $x("//textarea[@id='assignleave_txtComment']");
    private final SelenideElement assignButton = $x("//input[@id='assignBtn']");
    private final SelenideElement employeeNameLabel = $x("//label[@for='assignleave_txtEmployee']");
    private final SelenideElement leaveTypeLabel = $x("//label[@for='assignleave_txtLeaveType']");
    private final SelenideElement leaveBalanceLabel = $x("//label[@for='assignleave_leaveBalance']");
    private final SelenideElement fromDateLabel = $x("//label[@for='assignleave_txtFromDate']");
    private final SelenideElement toDateLabel = $x("//label[@for='assignleave_txtToDate']");
    private final SelenideElement commentLabel = $x("//label[@for='assignleave_txtComment']");
    private final SelenideElement typeName = $x("//option[contains(text(), 'CAN - Matternity')]");
    private final SelenideElement viewDetails = $x("//a[@id='leaveBalance_details_link']");
    private final SelenideElement balance = $x("//td[@id='balance_total']");
    private final SelenideElement ok = $x("//input[@id='closeButton'][1]");

    public SelenideElement getEmployeeName() {
        return employeeName;
    }

    public SelenideElement getLeaveType() {
        return leaveType;
    }

    public SelenideElement getLeaveBalance() {
        return leaveBalance;
    }

    public SelenideElement getFromDate() {
        return fromDate;
    }

    public SelenideElement getToDate() {
        return toDate;
    }

    public SelenideElement getComment() {
        return comment;
    }

    public SelenideElement getAssignButton() {
        return assignButton;
    }

    public SelenideElement getEmployeeNameLabel() {
        return employeeNameLabel;
    }

    public SelenideElement getLeaveTypeLabel() {
        return leaveTypeLabel;
    }

    public SelenideElement getLeaveBalanceLabel() {
        return leaveBalanceLabel;
    }

    public SelenideElement getFromDateLabel() {
        return fromDateLabel;
    }

    public SelenideElement getToDateLabel() {
        return toDateLabel;
    }

    public SelenideElement getCommentLabel() {
        return commentLabel;
    }

    @Step("Enter assign leave data")
    public void enterAssignLeaveData(String name, String date) {
        Log.info("Enter assign leave data");
        employeeName.sendKeys(name);
        leaveType.click();
        typeName.click();
        fromDate.click();
        fromDate.sendKeys(date);
        toDate.pressEnter();
        comment.sendKeys(name);
    }

    @Step("Get balance assign's")
    public double getBalanceAssign() {
        Log.info("Get balance assign's");
        viewDetails.click();
        double balanceResult = Double.parseDouble(balance.getText());
        ok.click();
        return balanceResult;
    }

    @Step("Click assign button")
    public void clickAssignButton() {
        Log.info("Click assign button");
        assignButton.click();
    }
}
