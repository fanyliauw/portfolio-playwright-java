package pages;

import com.microsoft.playwright.Page;

public class InventoryPage {
  private final Page page;

  private final String inventoryContainer = ".inventory_list";


  public InventoryPage(Page page) {
    this.page = page;
  }

  public boolean isInventoryPageDisplayed(){
    return page.isVisible(inventoryContainer);
  }
}
