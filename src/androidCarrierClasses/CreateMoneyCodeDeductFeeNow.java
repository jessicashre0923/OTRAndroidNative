package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class CreateMoneyCodeDeductFeeNow {
	AndroidLogs androidLogs = new AndroidLogs();
	ScrollOptions pull = new ScrollOptions();
	TextBoxXpaths appText = new TextBoxXpaths();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	public String refNumberCollected = "";

	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;

	public CreateMoneyCodeDeductFeeNow createMoneyCode() throws Exception {
		androidLogs.setupTest("MoneyCode Deduct Fee");
		Thread.sleep(3000);
		Thread.sleep(2000); 
		WebElement NewMoneyCodeButton = elements.NewMoneyCodeButton();
		Thread.sleep(3000);
		if (NewMoneyCodeButton != null && NewMoneyCodeButton.isEnabled()) {
			NewMoneyCodeButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Issue Moneycode Button clicked.");

			Thread.sleep(2000); 
			WebElement SelectContract = elements.SelectContract();
			Thread.sleep(3000);
			if (SelectContract != null && SelectContract.isEnabled()) {
				SelectContract.click();
				androidLogs.CapturedLogs(androidText.PASS, "Contract Selected");
			} else {
				androidLogs.CapturedLogs(androidText.INFO, "Contract not found or is not required in this account");
			}
			
			Thread.sleep(2000); 
			elements.PayeeNameTextBox().sendKeys("Android Mobile Automation");
			androidLogs.CapturedLogs(androidText.PASS, "Payee Name textbox filled in");
			
			Thread.sleep(2000); 
			WebElement NextButtonMoneyCode = elements.NextButtonMoneyCode();
			Thread.sleep(3000);
			if (NextButtonMoneyCode != null && NextButtonMoneyCode.isEnabled()) {
				NextButtonMoneyCode.click();
				androidLogs.CapturedLogs(androidText.PASS, "Next Button clicked");

			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Next Button not found");
			}

			Thread.sleep(2000); 
			elements.AmountMoneyCodeTextBox().sendKeys("9.99");
			androidLogs.CapturedLogs(androidText.PASS, "Amount text box filled in");

			Thread.sleep(2000); 
			WebElement AmountNextMoneyCode = elements.AmountNextMoneyCode();
			Thread.sleep(3000);
			if (AmountNextMoneyCode != null && AmountNextMoneyCode.isEnabled()) {
				AmountNextMoneyCode.click();
				androidLogs.CapturedLogs(androidText.PASS, "Next Button clicked");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Next Button not found");
			}

//			Thread.sleep(3000);
//			WebElement InfoFieldsDriverIDCheckBox = elements.InfoFieldsDriverIDCheckBox();
//			if (InfoFieldsDriverIDCheckBox != null && InfoFieldsDriverIDCheckBox.isEnabled()) {
//				Thread.sleep(3000);
//				InfoFieldsDriverIDCheckBox.click();
//				androidLogs.CapturedLogs(androidText.PASS, "Driver ID check box clicked");
//			} else {
//				androidLogs.CapturedLogs(androidText.FAIL, "Driver ID check box not found");
//			}

			WebElement AddFieldsNextButtonMoneyCode = elements.AddFieldsNextButtonMoneyCode();
			Thread.sleep(3000);
			if(AddFieldsNextButtonMoneyCode!=null && AddFieldsNextButtonMoneyCode.isEnabled()) {
			AddFieldsNextButtonMoneyCode.click();
			androidLogs.CapturedLogs("Test Pass", "Add Fields Next Button MoneyCode found and clicked");}

//			Thread.sleep(2000);
//			WebElement Add1FieldsButton = elements.Add1FieldsButton();
//			if (Add1FieldsButton != null && Add1FieldsButton.isEnabled()) {
//				Add1FieldsButton.click();
//				androidLogs.CapturedLogs(androidText.PASS, "Add Fields Next Button MoneyCode found and clicked");
//			} else {
//				androidLogs.CapturedLogs(androidText.FAIL, "Add Fields Next Button not found");
//			}
//			
//			Thread.sleep(2000);
//			WebElement InfoFieldsDriverTextBox = elements.InfoFieldsDriverTextBox();
//			if (InfoFieldsDriverTextBox != null && InfoFieldsDriverTextBox.isEnabled()) {
//			InfoFieldsDriverTextBox.sendKeys("Automation Driver ID");
//			androidLogs.CapturedLogs(androidText.PASS, "Info fields driver Deduct fee text filled in");
//			}else {
//			androidLogs.CapturedLogs(androidText.FAIL, "Info fields driver Deduct fee text Not found");
//			}
//			
//			
			Thread.sleep(2000);
			WebElement InfoDetailsNotesDeductFeeTextBox = elements.InfoDetailsNotesDeductFeeTextBox();
			Thread.sleep(3000);
			if (InfoDetailsNotesDeductFeeTextBox != null && InfoDetailsNotesDeductFeeTextBox.isEnabled()) {
				InfoDetailsNotesDeductFeeTextBox.sendKeys("Android Mobile Automation");
			androidLogs.CapturedLogs(androidText.PASS, "Info Details Notes TextBox filled in");
			}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Info Details Notes TextBox Not found");
			}
						
			Thread.sleep(2000);
			WebElement InfoNextButtonMoneyCode = elements.InfoNextButtonMoneyCode();
			Thread.sleep(3000);
			if (InfoNextButtonMoneyCode != null && InfoNextButtonMoneyCode.isEnabled()) {
				InfoNextButtonMoneyCode.click();
				androidLogs.CapturedLogs(androidText.PASS, "Info Next Button MoneyCode clicked.");
			}else {
				androidLogs.CapturedLogs(androidText.FAIL, "Info Next button not found");
			}

// TODO add some more options to clikc on money code page prior to issue. 
//			 Thread.sleep(2000);
//			 elements.EditFeeIcon().click();
			Thread.sleep(3000);
			WebElement DeductFeeNowRadioButton = elements.DeductFeeNowRadioButton();
			Thread.sleep(3000);
			if (DeductFeeNowRadioButton != null && DeductFeeNowRadioButton.isEnabled()) {
				DeductFeeNowRadioButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Deduct fee now radio button clicked.");
			}else {
				androidLogs.CapturedLogs(androidText.INFO, "Deduct fee now radio button not found");
			}

			Thread.sleep(3000);
			pull.ScrollDown();

			Thread.sleep(3000);
			WebElement IssueMoneyCodeButton = elements.IssueMoneyCodeButton();
			Thread.sleep(3000);
			if (IssueMoneyCodeButton != null && IssueMoneyCodeButton.isEnabled()) {
				IssueMoneyCodeButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Issue MoneyCode Button clicked");
			}else {
				androidLogs.CapturedLogs(androidText.INFO, "Issue MoneyCode button not found");
			}

			Thread.sleep(2000);
			refNumberCollected = elements.ReferenceNumber().getText();
			androidLogs.CapturedLogs(androidText.INFO, "Reference number stored as: " + refNumberCollected);

			// Send to Payee code added
			Thread.sleep(2000);
			WebElement SendToPayeeButton = elements.SendToPayeeButton();
			Thread.sleep(3000);
			if (SendToPayeeButton != null && SendToPayeeButton.isEnabled()) {
				SendToPayeeButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "SendToPayee Button clicked");
			}else {
				androidLogs.CapturedLogs(androidText.FAIL, "Send to Payee button not found");
			}

			Capabilities.driver.navigate().back();
			Thread.sleep(2000);
			WebElement DismissMoneyCodeButtoniOS = elements.DismissMoneyCodeButton();
			Thread.sleep(3000);
			if (DismissMoneyCodeButtoniOS != null && DismissMoneyCodeButtoniOS.isEnabled()) {
				DismissMoneyCodeButtoniOS.click();
				androidLogs.CapturedLogs(androidText.PASS, "Dismiss MoneyCode Button clicked");
			}else {
				androidLogs.CapturedLogs(androidText.INFO, "Dismiss MoneyCode button not found");
			}

//			elements.DismissMoneyCodeModalButton().click();
		//	androidLogs.CapturedLogs(androidText.PASS, "Dismiss MoneyCode Modal Button clicked");
			androidLogs.CapturedLogs(androidText.INFO, "A new moneycode was created.");
			Thread.sleep(2000);
			String trimRefNumber = "**" + refNumberCollected.substring(refNumberCollected.length()-5);
			System.out.println("Trimmed ref number = : " + trimRefNumber);
			WebElement OpenCreatedMoneyCode = elements.OpenCreatedMoneyCode(trimRefNumber);
			Thread.sleep(2000);
			if (OpenCreatedMoneyCode.isEnabled()) {
				OpenCreatedMoneyCode.click();
				androidLogs.CapturedLogs(androidText.PASS, "Open last created money code");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Couldnt open last created money code");
			}
			
			Thread.sleep(2000);
			WebElement CreatedMoneyCodeRefNumber = elements.CreatedMoneyCodeRefNumber();
			Thread.sleep(3000);
			if (CreatedMoneyCodeRefNumber.getText().equals(refNumberCollected)) {

				androidLogs.CapturedLogs(androidText.PASS, "reference numbers match the one being voided as: "+ CreatedMoneyCodeRefNumber.getText());
				
				Thread.sleep(2000);
				WebElement verifyMoneyCodesActiveIcon = elements.verifyMoneyCodesActiveIcon();
				Thread.sleep(3000);
				if (verifyMoneyCodesActiveIcon.isDisplayed()) {
					androidLogs.CapturedLogs(androidText.PASS, "moneyCode Active details displayed");

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "moneyCode Active details not displayed");
				}
				
				Thread.sleep(2000);
				WebElement VoidMoneyCodeButton = elements.VoidMoneyCodeButton();
				Thread.sleep(3000);
				if (VoidMoneyCodeButton != null && VoidMoneyCodeButton.isEnabled()) {
					VoidMoneyCodeButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Void money code button clicked");
					
					Thread.sleep(2000);
					WebElement VoidMoneyModalCancelButton = elements.VoidMoneyModalCancelButton();
					Thread.sleep(3000);
					if (VoidMoneyModalCancelButton != null && VoidMoneyModalCancelButton.isEnabled()) {
						VoidMoneyModalCancelButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Void money code modal cancel button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Void money code modal cancel button not found");
					}

					elements.VoidMoneyCodeButton().click();
					androidLogs.CapturedLogs(androidText.PASS, "Void money code button clicked");
					
					Thread.sleep(2000);
					WebElement VoidMoneyModalVoidButton = elements.VoidMoneyModalVoidButton();
					Thread.sleep(3000);
					if (VoidMoneyModalVoidButton != null && VoidMoneyModalVoidButton.isEnabled()) {
						VoidMoneyModalVoidButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Void money code Void button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Void money code void button not found");
					}

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Void money code button not found");
				}
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Reference numbers do not match Money Code");
			}
			
			Thread.sleep(2000);
			WebElement verifyMoneyCodesVoidedIcon = elements.verifyMoneyCodesVoidedIcon();
			Thread.sleep(3000);
			if (verifyMoneyCodesVoidedIcon.isDisplayed()) {
				androidLogs.CapturedLogs(androidText.PASS, "moneyCode void details displayed");

			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "moneyCode void details not displayed");
			}
			
			Thread.sleep(2000);
			WebElement MoneyCodesVoidBackbutton = elements.MoneyCodesVoidBackbutton();
			Thread.sleep(3000);
			if (MoneyCodesVoidBackbutton.isEnabled()) {
				MoneyCodesVoidBackbutton.click();
				androidLogs.CapturedLogs(androidText.PASS, "moneyCode Back Button clicked");

			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "moneyCode Back Button not found");
			}

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "New MoneyCode Button was not found.");
		}

		return this;
	}
}
