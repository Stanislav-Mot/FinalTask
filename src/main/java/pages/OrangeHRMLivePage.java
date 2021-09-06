package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import static com.codeborne.selenide.Selenide.$x;

public class OrangeHRMLivePage {

    private final SelenideElement welcomeMessage = $x("//a[@id='welcome']");
    private final SelenideElement viewAdminModule = $x("//a[@id='menu_admin_viewAdminModule']");
    private final SelenideElement userManagementButton = $x("//a[@id='menu_admin_UserManagement']");
    private final SelenideElement userButton = $x("//a[@id='menu_admin_viewSystemUsers']");
    private final SelenideElement adminJob = $x("//a[@id='menu_admin_Job']");
    private final SelenideElement jobTitle = $x("//a[@id='menu_admin_viewJobTitleList']");
    private final SelenideElement recruitmentButton = $x("//a[@id='menu_recruitment_viewRecruitmentModule']");
    private final SelenideElement candidatesButton = $x("//a[@id='menu_recruitment_viewCandidates']");
    private final SelenideElement leaveButton = $x("//a[@id='menu_leave_viewLeaveModule']");
    private final SelenideElement assignLeaveButton = $x("//a[@id='menu_leave_assignLeave']");
    private final SelenideElement dashboardButton = $x("//a[@id='menu_dashboard_index']");
    private final SelenideElement pimButton = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement employeeListButton = $x("//a[@id='menu_pim_viewEmployeeList']");
    private final SelenideElement myInfoButton = $x("//a[@id='menu_pim_viewMyDetails']");
    private final SelenideElement marketplaceButton = $x("//input[@id='MP_link']");
    private final SelenideElement subscribeButton = $x("//input[@id='Subscriber_link']");
    private final SelenideElement logoutButton = $x("//div[@id='welcome-menu']/child::ul/li[3]/a");

    @Step("Checking marketplace button")
    public boolean isDisplayedMarketplace() {
        Log.info("Checking marketplace button");
        return marketplaceButton.isDisplayed();
    }

    @Step("Checking subscribe button")
    public boolean isDisplayedSubscribe() {
        Log.info("Checking subscribe button");
        return subscribeButton.isDisplayed();
    }

    @Step("Checking welcome message and button")
    public boolean isOrangeHRMLivePageExistMessageWelcome() {
        Log.info("Checking welcome message and button");
        return welcomeMessage.isDisplayed();
    }

    @Step("Click users button")
    public ViewSystemUsersPage clickUsersButton() {
        Log.info("Click user button");
        viewAdminModule.click();
        userManagementButton.hover();
        userButton.click();
        return new ViewSystemUsersPage();
    }

    @Step("Click job title")
    public ViewJobTitleListPage clickJobTitle() {
        Log.info("Click job title");
        viewAdminModule.click();
        adminJob.hover();
        jobTitle.click();
        return new ViewJobTitleListPage();
    }

    @Step("Clock candidates")
    public ViewCandidatesPage clickCandidates() {
        Log.info("Click candidates");
        recruitmentButton.click();
        candidatesButton.click();
        return new ViewCandidatesPage();
    }

    @Step("Click assign leave")
    public AssignLeavePage clickAssignLeave() {
        Log.info("Click assign leave");
        leaveButton.click();
        assignLeaveButton.click();
        return new AssignLeavePage();
    }

    @Step("Click dashboard")
    public void clickDashboard() {
        Log.info("Click dashboard");
        dashboardButton.click();
    }

    @Step("click employee list")
    public ViewEmployeeListPage clickEmployeeList() {
        Log.info("Click employee list");
        pimButton.click();
        employeeListButton.click();
        return new ViewEmployeeListPage();
    }

    @Step("Click my info")
    public void clickMyInfo() {
        Log.info("Click my info");
        myInfoButton.click();
    }

    @Step("Click logout")
    public void clickLogout() {
        Log.info("Click logout");
        welcomeMessage.click();
        logoutButton.click();
    }
}
