package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailPage;
import pages.InventoryPage;
import pages.LoginPage;

public class DetailPageList {
  private Playwright playwright;
  private Browser browser;
  private Page page;
  private LoginPage loginPage;
  private InventoryPage inventoryPage;
  private DetailPage detailPage;

  @BeforeMethod
  public void setup() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    page = browser.newPage();
    loginPage = new LoginPage(page);
    inventoryPage = new InventoryPage(page);
    detailPage = new DetailPage(page);

    page.navigate("https://www.saucedemo.com/");
  }

  @Test
  public void detailPage() {
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton();

    Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page should be displayed after login.");
    detailPage.clickDetailList();
    detailPage.detailText("Sauce Labs Backpack");
  }


  @AfterMethod
  public void teardown() {
    browser.close();
    playwright.close();
  }
}
