package pages;

import com.microsoft.playwright.Page;

public class FilterPage {
  private final Page page;

  private final String buttonFilter = "//div[@class=\"right_component\"]";
  private final String filterDsc = "//option[@value='za']";
  private final String validAsc= "//a[@id='item_3_title_link']']";



  public FilterPage(Page page) {
    this.page = page;
  }

  public void clickFilterDsc(){
//    page.click(buttonFilter);
//    page.waitForSelector(filterDsc);
    page.selectOption(filterDsc,"Name (Z to A)");
  }

  public void validFilter(){
    page.textContent(validAsc);
  }


}
