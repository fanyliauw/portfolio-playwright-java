package pages;
import com.microsoft.playwright.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetailPage {
  private final Page page;
  private final String inventoryList = "//a[@id='item_4_img_link']";
  private String textDetail;



  public DetailPage(Page page) {
    this.page = page;
  }

  public void clickDetailList(){
    page.click(inventoryList);
  }
  public void detailText(String actualText){
//    assertEquals(textDetail,actualText);
    textDetail= page.textContent("//*[contains(text(),'Sauce Labs Backpack')]");
    System.out.println(textDetail);

  }
}
