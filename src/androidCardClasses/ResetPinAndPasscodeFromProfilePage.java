package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class ResetPinAndPasscodeFromProfilePage {

	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String lastFour;
	private String lastEight;
	
	public ResetPinAndPasscodeFromProfilePage openProfileButtonFromHome(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.lastFour = cardNumber.substring(cardNumber.length()-4);
		this.lastEight = cardNumber.substring(cardNumber.length()-8);
		//System.out.println("last Four: " + lastFour);
		//System.out.println("last Eight: " + lastEight);
		//System.out.println("I am in login Pass invoirment is: " + environment);
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
	
	
	public ResetPinAndPasscodeFromProfilePage openProfileButtonFromHome() throws Exception {
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		androidText = new AppStringsAndroid(env);
		androidLogs.setupTest("ACCOUNT PROFILE PAGE TESTING STARTED");
				
		//Help screen for Account Profile page
				Thread.sleep(3000);
				WebElement HelpScreenContinue = elements.HelpScreenContinue();
				Thread.sleep(3000);
				if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
					HelpScreenContinue.click();
					androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
				} else {
					androidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
				}
		
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
		WebElement HelpScreenContinue2 = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue2 != null && HelpScreenContinue2.isEnabled()) {
			HelpScreenContinue2.click();
			androidLogs.CapturedLogs(pass, "Help Screen Continye Button is found and pressed.");
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Continye Button is not found");
		}
		
		
//Change Pin expect fails for not have matching new pins
		androidLogs.setupTest("RESET PIN FROM PROFILE TESTS");
		androidLogs.setupTest("Matching pin fail Function test");
				WebElement changePinButtonFromProfile = elements.changePinButtonFromProfile();
				Thread.sleep(3000);
				if (changePinButtonFromProfile != null && changePinButtonFromProfile.isEnabled()) {
					changePinButtonFromProfile.click();
					androidLogs.CapturedLogs(pass, "Change Pin button on profile is found and pressed.");
					
					
					WebElement currentPinOnProfileTextBox = elements.currentPinOnProfileTextBox();
					Thread.sleep(3000);
					if (currentPinOnProfileTextBox != null && currentPinOnProfileTextBox.isEnabled()) {
						currentPinOnProfileTextBox.click();
						currentPinOnProfileTextBox.sendKeys(passwordOrPin);
						androidLogs.CapturedLogs(pass, "Original pin entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Original pin not entered.");
					}
						
					
						
						
						WebElement newCurrentPinOnProfileTextBox = elements.newCurrentPinOnProfileTextBox();
						Thread.sleep(3000);
						if (newCurrentPinOnProfileTextBox != null && newCurrentPinOnProfileTextBox.isEnabled()) {
							newCurrentPinOnProfileTextBox.click();
							newCurrentPinOnProfileTextBox.sendKeys("1234");
							androidLogs.CapturedLogs(pass, "New pin entered.");
						
						}else {
							androidLogs.CapturedLogs(fail, "New pin not entered.");
						}
						
							WebElement confirmNewcurrentPinOnProfileTextBox = elements.confirmNewcurrentPinOnProfileTextBox();
							Thread.sleep(3000);
							if (confirmNewcurrentPinOnProfileTextBox != null && confirmNewcurrentPinOnProfileTextBox.isEnabled()) {
								confirmNewcurrentPinOnProfileTextBox.click();
								confirmNewcurrentPinOnProfileTextBox.sendKeys("5421");
								androidLogs.CapturedLogs(pass, "Confirm New pin entered.");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New pin not entered.");
							}
							
							WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
							if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
								confirmNewPinSaveButton.click();
								androidLogs.CapturedLogs(pass, "Confirm New pin save Button selected");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New pin save Button not selected");
							}
									
			
		
				WebElement pinsDontMatchModalOkButton = elements.pinsDontMatchModalOkButton();
				Thread.sleep(3000);
				if (pinsDontMatchModalOkButton != null && pinsDontMatchModalOkButton.isEnabled()) {
					pinsDontMatchModalOkButton.click();
					androidLogs.CapturedLogs(pass, "Pins Dont match modal seen and ok button pressed");
				}else {
					androidLogs.CapturedLogs(fail, "Pins Dont match modal not seen");
				}

				
				
//Change Pin expect fails because you put in wrong pin 		
								
				androidLogs.setupTest("Current pin Wrong fail Function test");
					//WebElement currentPinOnProfileTextBox = elements.currentPinOnProfileTextBox();
					Thread.sleep(3000);
					if (currentPinOnProfileTextBox != null && currentPinOnProfileTextBox.isEnabled()) {
						currentPinOnProfileTextBox.click();
						currentPinOnProfileTextBox.sendKeys("1234");
						androidLogs.CapturedLogs(pass, "Original pin entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Original pin not entered.");
					}
						
					
						
						
					//	WebElement newCurrentPinOnProfileTextBox = elements.newCurrentPinOnProfileTextBox();
						Thread.sleep(3000);
						if (newCurrentPinOnProfileTextBox != null && newCurrentPinOnProfileTextBox.isEnabled()) {
							newCurrentPinOnProfileTextBox.click();
							newCurrentPinOnProfileTextBox.sendKeys("1234");
							androidLogs.CapturedLogs(pass, "New pin entered.");
						
						}else {
							androidLogs.CapturedLogs(fail, "New pin not entered.");
						}
						
						//	WebElement confirmNewcurrentPinOnProfileTextBox = elements.confirmNewcurrentPinOnProfileTextBox();
							Thread.sleep(3000);
							if (confirmNewcurrentPinOnProfileTextBox != null && confirmNewcurrentPinOnProfileTextBox.isEnabled()) {
								confirmNewcurrentPinOnProfileTextBox.click();
								confirmNewcurrentPinOnProfileTextBox.sendKeys("1234");
								androidLogs.CapturedLogs(pass, "Confirm New pin entered.");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New pin not entered.");
							}
							
						//	WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
							if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
								confirmNewPinSaveButton.click();
								androidLogs.CapturedLogs(pass, "Confirm New pin save Button selected");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New pin save Button not selected");
							}
									
			
		
				WebElement currentPinWrongModalOkButton = elements.currentPinWrongModalOkButton();
				Thread.sleep(3000);
				if (currentPinWrongModalOkButton != null && currentPinWrongModalOkButton.isEnabled()) {
					currentPinWrongModalOkButton.click();
					androidLogs.CapturedLogs(pass, "Pins Dont match modal seen and ok button pressed");
				}else {
					androidLogs.CapturedLogs(fail, "Pins Dont match modal not seen");
				}

				
//Change Pin expect fails because you put in the last four of the card number 		
				androidLogs.setupTest("Last four pin fail Function test");
				Thread.sleep(3000);
				
				if (currentPinOnProfileTextBox != null && currentPinOnProfileTextBox.isEnabled()) {
					currentPinOnProfileTextBox.click();
					currentPinOnProfileTextBox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "Original pin entered.");
				}else {
					androidLogs.CapturedLogs(fail, "Original pin not entered.");
				}
					
				
					
					
				//	WebElement newCurrentPinOnProfileTextBox = elements.newCurrentPinOnProfileTextBox();
					Thread.sleep(3000);
					if (newCurrentPinOnProfileTextBox != null && newCurrentPinOnProfileTextBox.isEnabled()) {
						newCurrentPinOnProfileTextBox.click();
						newCurrentPinOnProfileTextBox.sendKeys(lastFour);
						androidLogs.CapturedLogs(pass, "New pin entered.");
					
					}else {
						androidLogs.CapturedLogs(fail, "New pin not entered.");
					}
					
					//	WebElement confirmNewcurrentPinOnProfileTextBox = elements.confirmNewcurrentPinOnProfileTextBox();
						Thread.sleep(3000);
						if (confirmNewcurrentPinOnProfileTextBox != null && confirmNewcurrentPinOnProfileTextBox.isEnabled()) {
							confirmNewcurrentPinOnProfileTextBox.click();
							confirmNewcurrentPinOnProfileTextBox.sendKeys(lastFour);
							androidLogs.CapturedLogs(pass, "Confirm New pin entered.");
						}else {
							androidLogs.CapturedLogs(fail, "Confirm New pin not entered.");
						}
						
					//	WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
						if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
							confirmNewPinSaveButton.click();
							androidLogs.CapturedLogs(pass, "Confirm New pin save Button selected");
						}else {
							androidLogs.CapturedLogs(fail, "Confirm New pin save Button not selected");
						}
								
		
	
			WebElement lastFourWrongModalOkButton = elements.lastFourWrongModalOkButton();
			Thread.sleep(3000);
			if (lastFourWrongModalOkButton != null && lastFourWrongModalOkButton.isEnabled()) {
				lastFourWrongModalOkButton.click();
				androidLogs.CapturedLogs(pass, "Last four of the card modal seen and ok button pressed");
			}else {
				androidLogs.CapturedLogs(fail, "Last four of the card not seen");
			}
				
				
				
//Change Pin account profile page 		
		
			androidLogs.setupTest("Change pin pass Function test");
			Thread.sleep(3000);
			if (currentPinOnProfileTextBox != null && currentPinOnProfileTextBox.isEnabled()) {
				currentPinOnProfileTextBox.click();
				currentPinOnProfileTextBox.sendKeys(passwordOrPin);
				androidLogs.CapturedLogs(pass, "Original pin entered.");
			}else {
				androidLogs.CapturedLogs(fail, "Original pin not entered.");
			}
				
			
				
				
				//WebElement newCurrentPinOnProfileTextBox = elements.newCurrentPinOnProfileTextBox();
				Thread.sleep(3000);
				if (newCurrentPinOnProfileTextBox != null && newCurrentPinOnProfileTextBox.isEnabled()) {
					newCurrentPinOnProfileTextBox.click();
					newCurrentPinOnProfileTextBox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "New pin entered.");
				
				}else {
					androidLogs.CapturedLogs(fail, "New pin not entered.");
				}
				
					//WebElement confirmNewcurrentPinOnProfileTextBox = elements.confirmNewcurrentPinOnProfileTextBox();
					Thread.sleep(3000);
					if (confirmNewcurrentPinOnProfileTextBox != null && confirmNewcurrentPinOnProfileTextBox.isEnabled()) {
						confirmNewcurrentPinOnProfileTextBox.click();
						confirmNewcurrentPinOnProfileTextBox.sendKeys(passwordOrPin);
						androidLogs.CapturedLogs(pass, "Confirm New pin entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New pin not entered.");
					}
					
					//WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
					if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
						confirmNewPinSaveButton.click();
						androidLogs.CapturedLogs(pass, "Confirm New pin save Button selected");
					}else {
						androidLogs.CapturedLogs(fail, "Confirm New pin save Button not selected");
					}
				
			} else {
				androidLogs.CapturedLogs(info, "Change Pin button on profile is not found");
			}
				

				
		
//Change Passcode fails for not have matching new pins
		androidLogs.setupTest("RESET PASSCODE FROM PROFILE TESTS");
		androidLogs.setupTest("Passcode dont match fail Function test");
		WebElement changePassCodeButtonFromProfile = elements.changePassCodeButtonFromProfile();
		Thread.sleep(3000);
		if (changePassCodeButtonFromProfile != null && changePassCodeButtonFromProfile.isEnabled()) {
			changePassCodeButtonFromProfile.click();
			androidLogs.CapturedLogs(pass, "Change Passcode button on profile is found and pressed.");
			
			
			
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
				
				WebElement newCurrentPasscodeOnProfileTextBox = elements.newCurrentPasscodeOnProfileTextBox();
				Thread.sleep(3000);
				if (newCurrentPasscodeOnProfileTextBox != null && newCurrentPasscodeOnProfileTextBox.isEnabled()) {
					newCurrentPasscodeOnProfileTextBox.click();
					newCurrentPasscodeOnProfileTextBox.sendKeys("123456");
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
			
					
					WebElement passcodeDontMatchModalOkButton = elements.passcodeDontMatchModalOkButton();
					Thread.sleep(3000);
					if (passcodeDontMatchModalOkButton != null && passcodeDontMatchModalOkButton.isEnabled()) {
						passcodeDontMatchModalOkButton.click();
						androidLogs.CapturedLogs(pass, "passcodes Dont match modal seen and ok button pressed");
					}else {
						androidLogs.CapturedLogs(fail, "passcodes Dont match modal not seen");
					}
					
					
		
//Change Passcode fail because pin put in wrong on account profile page 		
				
				androidLogs.setupTest("Current passcode wrong fail Function test");
				//WebElement currentPasscodeOnProfileTextBox = elements.currentPasscodeOnProfileTextBox();
					Thread.sleep(3000);
					
					if (currentPasscodeOnProfileTextBox != null && currentPasscodeOnProfileTextBox.isEnabled()) {
						//currentPasscodeOnProfileTextBox.click();
						currentPasscodeOnProfileTextBox.sendKeys("123456");
						androidLogs.CapturedLogs(pass, "Original passcode entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Original passcode not entered.");
					}
						
				//		WebElement newCurrentPasscodeOnProfileTextBox = elements.newCurrentPasscodeOnProfileTextBox();
						Thread.sleep(3000);
						if (newCurrentPasscodeOnProfileTextBox != null && newCurrentPasscodeOnProfileTextBox.isEnabled()) {
							newCurrentPasscodeOnProfileTextBox.click();
							newCurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
							androidLogs.CapturedLogs(pass, "New passcode entered.");
						
						}else {
							androidLogs.CapturedLogs(fail, "New passcode not entered.");
						}
						
				//			WebElement confirmNewcurrentPasscodeOnProfileTextBox = elements.confirmNewcurrentPasscodeOnProfileTextBox();
							Thread.sleep(3000);
							if (confirmNewcurrentPasscodeOnProfileTextBox != null && confirmNewcurrentPasscodeOnProfileTextBox.isEnabled()) {
								confirmNewcurrentPasscodeOnProfileTextBox.click();
								confirmNewcurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
								androidLogs.CapturedLogs(pass, "Confirm New passcode entered.");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New passcode not entered.");
							}
							
						//	WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
							Thread.sleep(3000);
							if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
								confirmNewPinSaveButton.click();
								androidLogs.CapturedLogs(pass, "Confirm New passcode save Button selected");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New passcode save Button not selected");
							}
				
							WebElement currentPasscodeWrongModalOkButton = elements.currentPasscodeWrongModalOkButton();
							Thread.sleep(3000);
							if (currentPasscodeWrongModalOkButton != null && currentPasscodeWrongModalOkButton.isEnabled()) {
								currentPasscodeWrongModalOkButton.click();
								androidLogs.CapturedLogs(pass, "Passcocde Dont match modal seen and ok button pressed");
							}else {
								androidLogs.CapturedLogs(fail, "Passcode Dont match modal not seen");
							}	
							
				
//Passcode fails because you put in the last eight of the card number 		
							androidLogs.setupTest("Last eight passcode fail Function test");
							Thread.sleep(3000);
							Thread.sleep(3000);
								if (currentPasscodeOnProfileTextBox != null && currentPasscodeOnProfileTextBox.isEnabled()) {
									//currentPasscodeOnProfileTextBox.click();
									currentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
									androidLogs.CapturedLogs(pass, "Original passcode entered.");
								}else {
									androidLogs.CapturedLogs(fail, "Original passcode not entered.");
								}
									
									//WebElement newCurrentPasscodeOnProfileTextBox = elements.newCurrentPasscodeOnProfileTextBox();
									Thread.sleep(3000);
									if (newCurrentPasscodeOnProfileTextBox != null && newCurrentPasscodeOnProfileTextBox.isEnabled()) {
										newCurrentPasscodeOnProfileTextBox.click();
										newCurrentPasscodeOnProfileTextBox.sendKeys(lastEight);
										androidLogs.CapturedLogs(pass, "New passcode entered.");
									
									}else {
										androidLogs.CapturedLogs(fail, "New passcode not entered.");
									}
									
										//WebElement confirmNewcurrentPasscodeOnProfileTextBox = elements.confirmNewcurrentPasscodeOnProfileTextBox();
										Thread.sleep(3000);
										if (confirmNewcurrentPasscodeOnProfileTextBox != null && confirmNewcurrentPasscodeOnProfileTextBox.isEnabled()) {
											confirmNewcurrentPasscodeOnProfileTextBox.click();
											confirmNewcurrentPasscodeOnProfileTextBox.sendKeys(lastEight);
											androidLogs.CapturedLogs(pass, "Confirm New passcode entered.");
										}else {
											androidLogs.CapturedLogs(fail, "Confirm New passcode not entered.");
										}
										
										//WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
										Thread.sleep(3000);
										if (confirmNewPinSaveButton != null && confirmNewPinSaveButton.isEnabled()) {
											confirmNewPinSaveButton.click();
											androidLogs.CapturedLogs(pass, "Confirm New passcode save Button selected");
										}else {
											androidLogs.CapturedLogs(fail, "Confirm New passcode save Button not selected");
										}
								
										
										WebElement passcodeLastSixModalOkButton = elements.passcodeLastSixModalOkButton();
										Thread.sleep(3000);
										if (passcodeLastSixModalOkButton != null && passcodeLastSixModalOkButton.isEnabled()) {
											passcodeLastSixModalOkButton.click();
											androidLogs.CapturedLogs(pass, "Last six of passcodes modal seen and ok button pressed");
										}else {
											androidLogs.CapturedLogs(fail, "Last six of passcodes modal not seen");
										}
							
				
//Change Passcode on account profile page
				androidLogs.setupTest("Change passcode pass Function test");
				Thread.sleep(3000);
				
				//WebElement currentPasscodeOnProfileTextBox1 = elements.newCurrentPasscodeOnProfileTextBox();
					if (currentPasscodeOnProfileTextBox != null && currentPasscodeOnProfileTextBox.isEnabled()) {
						currentPasscodeOnProfileTextBox.click();
						currentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
						androidLogs.CapturedLogs(pass, "Original passcode entered.");
					}else {
						androidLogs.CapturedLogs(fail, "Original passcode not entered.");
					}
						
					//WebElement newCurrentPasscodeOnProfileTextBox1 = elements.newCurrentPasscodeOnProfileTextBox();
						Thread.sleep(3000);
						if (newCurrentPasscodeOnProfileTextBox != null && newCurrentPasscodeOnProfileTextBox.isEnabled()) {
							newCurrentPasscodeOnProfileTextBox.click();
							newCurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
							androidLogs.CapturedLogs(pass, "New passcode entered.");
						
						}else {
							androidLogs.CapturedLogs(fail, "New passcode not entered.");
						}
						
						//WebElement confirmNewcurrentPasscodeOnProfileTextBox1 = elements.confirmNewcurrentPasscodeOnProfileTextBox();
							Thread.sleep(3000);
							if (confirmNewcurrentPasscodeOnProfileTextBox != null && confirmNewcurrentPasscodeOnProfileTextBox.isEnabled()) {
								confirmNewcurrentPasscodeOnProfileTextBox.click();
								confirmNewcurrentPasscodeOnProfileTextBox.sendKeys(passwordOrPin);
								androidLogs.CapturedLogs(pass, "Confirm New passcode entered.");
							}else {
								androidLogs.CapturedLogs(fail, "Confirm New passcode not entered.");
							}
							
//							WebElement confirmNewPinSaveButton = elements.confirmNewPinSaveButton();
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
			
		
		androidLogs.setupTest("LOGOUT FROM PROFILE TESTS");
		Thread.sleep(3000);
		Thread.sleep(3000);
		scroll.ScrollDown();
		scroll.ScrollDown();
		
		
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
		
		return this;
	}

}
