package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AddCandidateCreatedPage {
    private final SelenideElement firstName = $x("//input[@id='addCandidate_firstName']");
    private final SelenideElement lastName = $x("//input[@id='addCandidate_lastName']");
    private final SelenideElement email = $x("//input[@id='addCandidate_email']");
    private final SelenideElement resultAddingCandidate = $x("//div[@id='search-results']");

    public SelenideElement getResultAddingCandidate() {
        return resultAddingCandidate;
    }

    public SelenideElement getFirstName() {
        return firstName;
    }

    public SelenideElement getLastName() {
        return lastName;
    }

    public SelenideElement getEmail() {
        return email;
    }
}
