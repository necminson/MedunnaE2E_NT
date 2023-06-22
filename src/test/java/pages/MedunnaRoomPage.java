package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MedunnaRoomPage {
    public MedunnaRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(id = "jh-create-entity")
  public WebElement createNewRoomLink;
  @FindBy(name = "roomNumber")
  public WebElement roomNumber;
  @FindBy(id = "room-roomType")
  public WebElement roomTypeDropdown;
  @FindBy(id = "room-status")
  public WebElement roomStatusCheckBox;
  @FindBy(id = "room-price")
  public WebElement roomPrice;
  @FindBy(id = "room-description")
  public WebElement roomDescription;
  @FindBy(id = "save-entity")
  public WebElement saveButton;
  @FindBy(xpath = "//div[@role='alert']")
  public WebElement alert;





}
