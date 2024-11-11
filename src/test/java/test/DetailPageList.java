package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class DetailPageList {
  private Playwright playwright;
  private Browser browser;
  private Page page;
  private LoginPage loginPage;
  private InventoryPage inventoryPage;
  private DetailPage detailPage;
  private FilterPage filterPage;
  private CartPage cartPage;

  private CheckoutDetailPage checkoutDetailPage;

  @BeforeMethod
  public void setup() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();
    loginPage = new LoginPage(page);
    inventoryPage = new InventoryPage(page);
    detailPage = new DetailPage(page);
    filterPage = new FilterPage(page);
    cartPage = new CartPage(page);
    checkoutDetailPage = new CheckoutDetailPage(page);

    page.navigate("https://www.saucedemo.com/");
  }

  @Test(groups = "detail-page")
  public void detailPage() {
    this.setup();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

    Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");
    detailPage.clickDetailList();
    detailPage.detailText("Sauce Labs Backpack");
  }

//  @Test(groups = "filter")
//  public void filterList() {
//    loginPage.enterUsername("standard_user");
//    loginPage.enterPassword("secret_sauce");
//    loginPage.clickLoginButton();
//
//    Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");
//    filterPage.clickFilterDsc();
////    filterPage.validFilter();
//  }

  @Test(groups = "cart")
  public void cartDetail() {
    this.setup();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

    Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");
    cartPage.clickAddToCartButton();
    cartPage.clickKeranjang();
    cartPage.clickContinue();
    cartPage.clickRemoveButton();

  }

  @Test(groups = "checkout")
  public void checkoutDetail() {
    this.setup();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

    Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");
    cartPage.clickAddToCartButton();
    cartPage.clickKeranjang();
    checkoutDetailPage.clickCheckout();
    checkoutDetailPage.enterFirstName("John");
    checkoutDetailPage.enterLastName("Doe");
    checkoutDetailPage.enterZipCode("10000");
    checkoutDetailPage.clickContinueButton();
  }

  @AfterMethod
  public void teardown() {
    browser.close();
    playwright.close();
  }
}
