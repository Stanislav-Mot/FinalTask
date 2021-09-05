import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;
import static utils.DataTest.*;

@Owner("Motorin Stanislav")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrangeHRMTests extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final OrangeHRMLivePage orangeHRMLivePage = new OrangeHRMLivePage();
    private final ViewSystemUsersPage viewSystemUsersPage = new ViewSystemUsersPage();

    @Description("Open page")
    @BeforeEach
    public void openPageTest() {
        loginPage.openPage();

        Assertions.assertEquals(LoginPage.getURL(), getWebDriver().getCurrentUrl(),
                "The page didn't open");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login test")
    @Test
    @Order(1)
    public void loginTest() {
        loginPage.loginToTheSite("login", "password");

        Assertions.assertTrue(new pages.OrangeHRMLivePage().isOrangeHRMLivePageExistMessageWelcome(),
                "The login didn't happen");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Correct fields user's")
    @Test
    @Order(2)
    public void userCorrectFieldsTest() {
        ViewSystemUserIDPage viewSystemUserIDPage = new ViewSystemUserIDPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .enterNameOfUserForSearch("login")
                .clickSearchButton()
                .clickUser("login");
        Assertions.assertAll("Should return that the fields are not empty",
                () -> assertTrue(viewSystemUserIDPage.getConditionUserRole(),
                        "The field of 'user role' isn't completed"),
                () -> assertTrue(viewSystemUserIDPage.getConditionEmployeeName(),
                        "The field of 'employee name' isn't completed"),
                () -> assertTrue(viewSystemUserIDPage.getConditionUserName(),
                        "The field of 'user name' isn't completed"),
                () -> assertTrue(viewSystemUserIDPage.getConditionStatus(),
                        "The field of 'status' isn't completed")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking fields user's")
    @Test
    @Order(3)
    public void checkingUserFieldsTest() {
        SaveSystemUserPage saveSystemUserPage = new SaveSystemUserPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .clickAddUser();

        Assertions.assertAll("Checking for the existence of fields",
                () -> assertTrue(saveSystemUserPage.checkingUserRole(),
                        "The field of 'user role' wasn't found"),
                () -> assertTrue(saveSystemUserPage.checkingEmployeeName(),
                        "The field of 'employee name' wasn't found"),
                () -> assertTrue(saveSystemUserPage.checkingUserName(),
                        "The field of 'user name' wasn't found"),
                () -> assertTrue(saveSystemUserPage.checkingStatus(),
                        "The field of 'status' wasn't found"),
                () -> assertTrue(saveSystemUserPage.checkingPassword(),
                        "The field of 'password' wasn't found"),
                () -> assertTrue(saveSystemUserPage.checkingConfirmPassword(),
                        "The field of 'confirm password' wasn't found")
        );
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding user")
    @Test
    @Order(4)
    public void addUserTest() {
        ViewSystemUserIDPage viewSystemUserIDPage = new ViewSystemUserIDPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .clickAddUser()
                .enterUserData(USER_ROLE, EMPLOYEE_NAME, USER_NAME, STATUS, PASSWORD, PASSWORD)
                .clickSave()
                .enterNameOfUserForSearchCreated(USER_NAME)
                .clickSearchButton()
                .clickUserCreated(USER_NAME);
        String userRole = viewSystemUserIDPage.getUserRoleCreated();
        String employeeName = viewSystemUserIDPage.getEmployeeNameCreated();
        String userName = viewSystemUserIDPage.getUserNameCreated();
        String status = viewSystemUserIDPage.getStatusCreated();

        Assertions.assertAll("Checking the correctness of the fields",
                () -> assertEquals(userRole, USER_ROLE,
                        "The data doesn't match in the 'user role' field"),
                () -> assertEquals(employeeName, EMPLOYEE_NAME,
                        "The data doesn't match in the 'employee name' field"),
                () -> assertEquals(userName, USER_NAME,
                        "The data doesn't match in the 'user name' field"),
                () -> assertEquals(status, STATUS,
                        "The data doesn't match in the 'status' field")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Deleting user")
    @Test
    @Order(5)
    public void deleteUserTest() {
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .enterNameOfUserForSearchCreated(USER_NAME)
                .clickSearchButton()
                .clickDeleteUser()
                .enterNameOfUserForSearchCreated(USER_NAME)
                .clickSearchButton();

        Assertions.assertTrue(viewSystemUsersPage.getSearchResult().isDisplayed(),
                "The user wasn't deleted");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Adding empty user")
    @Test
    @Order(6)
    public void addEmptyUserTest() {
        SaveSystemUserPage saveSystemUserPage = new SaveSystemUserPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .clickAddUser()
                .clickSave();

        Assertions.assertAll("Error checking",
                () -> assertTrue(saveSystemUserPage.getErrorForEmployeeName().isDisplayed(),
                        "The error didn't happen in the 'employee name' field"),
                () -> assertTrue(saveSystemUserPage.getErrorForUserName().isDisplayed(),
                        "The error didn't happen in the 'user name' field"),
                () -> assertTrue(saveSystemUserPage.getErrorForPassword().isDisplayed(),
                        "The error didn't happen in the 'password' field"),
                () -> assertNotEquals(getWebDriver().getCurrentUrl(), USERS_URL, "The user has been saved")
        );
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Adding incorrect user")
    @Test
    @Order(7)
    public void addIncorrectUserTest() {
        SaveSystemUserPage saveSystemUserPage = new SaveSystemUserPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickUsersButton()
                .clickAddUser()
                .enterUserData(INCORRECT_USER)
                .clickSave();

        Assertions.assertAll("Error checking",
                () -> assertTrue(saveSystemUserPage.getErrorForEmployeeName().isDisplayed(),
                        "The error didn't happen in the 'employee name' field"),
                () -> assertTrue(saveSystemUserPage.getErrorForUserName().isDisplayed(),
                        "The error didn't happen in the 'user name' field"),
                () -> assertTrue(saveSystemUserPage.getErrorForPassword().isDisplayed(),
                        "The error didn't happen in the 'password' field"),
                () -> assertTrue(saveSystemUserPage.getErrorForConfirmPassword().isDisplayed(),
                        "The error didn't happen in the 'confirm password' field"),
                () -> assertNotEquals(getWebDriver().getCurrentUrl(), USERS_URL, "The user has been saved")
        );
    }

    public static Object[] jobTitle() {
        return new Object[]{WORK, RUN, SPRINT};
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding job title")
    @ParameterizedTest
    @MethodSource("jobTitle")
    @Order(8)
    public void addJobTitleTest(String job) {
        SaveJobTitleUserPage saveJobTitleUserPage = new SaveJobTitleUserPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickJobTitle()
                .clickAddJob()
                .enterJobFields(job, new File(PICTURE))
                .searchAddedJob(job);

        Assertions.assertAll("Verifying the correctness of the data",
                () -> assertEquals(saveJobTitleUserPage.getJobTitleCreated().getAttribute("value"), job,
                        "The data didn't match in the 'job title' field"),
                () -> assertEquals(saveJobTitleUserPage.getJobDescriptionCreated().getText(), job,
                        "The data didn't match in the 'job description' field"),
                () -> assertEquals(saveJobTitleUserPage.getJobSpecificationCreated().getText(), PICTURE_NAME,
                        "The data didn't match in the 'job specification' field"),
                () -> assertEquals(saveJobTitleUserPage.getNoteCreated().getText(), job,
                        "The data didn't match in the 'note' field")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Deleting job")
    @ParameterizedTest
    @MethodSource("jobTitle")
    @Order(9)
    public void deleteJobTest(String job) {
        ViewJobTitleListPage viewJobTitleListPage = new ViewJobTitleListPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickJobTitle()
                .deleteJob(job);

        Assertions.assertFalse(viewJobTitleListPage.searchDeleteJob(job),
                "The deletion didn't happen");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Adding empty job")
    @Test
    @Order(10)
    public void addEmptyJobTest() {
        SaveJobTitlePage saveJobTitlePage = new SaveJobTitlePage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickJobTitle()
                .clickAddJob()
                .clickSaveButton();

        Assertions.assertTrue(saveJobTitlePage.getErrorSave().isDisplayed(),
                "The addition has happened");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding candidates")
    @Test
    @Order(11)
    public void addCandidatesTest() {
        AddCandidateCreatedPage addCandidateCreatedPage = new AddCandidateCreatedPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickCandidates()
                .clickAddCandidates()
                .enterCandidateData(NAME_CANDIDATE, EMAIL_CANDIDATE, new File(TEXT), CONTACT_CANDIDATE);

        Assertions.assertAll("Checking the data",
                () -> assertEquals(addCandidateCreatedPage.getFirstName().getAttribute(VALUE), NAME_CANDIDATE,
                        "The data didn't fit in the 'first name' field"),
                () -> assertEquals(addCandidateCreatedPage.getLastName().getAttribute(VALUE), NAME_CANDIDATE,
                        "The data didn't fit in the 'last name' field"),
                () -> assertEquals(addCandidateCreatedPage.getEmail().getAttribute(VALUE), EMAIL_CANDIDATE,
                        "The data didn't fit in the 'email' field"),
                () -> assertTrue(addCandidateCreatedPage.getResultAddingCandidate().isDisplayed(),
                        "Candidate not added")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete candidate")
    @Test
    @Order(12)
    public void deleteCandidateTest() {
        ViewCandidatesPage viewCandidatesPage = new ViewCandidatesPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickCandidates()
                .searchCandidate(NAME_CANDIDATE_FOR_SEARCH)
                .deleteCandidate(NAME_CANDIDATE_FOR_SEARCH);

        Assertions.assertFalse(viewCandidatesPage.searchDeleteCandidate(NAME_CANDIDATE_FOR_SEARCH));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Adding empty candidate")
    @Test
    @Order(13)
    public void addEmptyCandidateTest() {
        AddCandidatePage addCandidatePage = new AddCandidatePage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickCandidates()
                .clickAddCandidates()
                .clickSave();

        Assertions.assertAll("Error checking",
                () -> assertTrue(addCandidatePage.getErrorFirstName().isDisplayed(),
                        "The error didn't happen in the 'first name' field"),
                () -> assertTrue(addCandidatePage.getErrorLastName().isDisplayed(),
                        "The error didn't happen in the 'last name' field"),
                () -> assertTrue(addCandidatePage.getErrorEmail().isDisplayed(),
                        "The error didn't happen in the 'email' field")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking form assign leave")
    @Test
    @Order(14)
    public void assignLeaveCheckingFormTest() {
        AssignLeavePage assignLeavePage = new AssignLeavePage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickAssignLeave();

        Assertions.assertAll("Checking the form",
                () -> assertTrue(assignLeavePage.getEmployeeName().exists(),
                        "The 'employee name' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getLeaveType().exists(),
                        "The 'leave type' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getLeaveBalance().exists(),
                        "The 'leave balance' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getFromDate().exists(),
                        "The 'from date' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getToDate().exists(),
                        "The 'to date' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getComment().exists(),
                        "The 'comment' field doesn't exist"),
                () -> assertTrue(assignLeavePage.getAssignButton().isDisplayed(),
                        "The 'assign button' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getEmployeeNameLabel().isDisplayed(),
                        "The 'employee name' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getLeaveTypeLabel().isDisplayed(),
                        "The 'leave type' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getLeaveBalanceLabel().isDisplayed(),
                        "The 'leave balance' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getFromDateLabel().isDisplayed(),
                        "The 'from date' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getToDateLabel().isDisplayed(),
                        "The 'to date' field isn't displayed"),
                () -> assertTrue(assignLeavePage.getCommentLabel().isDisplayed(),
                        "The 'comment' field isn't displayed")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking assign leave")
    @Test
    @Order(15)
    public void assignLeaveTest() {
        AssignLeavePage assignLeavePage = new AssignLeavePage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickAssignLeave()
                .enterAssignLeaveData(EMPLOYEE_NAME_FOR_ASSIGN_LEAVE, DATE_FOR_ASSIGN_LEAVE);
        double balance = assignLeavePage.getBalanceAssign();
        assignLeavePage.clickAssignButton();
        double currentBalance = assignLeavePage.getBalanceAssign();

        Assertions.assertTrue(balance != currentBalance, "Assign leave failed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking dashboard")
    @Test
    @Order(16)
    public void dashboardTest() {
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickDashboard();

        Assertions.assertAll("Checking the elements",
                () -> assertTrue(dashboardPage.getAssignLeave().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getLeaveList().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getTimeSheets().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getApplyLeave().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getMyLeave().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getMyTimesheet().isImage(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getEmployeeDistribution().isDisplayed(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getLegend().isDisplayed(),
                        "The element wasn't found"),
                () -> assertTrue(dashboardPage.getPendingLeave().isDisplayed(),
                        "The element wasn't found")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking PIM")
    @Test
    @Order(17)
    public void PimTest() {
        ViewEmployeeFromSearchPage viewEmployeeFromSearchPage = new ViewEmployeeFromSearchPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickEmployeeList()
                .clickSearchSales()
                .clickSalesEmployee();

        Assertions.assertAll("Checking fields",
                () -> assertFalse(Objects.requireNonNull(viewEmployeeFromSearchPage.getFirstName().getAttribute("value")).isEmpty(),
                        "The 'first name' field is empty"),
                () -> assertFalse(Objects.requireNonNull(viewEmployeeFromSearchPage.getLastName().getAttribute("value")).isEmpty(),
                        "The 'last name' field is empty"),
                () -> assertTrue(viewEmployeeFromSearchPage.getMiddleName().isDisplayed(),
                        "The 'middle name' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getEmployeeId().isDisplayed(),
                        "The 'employee id' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getOtherId().isDisplayed(),
                        "The 'other id' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getLicenceNumber().isDisplayed(),
                        "The 'licence number' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getLicenceExpire().isDisplayed(),
                        "The 'licence expire' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getSsnNumber().isDisplayed(),
                        "The 'ssn number' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getSinNumber().isDisplayed(),
                        "The 'sin number' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getMale().isDisplayed(),
                        "The 'male' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getFemale().isDisplayed(),
                        "The 'female' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getMaritalStatus().isDisplayed(),
                        "The 'marital status' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getNationality().isDisplayed(),
                        "The 'nationality' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getDateOfBirth().isDisplayed(),
                        "The 'date of birth' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getNickName().isDisplayed(),
                        "The 'nick name' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getMilitaryService().isDisplayed(),
                        "The 'military service' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getSmoker().isDisplayed(),
                        "The 'smoker' field isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getEditButton().isDisplayed(),
                        "The 'edit' button isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getEditCustomButton().isDisplayed(),
                        "The 'edit custom' button isn't displayed"),
                () -> assertTrue(viewEmployeeFromSearchPage.getAddButton().isDisplayed(),
                        "The 'add' button isn't displayed")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking my info")
    @Test
    @Order(18)
    public void myInfoTest() {
        ViewMyDetailsPage viewMyDetailsPage = new ViewMyDetailsPage();
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickMyInfo();

        Assertions.assertAll("Checking fields",
                () -> assertFalse(Objects.requireNonNull(viewMyDetailsPage.getFirstName().getAttribute("value")).isEmpty(),
                        "The 'first name' field is empty"),
                () -> assertFalse(Objects.requireNonNull(viewMyDetailsPage.getLastName().getAttribute("value")).isEmpty(),
                        "The 'last name' field is empty"),
                () -> assertTrue(viewMyDetailsPage.getMiddleName().isDisplayed(),
                        "The 'middle name' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getEmployeeId().isDisplayed(),
                        "The 'employee id' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getOtherId().isDisplayed(),
                        "The 'other id' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getLicenceNumber().isDisplayed(),
                        "The 'licence number' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getLicenceExpire().isDisplayed(),
                        "The 'licence expire' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getSsnNumber().isDisplayed(),
                        "The 'ssn number' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getSinNumber().isDisplayed(),
                        "The 'sin number' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getMale().isDisplayed(),
                        "The 'male' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getFemale().isDisplayed(),
                        "The 'female' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getMaritalStatus().isDisplayed(),
                        "The 'marital status' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getNationality().isDisplayed(),
                        "The 'nationality' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getDateOfBirth().isDisplayed(),
                        "The 'date of birth' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getNickName().isDisplayed(),
                        "The 'nick name' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getMilitaryService().isDisplayed(),
                        "The 'military service' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getSmoker().isDisplayed(),
                        "The 'smoker' field isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getEditButton().isDisplayed(),
                        "The 'edit' button isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getEditCustomButton().isDisplayed(),
                        "The 'edit custom' button isn't displayed"),
                () -> assertTrue(viewMyDetailsPage.getAddButton().isDisplayed(),
                        "The 'add' button isn't displayed")
        );
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Checking main page")
    @Test
    @Order(19)
    public void OrangeTest() {
        loginPage.loginToTheSite("login", "password");

        Assertions.assertAll("Checking button",
                () -> assertTrue(orangeHRMLivePage.isDisplayedMarketplace(),
                        "The button 'marketplace' isn't displayed"),
                () -> assertTrue(orangeHRMLivePage.isDisplayedSubscribe(),
                        "The button 'subscribe' isn't displayed")
        );
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking logout")
    @Test
    @Order(20)
    public void LogoutTest() {
        loginPage.loginToTheSite("login", "password");
        orangeHRMLivePage.clickLogout();

        Assertions.assertEquals(URL, getWebDriver().getCurrentUrl(), "The logout didn't happen");
    }
}
