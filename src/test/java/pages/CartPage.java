package pages;

import com.microsoft.playwright.Page;

public class CartPage {
  private final Page page;    //locator element
  private final String addtocartButton = "//button[@id='add-to-cart-sauce-labs-backpack']";
  private final String cartIcon = "//a[@class='shopping_cart_link']";
  private final String continueshoppingButton = "//button[@id='continue-shopping']";
  private final String removeButton = "//button[@id='remove-sauce-labs-backpack']";

  public CartPage(Page page) {
    this.page = page;
  }

  public void clickAddToCartButton() {
    page.click(addtocartButton);
  }

  public void clickKeranjang() {
    page.click(cartIcon);
  }

  public void clickContinue() {
    page.click(continueshoppingButton);
  }

  public void clickRemoveButton() {
    page.click(removeButton);
  }
}