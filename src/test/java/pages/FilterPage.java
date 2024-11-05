package pages;

import com.microsoft.playwright.Page;

public class FilterPage {
  private final Page page;

  private final String filter = ".filter";

  public FilterPage(Page page) {
    this.page = page;
  }
}
