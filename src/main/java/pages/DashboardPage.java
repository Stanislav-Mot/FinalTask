package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement assignLeave = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'Assign Leave')]/../img");
    private final SelenideElement leaveList = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'Leave List')]/../img");
    private final SelenideElement timeSheets = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'Timesheets')]/../img");
    private final SelenideElement applyLeave = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'Apply Leave')]/../img");
    private final SelenideElement myLeave = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'My Leave')]/../img");
    private final SelenideElement myTimesheet = $x("//div[@class='quickLaunge']/child::a/child::span[contains(text(), 'My Timesheet')]/../img");
    private final SelenideElement employeeDistribution = $x("//fieldset[@id='panel_resizable_1_0']");
    private final SelenideElement legend = $x("//fieldset[@id='panel_resizable_1_1']");
    private final SelenideElement pendingLeave = $x("//fieldset[@id='panel_resizable_1_2']");

    public SelenideElement getAssignLeave() {
        return assignLeave;
    }

    public SelenideElement getLeaveList() {
        return leaveList;
    }

    public SelenideElement getTimeSheets() {
        return timeSheets;
    }

    public SelenideElement getApplyLeave() {
        return applyLeave;
    }

    public SelenideElement getMyLeave() {
        return myLeave;
    }

    public SelenideElement getMyTimesheet() {
        return myTimesheet;
    }

    public SelenideElement getEmployeeDistribution() {
        return employeeDistribution;
    }

    public SelenideElement getLegend() {
        return legend;
    }

    public SelenideElement getPendingLeave() {
        return pendingLeave;
    }
}
