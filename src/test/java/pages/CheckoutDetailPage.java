package pages;

import com.microsoft.playwright.Page;

public class CheckoutDetailPage {
  private final Page page;
  private final String firstNameField = "input[id='first-name']";
  private final String lastNameField = "input[id='last-name']";
  private final String continueButton = "input[id='continue']";
  private final String cancelButton = "button[id='cancel']";
  private final String errorMessage = "button[data-test='error-button']";
  private final String checkoutbutton = "button[id='checkout']";

  private final  String zipCode = "input[id='postal-code']";

  public CheckoutDetailPage(Page page) {
    this.page = page;
  }

  public void enterFirstName(String firstname) {
    page.fill(firstNameField, firstname);
  }

  public void enterLastName(String lastname) {
    page.fill(lastNameField, lastname);
  }

  public void clickContinueButton() {
    page.click(continueButton);
  }

  public void clickCancelButton() {
    page.click(cancelButton);
  }

  public void clickCheckout(){
    page.click(checkoutbutton);

  }

  public void enterZipCode(String zipcode){
    page.fill(zipCode, zipcode);
  }

  public void assertErrorMessage() {
    page.querySelector(errorMessage).isVisible();
  }
}