package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;


public class DetailPage {

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    private pages.DetailPage detailPage;
    private FilterPage filterPage;
    private CartPage cartPage;

    private CheckoutDetailPage checkoutDetailPage;
    @Given("User Success Login")
    public void userSuccessLogin() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        detailPage = new pages.DetailPage(page);
        filterPage = new FilterPage(page);
        cartPage = new CartPage(page);
        checkoutDetailPage = new CheckoutDetailPage(page);

        page.navigate("https://www.saucedemo.com/");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");

    }

    @When("User click product name")
    public void userClickProductName() {

        detailPage.clickDetailList();
    }

    @Then("User can see detail product")
    public void userCanSeeDetailProduct() {

        detailPage.detailText("Sauce Labs Backpack");
    }


    @When("User click add to cart button")
    public void userClickAddToCartButton() {
        cartPage.clickAddToCartButton();
    }

    @And("User click icon cart")
    public void userClickIconCart() {
        cartPage.clickKeranjang();
        detailPage.detailText("Sauce Labs Backpack");
    }

    @And("User click checkout button")
    public void userClickCheckoutButton() {
        checkoutDetailPage.clickCheckout();
    }

    @When("User fill firstname")
    public void userFillFirstname() {
        checkoutDetailPage.enterFirstName("John");
    }

    @And("User fill lastname")
    public void userFillLastname() {
        checkoutDetailPage.enterLastName("Doe");
    }

    @And("user fill zipcode")
    public void userFillZipcode() {

        checkoutDetailPage.enterZipCode("10000");
    }

    @And("User click button continue")
    public void userClickButtonContinue() {

        checkoutDetailPage.clickContinueButton();
    }

    @Then("User can see checkout overview page")
    public void userCanSeeCheckoutOverviewPage() {
        detailPage.detailText("Sauce Labs Backpack");
    }

    @And("User click continue")
    public void userClickContinue() {
        cartPage.clickContinue();
    }

    @And("User click remove button")
    public void userClickRemoveButton() {
        cartPage.clickRemoveButton();
    }

    @Then("User can't see product")
    public void userCanTSeeProduct() {
        cartPage.resultRemove();
    }
}
