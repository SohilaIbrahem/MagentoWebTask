package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P01_CreateNewAccount;
import utilities.utlity;

import static stepDefinition.Hooks.driver;

public class D01_CreateNewAccount {

    private static String FIRST_NAME;
    private static String LAST_NAME;
    public static String EMAIL;
    public static String PASSWORD;

    @Given("User open website and Click on create new account")
    public void clickCreateNewAccount() {
        new P01_CreateNewAccount(driver).UserClickOnCreateNewAccount();
    }

    @When("Enter All required fields and click on Create Account")
    public void enterAllRequiredFieldsAndClickOnCreateAccount() {
        FIRST_NAME= utlity.getExcelData(1,0,"Sheet1");
        LAST_NAME= utlity.getExcelData(1,1,"Sheet1");
        EMAIL= utlity.getExcelData(1,2,"Sheet1");
        PASSWORD= utlity.getExcelData(1,3,"Sheet1");
        new P01_CreateNewAccount(driver).UserEnterFirstName(FIRST_NAME)
                .UserEnterLastName(LAST_NAME)
                .UserEnterEmail(EMAIL)
                .UserEnterPassword(PASSWORD)
                .UserEnterConfirmationPassword(PASSWORD)
                .UserClickOnCreateAnAccountButton();
    }

    @Then("Account created successfully")
    public void accountCreatedSuccessfully() {
        Assert.assertTrue(new P01_CreateNewAccount(driver).RegisterAssertion());
        utlity.captureScreenshot(driver, "Create Account Screenshot");

    }
}
