package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class AccountTransferToYourBank {
	AndroidLogs androidLogs = new AndroidLogs();
	static AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions scroll = new ScrollOptions();
	AppStringsAndroid androidText = new AppStringsAndroid();

	public AccountTransferToYourBank accountTransferToYourBank() throws Exception {
		
		Thread.sleep(3000);
		WebElement TransferFromSelectContract = elements.TransferFromSelectContract();
		Thread.sleep(3000);
		if (TransferFromSelectContract.isEnabled()) {
			TransferFromSelectContract.click();
			androidLogs.CapturedLogs(androidText.PASS, "Select contract clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Contract not found.");
		}
		
		Thread.sleep(3000);
		WebElement TransferNextButton = elements.TransferNextButton();
		Thread.sleep(3000);
		if (TransferNextButton != null && TransferNextButton.isEnabled()) {
			TransferNextButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
		}
		
		Thread.sleep(3000);
		WebElement TransferSelectBankAccount = elements.TransferSelectBankAccount();
		Thread.sleep(3000);
		if (TransferSelectBankAccount != null && TransferSelectBankAccount.isEnabled()) {
			TransferSelectBankAccount.click();
			androidLogs.CapturedLogs(androidText.PASS, "Bank account clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Bank account not found.");
		}

		WebElement TransferNextButton1 = elements.TransferNextButton();
		Thread.sleep(3000);
		if (TransferNextButton1 != null && TransferNextButton.isEnabled()) {
			Thread.sleep(3000);
			TransferNextButton1.click();
			androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
		}
		
		WebElement TransferNextButton2 = elements.TransferNextButton();
		Thread.sleep(3000);
		if (TransferNextButton2 != null && TransferNextButton.isEnabled()) {
			TransferNextButton2.click();
			androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
		}
		
		Thread.sleep(3000);
		WebElement TransferEnterAmountTextBox = elements.TransferEnterAmountTextBox();
		Thread.sleep(3000);
		if (TransferEnterAmountTextBox != null && TransferEnterAmountTextBox.isEnabled()) {
			TransferEnterAmountTextBox.sendKeys("1.00");
			androidLogs.CapturedLogs(androidText.PASS, "Amount entered");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Transfer to your bank amount text box not found.");
		}
		
		WebElement TransferNextButton3 = elements.TransferNextButton();
		Thread.sleep(3000);
		if (TransferNextButton3 != null && TransferNextButton.isEnabled()) {
			TransferNextButton3.click();
			androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
		}
		
		
		WebElement TransferSubmitButton = elements.TransferSubmitButton();
		Thread.sleep(3000);
		if (TransferSubmitButton != null && TransferSubmitButton.isEnabled()) {
			TransferSubmitButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Submit button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Submit button not found.");
		}
		
		Thread.sleep(3000);
		WebElement TransferDoneButton = elements.TransferDoneButton();
		Thread.sleep(3000);
		if (TransferDoneButton != null && TransferDoneButton.isEnabled()) {
			TransferDoneButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Done button clicked.");
		}else {
			androidLogs.CapturedLogs(androidText.FAIL, "Done button not found.");
		}

		// to delete a pending payment
		Thread.sleep(3000);
		WebElement TransferToYourBankDeleteTransfer = elements.TransferToYourBankDeleteTransfer();
		Thread.sleep(3000);
		if (TransferToYourBankDeleteTransfer != null && TransferToYourBankDeleteTransfer.isEnabled()) {
			Thread.sleep(3000);
			TransferToYourBankDeleteTransfer.click();
			
			Thread.sleep(3000);
			WebElement TransferFromSelectContract2 = elements.TransferFromSelectContract();
			Thread.sleep(3000);
			if (TransferFromSelectContract2.isEnabled()) {
				TransferFromSelectContract2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Select contract clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Contract not found.");
			}
			
			Thread.sleep(3000);
			if (TransferNextButton != null && TransferNextButton.isEnabled()) {
				TransferNextButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
			}
			
			Thread.sleep(3000);
			WebElement TransferSelectBankAccount2 = elements.TransferFromSelectContract();
			Thread.sleep(3000);
			if (TransferSelectBankAccount2 != null && TransferSelectBankAccount2.isEnabled()) {
				TransferSelectBankAccount2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Bank account clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Bank account not found.");
			}
			
			Thread.sleep(3000);
			if (TransferNextButton != null && TransferNextButton.isEnabled()) {
				TransferNextButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Next button not found.");
			}
			
			Thread.sleep(3000);
			WebElement PendingTransfer = elements.PendingTransfer();
			Thread.sleep(3000);
			if (PendingTransfer.isEnabled()) {
				PendingTransfer.click();
				androidLogs.CapturedLogs(androidText.PASS, "Pending Transfer opened");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Pending transfer not found.");
			}
			
			Thread.sleep(3000);
			WebElement CancelTransferButton = elements.CancelTransferButton();
			Thread.sleep(3000);
			if (CancelTransferButton != null && CancelTransferButton.isEnabled()) {
				CancelTransferButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cancel transfer button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Cancel Transfer button not found.");
			}

			Thread.sleep(3000);
			WebElement BackModalButton = elements.BackModalButton();
			Thread.sleep(3000);
			if (BackModalButton != null && BackModalButton.isEnabled()) {
				BackModalButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Back modal button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Back modal button not found.");
			}
			
			Thread.sleep(3000);
			WebElement CancelTransferButton2 = elements.CancelTransferButton();
			Thread.sleep(3000);
			if (CancelTransferButton2 != null && CancelTransferButton2.isEnabled()) {
				CancelTransferButton2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cancel transfer button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Cancel transfer button not found.");
			}
			
			Thread.sleep(3000);			
			WebElement CancelModalButton = elements.CancelModalButton();
			Thread.sleep(3000);
			if (CancelModalButton != null && CancelModalButton.isEnabled()) {
				CancelModalButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cancel modal button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Cancel modal button not found.");
			}
			
			Thread.sleep(3000);
			WebElement CancelPendingPaymentXButton = elements.CancelPendingPaymentXButton();
			Thread.sleep(3000);
			if (CancelPendingPaymentXButton.isEnabled()) {
				CancelPendingPaymentXButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Pending Transfer X button clicked");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Pending transfer X button not found.");
			}
			
			Thread.sleep(3000);
			WebElement CancelModalButtonX = elements.CancelModalButtonX();
			Thread.sleep(3000);
			if (CancelModalButtonX != null && CancelModalButtonX.isEnabled()) {
				CancelModalButtonX.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cancel modal X button clicked.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Cancel modal X button not found.");
			}
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Transfer to your bank not found.");
		}
		return this;
	}
}
