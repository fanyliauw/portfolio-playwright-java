package pages;


import com.microsoft.playwright.Page;

public class LoginPage {
  private final Page page;

  // Locator Element field username, password,and button

  private final String usernameField = "#user-name";
  private final String passwordField = "#password";
  private final String loginButton = "#login-button";
  private final String errorMessage = "button[class='error-button']";
  public LoginPage(Page page) {
    this.page = page;
  }

  // Metode untuk berinteraksi dengan element

  public void enterUsername(String username) {
    page.fill(usernameField, username);
  }

  public void enterPassword(String password) {
    page.fill(passwordField, password);
  }

  public void clickLoginButton() {
    page.click(loginButton);
  }

  public void assertErrorMessage(){
    page.querySelector(errorMessage).isVisible();
  }
  public void inputLoginForm(String username, String password){
    page.fill(usernameField, username);
    page.fill(passwordField, password);
    page.click(loginButton);
  }

}

