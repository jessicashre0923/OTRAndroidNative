package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class AccountPage {
	
	
//TODO TRY THIS 	
//	public void openProfileButtonFromHome(LoginInfo loginInfo) throws Exception {
//	openProfileButtonFromHome(loginInfo.getAccountNum());
//}

//public AccountPage openProfileButtonFromHome(LoginInfo loginInfo) throws Exception {
	
//	this.env = environment;
//	this.cardNum = cardNumber;
//	this.passwordOrPin = passwordOrPin;
//	System.out.println("I am in login Pass environment is:" + loginInfo.getEnv());
//	openProfileButtonFromHome();
//	return this;
//}
	
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String appVersionNumber;
	
	public AccountPage openProfileButtonFromHome(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		System.out.println("I am in login Pass environment is:" + environment);
		openProfileButtonFromHome();
		
		return this;
	}
	
	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	ScrollOptions scroll = new ScrollOptions();
	AppStringsAndroid androidText = new AppStringsAndroid();
	
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
		
	public AccountPage openProfileButtonFromHome() throws Exception {
		//AppStringsAndroid androidText = new AppStringsAndroid(env);
		//androidText = new AppStringsAndroid(env);
		androidLogs.setupTest("Account Profile page Testing started.");
	
		Thread.sleep(3000);
		WebElement openProfileButtonFromHome = elements.ProfileButtonFromHome();
		Thread.sleep(3000);
		if (openProfileButtonFromHome != null && openProfileButtonFromHome.isEnabled()) {
			openProfileButtonFromHome.click();
			androidLogs.CapturedLogs(pass, "Open Profile Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(fail, "Open Profile Button is not found");
		}


		Thread.sleep(3000);
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			androidLogs.CapturedLogs(pass, "Help Screen Continue Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Continue Button is not found");
		}
		
//Verify account page is loaded with Card Holder info;
		Thread.sleep(5000);
		WebElement ProfileCardHolderInfoLoaded = elements.ProfileCardHolderInfoLoaded();
		Thread.sleep(5000);
		if (ProfileCardHolderInfoLoaded != null && ProfileCardHolderInfoLoaded.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Card holder information screen loaded");
		
		
		
		
//Change Pin account profile page (Text box of current passcode is not named....) 		
		Thread.sleep(5000);
		WebElement changePinButtonFromProfile = elements.changePinButtonFromProfile();
		Thread.sleep(5000);
		if (changePinButtonFromProfile != null && changePinButtonFromProfile.isEnabled()) {
			changePinButtonFromProfile.click();
			androidLogs.CapturedLogs(pass, "Change Pin button on profile is found and pressed.");
			
			
			Thread.sleep(3000);
			WebElement currentPinOnProfileTextBox = elements.currentPinOnProfileTextBox();
			Thread.sleep(3000);
			if (currentPinOnProfileTextBox != null && currentPinOnProfileTextBox.isEnabled()) {
				currentPinOnProfileTextBox.click();
				currentPinOnProfileTextBox.sendKeys(passwordOrPin);
				androidLogs.CapturedLogs(pass, "Original pin entered.");
			}else {
				androidLogs.CapturedLogs(fail, "Original pin not entered.");
			}
				
			
				
				Thread.sleep(3000);
				WebElement newCurrentPinOnProfileTextBox = elements.newCurrentPinOnProfileTextBox();
				Thread.sleep(3000);
				if (newCurrentPinOnProfileTextBox != null && newCurrentPinOnProfileTextBox.isEnabled()) {
					newCurrentPinOnProfileTextBox.click();
					newCurrentPinOnProfileTextBox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "New pin entered.");
				
				}else {
					androidLogs.CapturedLogs(fail, "New pin not entered.");
				}
				
				    Thread.sleep(3000);
					WebElement confirmNewcurrentPinOnProfileTextBox = elements.confirmNewcurrentPinOnProfileTextBox();
					Thread.sleep(3000);
					if (confirmNewcurrentPinOnProfileTextBox != null && confirmNewcurrentPinOnProfileTextBox.isEnabled()) {
						confirmNewcurrentPinOnProfileTextBox.click();
						confirmNewcurrentPinOnProfileTextBox.sendKeys(passwordOrPin);
						androidLogs.CapturedLogs(pass, "Confirm New pin entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New pin not entered.");
					}
					
					Thread.sleep(3000);
					WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
					Thread.sleep(3000);
					if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
						confirmNewPinSaveButton.click();
						androidLogs.CapturedLogs(pass, "Confirm New pin save Button selected");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New pin save Button not selected");
					}
				
			} else {
				androidLogs.CapturedLogs(info, "Change Pin button on profile is not found");
			}
	
		
//Change Passcode on account profile page 	
		Thread.sleep(5000);
		WebElement changePassCodeButtonFromProfile = elements.changePassCodeButtonFromProfile();
		Thread.sleep(5000);
		if (changePassCodeButtonFromProfile != null && changePassCodeButtonFromProfile.isEnabled()) {
			changePassCodeButtonFromProfile.click();
			androidLogs.CapturedLogs(pass, "Change Passcode button on profile is found and pressed.");
			
			
			Thread.sleep(3000);
			WebElement currentPasscodeOnProfileTextBox = elements.currentPasscodeOnProfileTextBox();
			Thread.sleep(3000);
			Thread.sleep(3000);
			if (currentPasscodeOnProfileTextBox != null && currentPasscodeOnProfileTextBox.isEnabled()) {
				//currentPasscodeOnProfileTextBox.click();
				currentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
				androidLogs.CapturedLogs(pass, "Original passcode entered.");
			}else {
				androidLogs.CapturedLogs(fail, "Original passcode not entered.");
			}
				
				Thread.sleep(3000);
				WebElement newCurrentPasscodeOnProfileTextBox = elements.newCurrentPasscodeOnProfileTextBox();
				Thread.sleep(3000);
				if (newCurrentPasscodeOnProfileTextBox != null && newCurrentPasscodeOnProfileTextBox.isEnabled()) {
					newCurrentPasscodeOnProfileTextBox.click();
					newCurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "New passcode entered.");
				
				}else {
					androidLogs.CapturedLogs(fail, "New passcode not entered.");
				}
				
					WebElement confirmNewcurrentPasscodeOnProfileTextBox = elements.confirmNewcurrentPasscodeOnProfileTextBox();
					Thread.sleep(3000);
					if (confirmNewcurrentPasscodeOnProfileTextBox != null && confirmNewcurrentPasscodeOnProfileTextBox.isEnabled()) {
						confirmNewcurrentPasscodeOnProfileTextBox.click();
						confirmNewcurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
						androidLogs.CapturedLogs(pass, "Confirm New passcode entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New passcode not entered.");
					}
					
					
					WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
					Thread.sleep(3000);
					if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
						confirmNewPinSaveButton.click();
						androidLogs.CapturedLogs(pass, "Confirm New passcode save Button selected");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New passcode save Button not selected");
					}
			} else {
			androidLogs.CapturedLogs(info, "Change Passcode button on profile is not found");
		}

//Edit profile from account page 
		Thread.sleep(3000);
		WebElement editCardHolderInfoButton = elements.editCardHolderInfoButton();
		Thread.sleep(3000);
		if (editCardHolderInfoButton != null && editCardHolderInfoButton.isEnabled()) {
			editCardHolderInfoButton.click();
			androidLogs.CapturedLogs(androidText.PASS, "Edit Card Holder Info found and pressed.");
			
			
			Thread.sleep(3000);
			WebElement OpenEditName = elements.OpenEditName();
			Thread.sleep(3000);
			if (OpenEditName  != null && OpenEditName.isEnabled()) {
				OpenEditName.click();
				androidLogs.CapturedLogs(pass, "Edit Name button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit Name button button was not found");
			}
			
			Thread.sleep(3000);
			WebElement EditFirstName = elements.EditFirstName();
			Thread.sleep(3000);
			if (EditFirstName  != null && EditFirstName.isEnabled()) {
				EditFirstName.click();
				EditFirstName.sendKeys(androidText.FIRST_NAME);
				androidLogs.CapturedLogs(pass, "Edit First Name textBox found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit First Name textBox was not found");
			}
			
			Thread.sleep(3000);
			WebElement EditLastName = elements.EditLastName();
			Thread.sleep(3000);
			if (EditLastName  != null && EditLastName.isEnabled()) {
				EditLastName.click();
				EditLastName.sendKeys(androidText.LAST_NAME);
				androidLogs.CapturedLogs(pass, "Edit First Name textBox found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit First Name textBox was not found");
			}
			
			Thread.sleep(3000);
			WebElement SaveName = elements.SaveName();
			Thread.sleep(3000);
			if (SaveName  != null && SaveName.isEnabled()) {
				SaveName.click();
				
				androidLogs.CapturedLogs(pass, "Save Name Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Save Name Button was not found");
			}
			
			Thread.sleep(3000);
			WebElement OpenEditEmail = elements.OpenEditEmail();
			Thread.sleep(3000);
			if (OpenEditEmail  != null && OpenEditEmail.isEnabled()) {
				OpenEditEmail.click();
				
				androidLogs.CapturedLogs(pass, "Open email button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Open email Button was not found");
			}
			
			Thread.sleep(3000);
			WebElement editEmailAddress = elements.editEmailAddress();
			Thread.sleep(3000);
			if (editEmailAddress  != null && editEmailAddress.isEnabled()) {
				editEmailAddress.click();
				editEmailAddress.sendKeys(androidText.EMAIL_ADDRESS);
				androidLogs.CapturedLogs(pass, "Edit Email Name textBox found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit Email Name textBox was not found");
			}
			
			
			Thread.sleep(3000);
			WebElement SaveEmail = elements.SaveEmail();
			Thread.sleep(3000);
			if (SaveEmail  != null && SaveEmail.isEnabled()) {
				SaveEmail.click();
				
				androidLogs.CapturedLogs(pass, "Save Email Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Save EmailName Button was not found");
			}
			
			Thread.sleep(3000);
			WebElement OpenEditMobilePhone = elements.OpenEditMobilePhone();
			Thread.sleep(3000);
			if (OpenEditMobilePhone  != null && OpenEditMobilePhone.isEnabled()) {
				OpenEditMobilePhone.click();
				
				androidLogs.CapturedLogs(pass, "Edit Mobile Phone Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit Mobile Phone Buttonwas not found");
			}
			
			
			Thread.sleep(3000);
			WebElement EditMobilePhone = elements.EditMobilePhone();
			Thread.sleep(3000);
			if (EditMobilePhone  != null && EditMobilePhone.isEnabled()) {
				EditMobilePhone.click();
				EditMobilePhone.sendKeys(androidText.PHONE_NUMBER);
				androidLogs.CapturedLogs(pass, "Edit Mobile Phone textBox found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit Mobile Phone textBox was not found");
			}
			
			Thread.sleep(3000);
			WebElement SavePhone = elements.SavePhone();
			Thread.sleep(3000);
			if (SavePhone  != null && SavePhone.isEnabled()) {
				SavePhone.click();
				
				androidLogs.CapturedLogs(pass, "Save Mobile Phone Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Save Mobile Phone Button was not found");
			}
			
			
			Thread.sleep(3000);
			WebElement OpenEditHomeAddress = elements.OpenEditHomeAddress();
			Thread.sleep(3000);
			if (OpenEditHomeAddress  != null && OpenEditHomeAddress.isEnabled()) {
				OpenEditHomeAddress.click();
				
				androidLogs.CapturedLogs(pass, "Edit Home Address Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Edit Home Address Button was not found");
			}
			
			Thread.sleep(3000);
			WebElement CloseHomeAddress = elements.CloseHomeAddress();
			Thread.sleep(3000);
			if (CloseHomeAddress  != null && CloseHomeAddress.isEnabled()) {
				CloseHomeAddress.click();
				
				androidLogs.CapturedLogs(pass, "Close Home Address Button found and selected");
				androidLogs.CapturedLogs(info, "Closing home address no update because VPN does not allow for address lookup");
			} else {
				androidLogs.CapturedLogs(info, "Close Home Address Button was not found");
			}
			
			
			Thread.sleep(3000);
			WebElement closeProfileXButton = elements.closeProfileXButton();
			Thread.sleep(3000);
			if (closeProfileXButton != null && closeProfileXButton.isEnabled()) {
				closeProfileXButton.click();
				androidLogs.CapturedLogs(androidText.PASS, "Edit Card Holder Info close Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Edit Card Holder Info close Button is not found");
			}			
			
			
			
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Edit Card Holder Info is not found");
		}
		
		
		
		
//TODO Bank Accounts
	
		
//SmartFunds alert settings
		Thread.sleep(3000);
		WebElement SmartFundsAlertsButton = elements.SmartFundsAlertsButton();
		Thread.sleep(3000);
		if (SmartFundsAlertsButton  != null && SmartFundsAlertsButton.isEnabled()) {
			SmartFundsAlertsButton.click();
			androidLogs.CapturedLogs(pass, "SmartFunds Alerts button found and selected");
			
			
			Thread.sleep(3000);
			WebElement SmartFundsAlertsCloseButton = elements.SmartFundsAlertsCloseButton();
			Thread.sleep(3000);
			if (SmartFundsAlertsCloseButton  != null && SmartFundsAlertsCloseButton.isEnabled()) {
				SmartFundsAlertsCloseButton.click();
				androidLogs.CapturedLogs(pass, "SmartFunds Alerts close button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "SmartFunds Alerts close button was not found");
			}
			
			
		} else {
			androidLogs.CapturedLogs(info, "SmartFunds Alerts button was not found");
		}			
		
		//androidLogs.setupTestRed("SKIP SF TRANS PER BUG MOBILE-2985");
		//androidLogs.setupTest("Testing Continued");
//Statements is causing a crash running without it JIRA MOBILE-2985 ...		
//SmartFunds Statements
		Thread.sleep(3000);
		WebElement SmartFundsstatementsButton = elements.SmartFundsstatementsButton();
		Thread.sleep(3000);
		if (SmartFundsstatementsButton  != null && SmartFundsstatementsButton.isEnabled()) {
			SmartFundsstatementsButton.click();
			androidLogs.CapturedLogs(pass, "Statement button found and selected");
			androidLogs.CapturedLogs(pass, "Due to long loading tinme Skipping opening one");
			
			Thread.sleep(3000);
			WebElement SmartFundsstatementsCloseButton = elements.SmartFundsstatementsCloseButton();
			Thread.sleep(3000);
			if (SmartFundsstatementsCloseButton  != null && SmartFundsstatementsCloseButton.isEnabled()) {
				SmartFundsstatementsCloseButton.click();
				androidLogs.CapturedLogs(pass, "Statement close button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Statement close button was not found");
			}
			
			
		} else {
			androidLogs.CapturedLogs(info, "Statement button was not found");
		}			
		
		
		
		Thread.sleep(3000);
		Thread.sleep(3000);
		scroll.ScrollDown();
		scroll.ScrollDown();
		
		
//Toggle biometrics Use Touch ID option
		Thread.sleep(3000);
		WebElement TouchIDBiometricsToggle = elements.TouchIDBiometricsToggle();
		Thread.sleep(3000);
		if (TouchIDBiometricsToggle  != null && TouchIDBiometricsToggle.isEnabled()) {
			TouchIDBiometricsToggle.click();
			androidLogs.CapturedLogs(pass, "Biometrics toggle found and selected");
		} else {
			androidLogs.CapturedLogs(fail, "Biometrics toggle was not found");
		}		
		
		Thread.sleep(3000);
		WebElement TouchIDBiometricsToggleDenyModal = elements.TouchIDBiometricsToggleDenyModal();
		Thread.sleep(3000);
		if (TouchIDBiometricsToggleDenyModal  != null && TouchIDBiometricsToggleDenyModal.isEnabled()) {
			TouchIDBiometricsToggleDenyModal.click();
			androidLogs.CapturedLogs(pass, "Biometrics Deny modal button found and selected");
		} else {
			androidLogs.CapturedLogs(fail, "Biometrics Deny modal button was not found");
		}		
		Thread.sleep(3000);

//Security questions
//TODO IT IS NOT PICKING NEW SEQURITY QUESTIONS FOR SOME REASON... fix it..
		Thread.sleep(3000);
		WebElement SecurityQuestions = elements.SecurityQuestions();
		Thread.sleep(3000);
		if (SecurityQuestions  != null && SecurityQuestions.isEnabled()) {
			SecurityQuestions.click();
			androidLogs.CapturedLogs(pass, "Security Questions button found and selected");
			
			
			Thread.sleep(3000);
			WebElement OpenSecurityQuestionOne = elements.OpenSecurityQuestionOne();
			Thread.sleep(3000);
			if (OpenSecurityQuestionOne  != null && OpenSecurityQuestionOne.isEnabled()) {
				OpenSecurityQuestionOne.click();
				androidLogs.CapturedLogs(pass, "Security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question one was not found");
			}		
		
			Thread.sleep(3000);
			WebElement OpenSecurityOneQuesrtionOnePicker = elements.OpenSecurityQuesrtionPicker();
			Thread.sleep(3000);
			if (OpenSecurityOneQuesrtionOnePicker  != null && OpenSecurityOneQuesrtionOnePicker.isEnabled()) {
				OpenSecurityOneQuesrtionOnePicker.click();
				androidLogs.CapturedLogs(pass, "New security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question one was not found");
			}
			
			
			Thread.sleep(3000);
			WebElement SelectNewQuestionByNameOne = elements.SelectNewQuestionByNameOne();
			Thread.sleep(3000);
			if (SelectNewQuestionByNameOne  != null && SelectNewQuestionByNameOne.isEnabled()) {
				SelectNewQuestionByNameOne.click();
				androidLogs.CapturedLogs(pass, "New security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question one was not found");
			}

			Thread.sleep(3000);
			WebElement AnswerSecurityQuestionOne = elements.AnswerSecurityQuestionOne();
			Thread.sleep(3000);
			if (AnswerSecurityQuestionOne  != null && AnswerSecurityQuestionOne.isEnabled()) {
				AnswerSecurityQuestionOne.click();
				AnswerSecurityQuestionOne.sendKeys(androidText.SEC_ANSWERS);
				androidLogs.CapturedLogs(pass, "Security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question one was not found");
			}		
		
			
			
			Thread.sleep(3000);
			WebElement SaveSecurityQuestionOne = elements.SaveSecurityQuestions();
			Thread.sleep(3000);
			if (SaveSecurityQuestionOne  != null && SaveSecurityQuestionOne.isEnabled()) {
				SaveSecurityQuestionOne.click();
				androidLogs.CapturedLogs(pass, "Security question one save button found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question one save button was not found");
			}		
		
			
			
			Thread.sleep(3000);
			WebElement OpenSecurityQuestionTwo = elements.OpenSecurityQuestionTwo();
			Thread.sleep(3000);
			if (OpenSecurityQuestionTwo  != null && OpenSecurityQuestionTwo.isEnabled()) {
				OpenSecurityQuestionTwo.click();
				androidLogs.CapturedLogs(pass, "Security question two found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question two was not found");
			}		
			
			Thread.sleep(3000);
			WebElement OpenSecurityTwoQuesrtionPicker = elements.OpenSecurityQuesrtionPicker();
			Thread.sleep(3000);
			if (OpenSecurityTwoQuesrtionPicker  != null && OpenSecurityTwoQuesrtionPicker.isEnabled()) {
				OpenSecurityTwoQuesrtionPicker.click();
				androidLogs.CapturedLogs(pass, "New security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question one was not found");
			}
			
			
			
			Thread.sleep(3000);
			WebElement PickNewSecurityQuestionTwo = elements.PickNewSecurityQuestionTwo();
			Thread.sleep(3000);
			if (PickNewSecurityQuestionTwo  != null && PickNewSecurityQuestionTwo.isEnabled()) {
				PickNewSecurityQuestionTwo.click();
				androidLogs.CapturedLogs(pass, "New security question two found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question two was not found");
			}		
		

			Thread.sleep(3000);
			WebElement AnswerSecurityQuestionTwo = elements.AnswerSecurityQuestionTwo();
			Thread.sleep(3000);
			if (AnswerSecurityQuestionTwo  != null && AnswerSecurityQuestionTwo.isEnabled()) {
				AnswerSecurityQuestionTwo.click();
				AnswerSecurityQuestionTwo.sendKeys(androidText.SEC_ANSWERS);
				androidLogs.CapturedLogs(pass, "Security question two found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question two was not found");
			}		
		
			
			
			Thread.sleep(3000);
			WebElement SaveSecurityQuestionTwo = elements.SaveSecurityQuestions();
			Thread.sleep(3000);
			if (SaveSecurityQuestionTwo  != null && SaveSecurityQuestionTwo.isEnabled()) {
				SaveSecurityQuestionTwo.click();
				androidLogs.CapturedLogs(pass, "Security question two save button found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question two save button was not found");
			}		
			
			
			
			
			
			Thread.sleep(3000);
			WebElement OpenSecurityQuestionThree = elements.OpenSecurityQuestionThree();
			Thread.sleep(3000);
			if (OpenSecurityQuestionThree  != null && OpenSecurityQuestionThree.isEnabled()) {
				OpenSecurityQuestionThree.click();
				androidLogs.CapturedLogs(pass, "Security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question one was not found");
			}		
			
			
		
			Thread.sleep(3000);
			WebElement OpenSecurityThreeQuesrtionPicker = elements.OpenSecurityQuesrtionPicker();
			Thread.sleep(3000);
			if (OpenSecurityThreeQuesrtionPicker  != null && OpenSecurityThreeQuesrtionPicker.isEnabled()) {
				OpenSecurityThreeQuesrtionPicker.click();
				androidLogs.CapturedLogs(pass, "New security question one found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question one was not found");
			}
			
			Thread.sleep(3000);
			WebElement PickNewSecurityQuesrtionThree = elements.PickNewSecurityQuesrtionThree();
			Thread.sleep(3000);
			if (PickNewSecurityQuesrtionThree  != null && PickNewSecurityQuesrtionThree.isEnabled()) {
				PickNewSecurityQuesrtionThree.click();
				androidLogs.CapturedLogs(pass, "New security question three found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "New security question three was not found");
			}		
			

			Thread.sleep(3000);
			WebElement AnswerSecurityQuestionThree = elements.AnswerSecurityQuestionThree();
			Thread.sleep(3000);
			if (AnswerSecurityQuestionThree  != null && AnswerSecurityQuestionThree.isEnabled()) {
				AnswerSecurityQuestionThree.click();
				AnswerSecurityQuestionThree.sendKeys(androidText.SEC_ANSWERS);
				androidLogs.CapturedLogs(pass, "Security question three found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question three was not found");
			}		
		
			
			
			Thread.sleep(3000);
			WebElement SaveSecurityQuestionThree = elements.SaveSecurityQuestions();
			Thread.sleep(3000);
			if (SaveSecurityQuestionThree  != null && SaveSecurityQuestionThree.isEnabled()) {
				SaveSecurityQuestionThree.click();
				androidLogs.CapturedLogs(pass, "Security question three save button found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question three save button was not found");
			}		
			
			Thread.sleep(3000);
			WebElement CloseSecurityQuestionPage = elements.CloseSecurityQuestionPage();
			Thread.sleep(3000);
			if (CloseSecurityQuestionPage  != null && CloseSecurityQuestionPage.isEnabled()) {
				CloseSecurityQuestionPage.click();
				androidLogs.CapturedLogs(pass, "Security question three save button found and selected");
			} else {
				androidLogs.CapturedLogs(fail, "Security question three save button was not found");
			}		
			
			
		} else {
			androidLogs.CapturedLogs(info, "Security Questions button was not found");
		}
		
		
		
//Help Screens
				// Find and open helps screens
//				Thread.sleep(3000);
//				WebElement HelpScreenOpenButton = elements.HelpScreenOpenButton();
//				Thread.sleep(3000);
//				if (HelpScreenOpenButton  != null && HelpScreenOpenButton.isEnabled()) {
//					HelpScreenOpenButton.click();
//					androidLogs.CapturedLogs(pass, "Help Screens button from home page is found and pressed");
//
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensHome = elements.HelpScreensHome();
//				Thread.sleep(3000);
//				if (HelpScreensHome  != null && HelpScreensHome.isEnabled()) {
//					HelpScreensHome.click();
//					androidLogs.CapturedLogs(pass, "Help Screens home button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Screens home button was not found");
//				}
//
//				Thread.sleep(3000);
//				WebElement HelpScreensHomeCloseButton = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (HelpScreensHomeCloseButton  != null && HelpScreensHomeCloseButton.isEnabled()) {
//					HelpScreensHomeCloseButton.click();
//					androidLogs.CapturedLogs(pass, "Help Home close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Home close button was not found");
//				}
//				
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensAccount = elements.HelpScreensAccount();
//				Thread.sleep(3000);
//				if (HelpScreensAccount  != null && HelpScreensAccount.isEnabled()) {
//					HelpScreensAccount.click();
//					androidLogs.CapturedLogs(pass, "Account button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Account button was not found");
//				}
//				
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensCloseButtonAccount = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (HelpScreensCloseButtonAccount  != null && HelpScreensCloseButtonAccount.isEnabled()) {
//					HelpScreensCloseButtonAccount.click();
//					androidLogs.CapturedLogs(pass, "Help Account close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Account close button was not found");
//				}
//
//				Thread.sleep(3000);
//				WebElement HelpScreensTransactions = elements.HelpScreensTransactions();
//				Thread.sleep(3000);
//				if (HelpScreensTransactions  != null && HelpScreensTransactions.isEnabled()) {
//					HelpScreensTransactions.click();
//					androidLogs.CapturedLogs(pass, "Transactions button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Transactions button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensCloseButtonTransactions = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (HelpScreensCloseButtonTransactions  != null && HelpScreensCloseButtonTransactions.isEnabled()) {
//					HelpScreensCloseButtonTransactions.click();
//					androidLogs.CapturedLogs(pass, "Help Transactions close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Transactions close button was not found");
//				}				
//
//				Thread.sleep(3000);
//				WebElement HelpScreensFindFuelNearby = elements.HelpScreensFindFuelNearby();
//				Thread.sleep(3000);
//				if (HelpScreensFindFuelNearby  != null && HelpScreensFindFuelNearby.isEnabled()) {
//					HelpScreensFindFuelNearby.click();
//					androidLogs.CapturedLogs(pass, "Find Fuel nearby button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Find Fuel nearby button button was not found");
//				}
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensCloseButtonFindFuel = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (HelpScreensCloseButtonFindFuel  != null && HelpScreensCloseButtonFindFuel.isEnabled()) {
//					HelpScreensCloseButtonFindFuel.click();
//					androidLogs.CapturedLogs(pass, "Help Find Fuel nearby close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Find Fuel nearby close button was not found");
//				}		
//
//				Thread.sleep(3000);
//				WebElement HelpScreensFindFuelPlanATrip = elements.HelpScreensFindFuelPlanATrip();
//				Thread.sleep(3000);
//				if (HelpScreensFindFuelPlanATrip  != null && HelpScreensFindFuelPlanATrip.isEnabled()) {
//					HelpScreensFindFuelPlanATrip.click();
//					androidLogs.CapturedLogs(pass, "Find Fuel plan a trip button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Find Fuel plan a trip button was not found");
//				}
//
//				
//				Thread.sleep(3000);
//				WebElement HelpScreensCloseButtonTrip = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (HelpScreensCloseButtonTrip  != null && HelpScreensCloseButtonTrip.isEnabled()) {
//					HelpScreensCloseButtonTrip.click();
//					androidLogs.CapturedLogs(pass, "Help Find Fuel plan a trip close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help Find Fuel plan a trip close button was not found");
//				}		
//				
//				
//				Thread.sleep(3000);
//				WebElement CloseHelpScreens = elements.HelpScreensCloseButton();
//				Thread.sleep(3000);
//				if (CloseHelpScreens  != null && CloseHelpScreens.isEnabled()) {
//					CloseHelpScreens.click();
//					androidLogs.CapturedLogs(pass, "Help screens close button is found and pressed");
//				} else {
//					androidLogs.CapturedLogs(fail, "Help screensclose button was not found");
//				}		
//				
//			} else {
//			  androidLogs.CapturedLogs(fail, "Help Screens button from home page was not found");
//		}
				
		
//Privacy policy
				Thread.sleep(3000);
				WebElement PrivacyPolicy = elements.PrivacyPolicy();
				Thread.sleep(3000);
				if (PrivacyPolicy  != null && PrivacyPolicy.isEnabled()) {
					PrivacyPolicy.click();
					androidLogs.CapturedLogs(pass, "Privacy Policy button found and selected");
				} else {
					androidLogs.CapturedLogs(fail, "Privacy Policy button was not found");
				}		
				
				Thread.sleep(3000);
				WebElement PrivacyPolicyClose = elements.PrivacyPolicyClose();
				Thread.sleep(3000);
				if (PrivacyPolicyClose  != null && PrivacyPolicyClose.isEnabled()) {
					PrivacyPolicyClose.click();
					androidLogs.CapturedLogs(pass, "Privacy Policy Close button found and selected");
				} else {
					androidLogs.CapturedLogs(fail, "Privacy Policy Close button was not found");
				}		

//Terms Of Use
				Thread.sleep(3000);
				WebElement TermsOfUse = elements.TermsOfUse();
				Thread.sleep(3000);
				if (TermsOfUse  != null && TermsOfUse.isEnabled()) {
					TermsOfUse.click();
					androidLogs.CapturedLogs(pass, "Terms of use button found and selected");
				} else {
					androidLogs.CapturedLogs(fail, "Terms of use button was not found");
				}		
				
				Thread.sleep(3000);
				WebElement TermsOfUseClose = elements.TermsOfUseClose();
				Thread.sleep(3000);
				if (TermsOfUseClose  != null && TermsOfUseClose.isEnabled()) {
					TermsOfUseClose.click();
					androidLogs.CapturedLogs(pass, "Terms Of Use Close button found and selected");
				} else {
					androidLogs.CapturedLogs(fail, "Terms Of Use Close button was not found");
				}
				
//Call Customer service
				Thread.sleep(3000);
				WebElement CallCustomerSupportButton = elements.CallCustomerSupportButton();
				Thread.sleep(3000);
				if (CallCustomerSupportButton  != null && CallCustomerSupportButton.isEnabled()) {
					CallCustomerSupportButton.click();
					androidLogs.CapturedLogs(pass, "Call customer support button found and selected");
				} else {
					androidLogs.CapturedLogs(fail, "Call customer support was not found");
				}		
				
				Thread.sleep(3000);
				Capabilities.driver.navigate().back();
				androidLogs.CapturedLogs(info, "Back used to close Dialer");
				
				Thread.sleep(3000);
				Capabilities.driver.navigate().back();
				androidLogs.CapturedLogs(info, "Back used to close add Contact page");
				
				Thread.sleep(3000);
				Capabilities.driver.navigate().back();
				androidLogs.CapturedLogs(info, "Back used to close contacts page");

//Check Version
				Thread.sleep(3000);
				WebElement AppVersionHomeAccountPage = elements.AppVersionHomeAccountPage();
				Thread.sleep(3000);
				if (AppVersionHomeAccountPage  != null && AppVersionHomeAccountPage.isEnabled()) {
					this.appVersionNumber = AppVersionHomeAccountPage.getText();
					androidLogs.CapturedLogs(pass, "App version " +this.appVersionNumber+ " found");
				} else {
					androidLogs.CapturedLogs(fail, "App version not found");
				}						
				
		
		
		// find logout cancel modal button click it open the logout modal again and
		Thread.sleep(3000);
		WebElement CardLogoutButton = elements.CardLogoutButton();
		Thread.sleep(3000);
		if (CardLogoutButton  != null && CardLogoutButton.isEnabled()) {
				CardLogoutButton.click();
			androidLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Log out button on profile page was not found");

		}
		
		
		
		// find logout modal no button and click it as logout is in account section
//		Thread.sleep(3000);
//		WebElement CardLogoutModalCancelButton = elements.CardLogoutModalCancelButton();
//		Thread.sleep(3000);
//		if (CardLogoutModalCancelButton != null && CardLogoutModalCancelButton.isEnabled()) {
//			CardLogoutModalCancelButton.click();
//			androidLogs.CapturedLogs(pass, "Logout Modal Cancel Button is found and pressed");
//		} else {
//			androidLogs.CapturedLogs(fail, "Logout Modal Cancel Button is not found");
//		}
//		
//		// find logout cancel modal button click it open the logout modal again and
//		Thread.sleep(3000);
//		WebElement CardLogoutButtonTwo = elements.CardLogoutButton();
//		Thread.sleep(3000);
//		if (CardLogoutButtonTwo  != null && CardLogoutButtonTwo.isEnabled()) {
//			CardLogoutButtonTwo.click();
//			androidLogs.CapturedLogs(pass, "Log out button on profile page is found and pressed");
//		} else {
//			androidLogs.CapturedLogs(fail, "Log out button on profile page was not found");
//		}
		
		
		// find logout modal button and click logout from modal
		Thread.sleep(3000);
		WebElement CardLogoutModalButton = elements.CardLogoutModalButton();
		Thread.sleep(3000);
		if (CardLogoutModalButton != null && CardLogoutModalButton.isEnabled()) {
			CardLogoutModalButton.click();
			androidLogs.CapturedLogs(pass, "Logout Modal Log Out Button is found and pressed");
		} else {
			androidLogs.CapturedLogs(fail, "Logout Modal Log Out Button was not found");

		}
		
		} else {
			androidLogs.CapturedLogs(fail, "Card holder information screen is not found");
		}
		
		
		
		return this;
	}

}
