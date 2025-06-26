package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.P02_PlaceOrder;
import pages.P03_PaymentInfo;
import utilities.utlity;

import static stepDefinition.D01_CreateNewAccount.EMAIL;
import static stepDefinition.D01_CreateNewAccount.PASSWORD;
import static stepDefinition.Hooks.driver;

public class D02_PlaceOrder {

    private static String StreetName;
    private static String City;
    private static String ZIPCode;
    private static String PhoneNum;


    @Given("User Login with Valid Credientials")
    public void loginWithValidData() {
        new P02_PlaceOrder(driver).ClickSigninTap()
                .FillEmail(EMAIL)
                .FillPassword(PASSWORD)
                .ClickLoginButton();
    }

    @When("User Click on What's News")
    public void userClickOnWhatSNews() {
        new P02_PlaceOrder(driver).UserClickOnWhatNew();
    }

    @And("User Choose Product")
    public void userChooseProduct() {
        new P02_PlaceOrder(driver).UserSelectProduct();
    }

    @And("User Click at Add to Compare List")
    public void userClickAtAddToCompareList() {
        new P02_PlaceOrder(driver).UserClickCompListOption();
        utlity.captureScreenshot(driver, "ProductAddToCompareList");
    }

    @Then("Product shall added to compare list Successfully")
    public void productShallAddedToCompareListSuccessfully() {
        new P02_PlaceOrder(driver).UserClickOnAddToCart();
    }

    @And("User Click on Add Product to Card")
    public void userClickOnAddProductToCard() {
        new P02_PlaceOrder(driver).UserSelectProductSize().UserSelectProductColor()
                .UserClickAddToCartButton().UserClickOnShoppingCart();
    }

    @And("User Click Go to Card and Proceed to Checkout")
    public void userClickGoToCardAndProceedToCheckout() {
        new P03_PaymentInfo(driver).UserClickOnProccedToCheckOutButton();
    }

    @And("User Fill All Shipping Address and Payment information")
    public void userFillAllShippingAddressAndPaymentInformation() {
        // StreetName | City  | ZIP  | PhoneNum
        StreetName= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","StreetName");
        City= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","City");
        ZIPCode= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","ZIP");
        PhoneNum= utlity.getData(System.getProperty("user.dir")+"/src/test/resources/testData/paymentdata.json","PhoneNum");

        new P03_PaymentInfo(driver).UserEnterStreetAddress(StreetName).UserEnterCity(City).
                UserEnterState().UserEnterZIP(ZIPCode).UserEnterCountry()
                .UserEnterphoneNumber(PhoneNum).UserClickOnNextButton().UserClickOnPlaceOrderButton();
    }

    @Then("Verify Order Created Successfully")
    public void verifyOrderCreatedSuccessfully() {
        Assert.assertTrue(new P03_PaymentInfo(driver).PlaceOrderSuccessMessage());
        utlity.captureScreenshot(driver, "PlaceOrderSuccess");
    }
}
