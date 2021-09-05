package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ViewEmployeeFromSearchPage {
    private final SelenideElement firstName = $x("//input[@id='personal_txtEmpFirstName']");
    private final SelenideElement middleName = $x("//input[@id='personal_txtEmpMiddleName']");
    private final SelenideElement lastName = $x("//input[@id='personal_txtEmpLastName']");
    private final SelenideElement employeeId = $x("//input[@id='personal_txtEmployeeId']");
    private final SelenideElement otherId = $x("//input[@id='personal_txtOtherID']");
    private final SelenideElement licenceNumber = $x("//input[@id='personal_txtLicenNo']");
    private final SelenideElement licenceExpire = $x("//input[@id='personal_txtLicExpDate']");
    private final SelenideElement ssnNumber = $x("//input[@id='personal_txtNICNo']");
    private final SelenideElement sinNumber = $x("//input[@id='personal_txtSINNo']");
    private final SelenideElement male = $x("//input[@id='personal_optGender_1']");
    private final SelenideElement female = $x("//input[@id='personal_optGender_2']");
    private final SelenideElement maritalStatus = $x("//select[@id='personal_cmbMarital']");
    private final SelenideElement nationality = $x("//select[@id='personal_cmbNation']");
    private final SelenideElement dateOfBirth = $x("//input[@id='personal_DOB']");
    private final SelenideElement nickName = $x("//input[@id='personal_txtEmpNickName']");
    private final SelenideElement militaryService = $x("//input[@id='personal_txtMilitarySer']");
    private final SelenideElement smoker = $x("//input[@id='personal_chkSmokeFlag']");
    private final SelenideElement editButton = $x("//input[@id='btnSave']");
    private final SelenideElement editCustomButton = $x("//input[@id='btnEditCustom']");
    private final SelenideElement addButton = $x("//input[@id='btnAddAttachment']");

    public SelenideElement getFirstName() {
        return firstName;
    }

    public SelenideElement getMiddleName() {
        return middleName;
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getEmployeeId() {
        return employeeId;
    }

    public SelenideElement getOtherId() {
        return otherId;
    }

    public SelenideElement getLicenceNumber() {
        return licenceNumber;
    }

    public SelenideElement getLicenceExpire() {
        return licenceExpire;
    }

    public SelenideElement getSsnNumber() {
        return ssnNumber;
    }

    public SelenideElement getSinNumber() {
        return sinNumber;
    }

    public SelenideElement getMale() {
        return male;
    }

    public SelenideElement getFemale() {
        return female;
    }

    public SelenideElement getMaritalStatus() {
        return maritalStatus;
    }

    public SelenideElement getNationality() {
        return nationality;
    }

    public SelenideElement getDateOfBirth() {
        return dateOfBirth;
    }

    public SelenideElement getNickName() {
        return nickName;
    }

    public SelenideElement getMilitaryService() {
        return militaryService;
    }

    public SelenideElement getSmoker() {
        return smoker;
    }

    public SelenideElement getEditButton() {
        return editButton;
    }

    public SelenideElement getEditCustomButton() {
        return editCustomButton;
    }

    public SelenideElement getAddButton() {
        return addButton;
    }
}
