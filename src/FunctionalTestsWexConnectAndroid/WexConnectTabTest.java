package FunctionalTestsWexConnectAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCardClasses.ProgressSpinner;
import androidCardClasses.RepoCardAndroid;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.PhonePicker;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class WexConnectTabTest {
	static AppiumDriver<WebElement> driver;

	@Test
	public void wexConnectTabTest() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		RepoCardAndroid elements = new RepoCardAndroid();
		ScrollOptions scroll = new ScrollOptions();
		ProgressSpinner loading = new ProgressSpinner();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String tab;
		String sanFran = "San Francisco, CA, USA";
		String newYork = "New York, NY, USA";
		String ogdenUtah = "Ogden, UT, USA";
		String dallasTexas = "Dallas, TX, USA";
		String pickedLocation;
		String ev22 = "EV22";
		String edge20 = "edge20";
		String carWashOnly = "FIND A LOCTATION FOR THIS";
		

//TODO Maybe we can add a scroll down that uses a wait for the banner name to be seen for ev22 and edge 20 stuff......
//TODO		FILTERS ADD 
//TODO MORE USE CODE: edge20 (Looks for EDGE network save $0 banner) A good address is 3 ridgeway road scarborough, ME)  
//TODO  USE CODE: ev22 (Coming SOON) 
//TODO Check for we couldnt find any stations (find a dead area with no stations or something)
//TODO add new phone allow location access
//TODO good sites for details 		
//		J1772 6.5kW AC - Dual look 527 Holly Drive, Ogden Utah (This one Found lots of places)
//		CHAdeMO 50 kW DC -  865 2nd street North, Washington UT 
//		Combo / CHAdeMO 50 kW DC - 865 2nd street North, Washington UT 
//		CHAdeMO 62.5kW DC - 884 Park Avenue, New York NY
//		Combo 62.0kW DC - 884 Park Avenue, New York NY
//		Combo 24.0kW DC - 183 Washington street, Las Vegas, NV 
//		CHAdeMO 500.0kW DC -  1746 Primrose Path, Las Vegas, NV  
//		Unknown location: 437 8th street South, New York, NY 
//		Lots of locations: Atlanta, GA 

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smoke Test ";
		String build = "Build #: 4.3.4 (18232) ";
		String appName = "Wex Connect ";
		String server = "Stage ";

		try {
			androidLogs.setupTest(TestName + build + appName +server);

			System.out.println(phone.autoPhonePickerWexConnect(appName));

			Thread.sleep(3000);
			WebElement AllowModal = elements.AllowModal();
			Thread.sleep(3000);
			if (AllowModal != null && AllowModal.isEnabled()) {
				AllowModal.click();
				androidLogs.CapturedLogs(pass, "Allow Location Button is found and pressed");
			} else {
				androidLogs.CapturedLogs(info, "Allow Location Button button is not found");
			}

//More tab			
			tab = "MORE TAB";
			androidLogs.setupTestYellow(tab);
			Thread.sleep(3000);
			WebElement MoreTab = elements.MoreTab();
			Thread.sleep(3000);
			if (MoreTab != null && MoreTab.isEnabled()) {
				MoreTab.click();
				androidLogs.CapturedLogs(pass, tab + " found and pressed");

//				Promo Codes
//				ev22: Go back to maps and find a few with a banner for this (Probably find a location prior and use it.)
//				edge20  Go back to maps and find a few with a banner for this (Probably find a location prior and use it.)
//				
				WebElement WexConnectPromoCodesButton = elements.WexConnectPromoCodesButton();
				Thread.sleep(3000);
				if (WexConnectPromoCodesButton != null && WexConnectPromoCodesButton.isEnabled()) {
					WexConnectPromoCodesButton.click();
					androidLogs.CapturedLogs(pass, "Promo codes is found and pressed");
					Thread.sleep(2000);

					WebElement WexConnectPromoCodeTextBoxEV22 = elements.WexConnectPromoCodeTextBox(ev22);
					Thread.sleep(3000);
					if (WexConnectPromoCodeTextBoxEV22 != null && WexConnectPromoCodeTextBoxEV22.isEnabled()) {
						WexConnectPromoCodeTextBoxEV22.click();
						WexConnectPromoCodeTextBoxEV22.sendKeys(ev22);
						androidLogs.CapturedLogs(pass, "Promo code " + ev22 + " added to text box");

						Thread.sleep(2000);
						WebElement WexConnectPromoCodeEnterCodeButtonEV22 = elements
								.WexConnectPromoCodeEnterCodeButton();
						Thread.sleep(3000);
						if (WexConnectPromoCodeEnterCodeButtonEV22 != null
								&& WexConnectPromoCodeEnterCodeButtonEV22.isEnabled()) {
							WexConnectPromoCodeEnterCodeButtonEV22.click();
							androidLogs.CapturedLogs(pass, "ENTER CODE for " + ev22 + " Button selected");
							Thread.sleep(2000);

							Thread.sleep(3000);
							WebElement WexConnectPromoCodeAddCodeButton = elements.WexConnectPromoCodeAddCodeButton();
							Thread.sleep(3000);
							if (WexConnectPromoCodeAddCodeButton != null
									&& WexConnectPromoCodeAddCodeButton.isEnabled()) {
								WexConnectPromoCodeAddCodeButton.click();
								androidLogs.CapturedLogs(pass, "Add code Button selected");
								Thread.sleep(2000);

								WebElement WexConnectPromoCodeTextBoxEdge20 = elements
										.WexConnectPromoCodeTextBox(edge20);
								Thread.sleep(3000);
								if (WexConnectPromoCodeTextBoxEdge20 != null
										&& WexConnectPromoCodeTextBoxEdge20.isEnabled()) {
									WexConnectPromoCodeTextBoxEdge20.click();
									WexConnectPromoCodeTextBoxEdge20.sendKeys(edge20);
									androidLogs.CapturedLogs(pass, "Promo code " + edge20 + " added to text box");

									Thread.sleep(2000);
									WebElement WexConnectPromoCodeEnterCodeButtonEdge20 = elements
											.WexConnectPromoCodeEnterCodeButton();
									Thread.sleep(3000);
									if (WexConnectPromoCodeEnterCodeButtonEdge20 != null
											&& WexConnectPromoCodeEnterCodeButtonEdge20.isEnabled()) {
										WexConnectPromoCodeEnterCodeButtonEdge20.click();
										androidLogs.CapturedLogs(pass, "ENTER CODE for " + edge20 + " Button selected");
										Thread.sleep(2000);

										Capabilities.driver.navigate().back();
										androidLogs.CapturedLogs(info, "Back Button from add promo screen pressed");

									} else {
										androidLogs.CapturedLogs(info,
												"Promo code " + edge20 + " Text Box is not found");
									}

								} else {
									androidLogs.CapturedLogs(info, "Promo code " + edge20 + " is not found");
								}

							} else {
								androidLogs.CapturedLogs(info, "Add code Button is not found");
							}

						} else {
							androidLogs.CapturedLogs(info, "ENTER CODE for " + ev22 + " is not found");
						}

					} else {
						androidLogs.CapturedLogs(info, "Promo code " + ev22 + " Text Box is not found");
					}

				} else {
					androidLogs.CapturedLogs(info, "Promo codes button is not found");
				}

//				Share
//				click and tap somewhere else on screen 
//					Thread.sleep(3000);

				WebElement WexConnectShareButton = elements.WexConnectShareButton();
				Thread.sleep(3000);
				if (WexConnectShareButton != null && WexConnectShareButton.isEnabled()) {
					WexConnectShareButton.click();
					androidLogs.CapturedLogs(pass, "Share Button is found and pressed");
					Thread.sleep(3000);

					Capabilities.driver.navigate().back();
					androidLogs.CapturedLogs(pass, "Back Button pressed");

				} else {
					androidLogs.CapturedLogs(info, "Share Button button is not found");
				}

//				Terms of use 
//				Open and look for word general then push back (Can't find this its in a WebView) 
//				
				WebElement WexConnectTOUButton = elements.WexConnectTOUButton();
				Thread.sleep(3000);
				if (WexConnectTOUButton != null && WexConnectTOUButton.isEnabled()) {
					WexConnectTOUButton.click();
					androidLogs.CapturedLogs(pass, "Terms of Use is found and pressed");
					Thread.sleep(3000);

					Capabilities.driver.navigate().back();
					androidLogs.CapturedLogs(pass, "Back Button pressed");

				} else {
					androidLogs.CapturedLogs(info, "Share Button button is not found");
				}
//				
//				privacy policy 
//				Open and look for word effective then push back 
//				
				WebElement WexConnectPPButton = elements.WexConnectPPButton();
				Thread.sleep(3000);
				if (WexConnectPPButton != null && WexConnectPPButton.isEnabled()) {
					WexConnectPPButton.click();
					androidLogs.CapturedLogs(pass, "Privacy Policy is found and pressed");
					Thread.sleep(3000);

					Capabilities.driver.navigate().back();
					androidLogs.CapturedLogs(pass, "Back Button pressed");

				} else {
					androidLogs.CapturedLogs(info, "Privacy Policy button is not found");
				}

//				Version 
//				Check version shown in app text and add to test 

			} else {
				androidLogs.CapturedLogs(info, tab + " found and pressed");
			}

//GAS TAB			
			tab = "GAS TAB";
			androidLogs.setupTestYellow(tab);
			Thread.sleep(3000);
			WebElement GasTab = elements.GasTab();
			Thread.sleep(3000);
			if (GasTab != null && GasTab.isEnabled()) {
				GasTab.click();
				androidLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				androidLogs.CapturedLogs(info, tab + " found and pressed");
			}

			Thread.sleep(3000);
			WebElement ClearButtonGasTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonGasTab != null && ClearButtonGasTab.isEnabled()) {
				ClearButtonGasTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyGasTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyGasTab != null && SearchNearbyGasTab.isEnabled()) {
				SearchNearbyGasTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxGasTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxGasTab != null && SearchNearbyTextBoxGasTab.isEnabled()) {
				SearchNearbyTextBoxGasTab.click();
				SearchNearbyTextBoxGasTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationGasTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationGasTab != null && SelectLocationGasTab.isEnabled()) {
				SelectLocationGasTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonGasTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonGasTab != null && MapButtonGasTab.isEnabled()) {
				MapButtonGasTab.click();
				androidLogs.CapturedLogs(pass, "Map Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Map Button found not found");
			}

			Thread.sleep(3000);
			WebElement ClearButtonGasMapTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonGasMapTab != null && ClearButtonGasMapTab.isEnabled()) {
				ClearButtonGasMapTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			loading.MapDirectionsLikeButton();

			Thread.sleep(3000);
			WebElement SearchNearbyGasMapTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyGasMapTab != null && SearchNearbyGasMapTab.isEnabled()) {
				SearchNearbyGasMapTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxGasMapTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxGasMapTab != null && SearchNearbyTextBoxGasMapTab.isEnabled()) {
				SearchNearbyTextBoxGasMapTab.click();
				SearchNearbyTextBoxGasMapTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationGasMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationGasMapTab != null && SelectLocationGasMapTab.isEnabled()) {
				SelectLocationGasMapTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

//TODO do more with the map results latter			
			Thread.sleep(3000);
			androidLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonGasTab = elements.MapButton();
			Thread.sleep(3000);
			if (ListViewButtonGasTab != null && ListViewButtonGasTab.isEnabled()) {
				ListViewButtonGasTab.click();
				androidLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "List View Button not found");
			}

			androidLogs.CapturedLogs(info, tab + " Testing completed");

//Charge tab 
			tab = "Charge TAB";
			androidLogs.setupTestYellow(tab);
			Thread.sleep(3000);
			Thread.sleep(3000);
			WebElement ChargeTab = elements.ChargeTab();
			Thread.sleep(3000);
			if (ChargeTab != null && ChargeTab.isEnabled()) {
				ChargeTab.click();
				androidLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				androidLogs.CapturedLogs(info, tab + " found and pressed");
			}
		
			
			Thread.sleep(3000);
			WebElement evOkButton = elements.evOkButton();
			Thread.sleep(3000);
			if (evOkButton != null && evOkButton.isEnabled()) {
				evOkButton.click();

				androidLogs.CapturedLogs(pass, "EV OK button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "EV OK button not found");
			}
			

			Thread.sleep(3000);
			WebElement ClearButtonChargeListTab = elements.ClearButtonChargeListTab();
			Thread.sleep(3000);
			if (ClearButtonChargeListTab != null && ClearButtonChargeListTab.isEnabled()) {
				ClearButtonChargeListTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyChargeTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyChargeTab != null && SearchNearbyChargeTab.isEnabled()) {
				SearchNearbyChargeTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = dallasTexas;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxChargeTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxChargeTab != null && SearchNearbyTextBoxChargeTab.isEnabled()) {
				SearchNearbyTextBoxChargeTab.click();
				SearchNearbyTextBoxChargeTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationChargeTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationChargeTab != null && SelectLocationChargeTab.isEnabled()) {
				SelectLocationChargeTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonChargeTab = elements.MapChargeButton();
			Thread.sleep(3000);
			if (MapButtonChargeTab != null && MapButtonChargeTab.isEnabled()) {
				MapButtonChargeTab.click();
				androidLogs.CapturedLogs(pass, "Map View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Map View Button not found");
			}

			Thread.sleep(3000);
			WebElement ClearButtonChargeMapTab = elements.ClearButtonChargeListTab();
			Thread.sleep(3000);
			if (ClearButtonChargeMapTab != null && ClearButtonChargeMapTab.isEnabled()) {
				ClearButtonChargeMapTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			loading.MapDirectionsLikeButton();

			Thread.sleep(3000);
			WebElement SearchNearbyChargeMapTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyChargeMapTab != null && SearchNearbyChargeMapTab.isEnabled()) {
				SearchNearbyChargeMapTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxChargeMapTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxChargeMapTab != null && SearchNearbyTextBoxChargeMapTab.isEnabled()) {
				SearchNearbyTextBoxChargeMapTab.click();
				SearchNearbyTextBoxChargeMapTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationChargeMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationChargeMapTab != null && SelectLocationChargeMapTab.isEnabled()) {
				SelectLocationChargeMapTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

//TODO do more with the map results latter			
			Thread.sleep(3000);
			androidLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonChargeTab = elements.MapChargeButton();
			Thread.sleep(3000);
			if (ListViewButtonChargeTab != null && ListViewButtonChargeTab.isEnabled()) {
				ListViewButtonChargeTab.click();
				androidLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "List View Button not found");
			}

			androidLogs.CapturedLogs(info, tab + " Testing completed");

//Service tab 
			tab = "SERVICE TAB";
			androidLogs.setupTestYellow(tab);
			Thread.sleep(3000);
			WebElement ServiceTab = elements.ServiceTab();
			Thread.sleep(3000);
			if (ServiceTab != null && ServiceTab.isEnabled()) {
				ServiceTab.click();
				androidLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				androidLogs.CapturedLogs(info, tab + " found and pressed");
			}

			Thread.sleep(3000);
			WebElement ClearButtonServiceListTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonServiceListTab != null && ClearButtonServiceListTab.isEnabled()) {
				ClearButtonServiceListTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyServiceTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyServiceTab != null && SearchNearbyServiceTab.isEnabled()) {
				SearchNearbyServiceTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxServiceTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxServiceTab != null && SearchNearbyTextBoxServiceTab.isEnabled()) {
				SearchNearbyTextBoxServiceTab.click();
				SearchNearbyTextBoxServiceTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationServiceTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationServiceTab != null && SelectLocationServiceTab.isEnabled()) {
				SelectLocationServiceTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonServiceTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonServiceTab != null && MapButtonServiceTab.isEnabled()) {
				MapButtonServiceTab.click();
				androidLogs.CapturedLogs(pass, "Map View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Map View Button not found");
			}

			Thread.sleep(3000);
			WebElement ClearButtonServiceMapTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonServiceMapTab != null && ClearButtonServiceMapTab.isEnabled()) {
				ClearButtonServiceMapTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			loading.MapDirectionsLikeButton();

			Thread.sleep(3000);
			WebElement SearchNearbyServiceMapTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyServiceMapTab != null && SearchNearbyServiceMapTab.isEnabled()) {
				SearchNearbyServiceMapTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = newYork;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxServiceMapTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxServiceMapTab != null && SearchNearbyTextBoxServiceMapTab.isEnabled()) {
				SearchNearbyTextBoxServiceMapTab.click();
				SearchNearbyTextBoxServiceMapTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationServiceMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationServiceMapTab != null && SelectLocationServiceMapTab.isEnabled()) {
				SelectLocationServiceMapTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

//TODO do more with the map results latter			
			Thread.sleep(3000);
			androidLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonServiceTab = elements.MapButton();
			Thread.sleep(3000);
			if (ListViewButtonServiceTab != null && ListViewButtonServiceTab.isEnabled()) {
				ListViewButtonServiceTab.click();
				androidLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "List View Button not found");
			}

			androidLogs.CapturedLogs(info, tab + " Testing completed");

//Car Wash Tab

//TODO Find a car wash location with car wash only to test with....

			tab = "CARWASH TAB";
			androidLogs.setupTestYellow(tab);
			Thread.sleep(3000);
			WebElement CarWashTab = elements.CarWashTab();
			Thread.sleep(3000);
			if (CarWashTab != null && CarWashTab.isEnabled()) {
				CarWashTab.click();
				androidLogs.CapturedLogs(pass, tab + " found and pressed");
			} else {
				androidLogs.CapturedLogs(info, tab + " found and pressed");
			}

			Thread.sleep(3000);
			WebElement ClearButtonCarWashTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonCarWashTab != null && ClearButtonCarWashTab.isEnabled()) {
				ClearButtonCarWashTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			Thread.sleep(3000);
			WebElement SearchNearbyCarWashTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyCarWashTab != null && SearchNearbyCarWashTab.isEnabled()) {
				SearchNearbyCarWashTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = sanFran;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxCarWashTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxCarWashTab != null && SearchNearbyTextBoxCarWashTab.isEnabled()) {
				SearchNearbyTextBoxCarWashTab.click();
				SearchNearbyTextBoxCarWashTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationCarWashTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationCarWashTab != null && SelectLocationCarWashTab.isEnabled()) {
				SelectLocationCarWashTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

			Thread.sleep(3000);
			// scroll.ScrollUp();
			scroll.ScrollDown();
			scroll.ScrollUp();
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement MapButtonCarWashTab = elements.MapButton();
			Thread.sleep(3000);
			if (MapButtonCarWashTab != null && MapButtonCarWashTab.isEnabled()) {
				MapButtonCarWashTab.click();
				androidLogs.CapturedLogs(pass, "Map Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Map Button found not found");
			}

			Thread.sleep(3000);
			WebElement ClearButtonCarWashMapTab = elements.ClearButtonGasTab();
			Thread.sleep(3000);
			if (ClearButtonCarWashMapTab != null && ClearButtonCarWashMapTab.isEnabled()) {
				ClearButtonCarWashMapTab.click();

				androidLogs.CapturedLogs(pass, "Clear button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "Clear button not found");
			}

			loading.MapDirectionsLikeButton();

			Thread.sleep(3000);
			WebElement SearchNearbyCarWashMapTab = elements.SearchNearby();
			Thread.sleep(3000);
			if (SearchNearbyCarWashMapTab != null && SearchNearbyCarWashMapTab.isEnabled()) {
				SearchNearbyCarWashMapTab.click();

				androidLogs.CapturedLogs(pass, "Search Nearby text box found");
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			// Added a picked location to search with
			pickedLocation = ogdenUtah;

			Thread.sleep(3000);
			WebElement SearchNearbyTextBoxCarWashMapTab = elements.SearchNearbyTextBox(pickedLocation);
			Thread.sleep(3000);
			if (SearchNearbyTextBoxCarWashMapTab != null && SearchNearbyTextBoxCarWashMapTab.isEnabled()) {
				SearchNearbyTextBoxCarWashMapTab.click();
				SearchNearbyTextBoxCarWashMapTab.sendKeys(pickedLocation);
				androidLogs.CapturedLogs(pass, "Search Nearby text box filled in with " + pickedLocation);
			} else {
				androidLogs.CapturedLogs(info, "Service nearby text box not found");
			}

			Thread.sleep(3000);
			WebElement SelectLocationCarWashMapTab = elements.SelectLocation(pickedLocation);
			Thread.sleep(3000);
			if (SelectLocationCarWashMapTab != null && SelectLocationCarWashMapTab.isEnabled()) {
				SelectLocationCarWashMapTab.click();
				androidLogs.CapturedLogs(pass, "Search for " + pickedLocation + " and it was found");
			} else {
				androidLogs.CapturedLogs(info, "Search for " + pickedLocation + " and it was not found");
			}

//TODO do more with the map results latter			
			Thread.sleep(3000);
			androidLogs.CapturedLogs(pass, "Map results Displayed");
			Thread.sleep(3000);

			Thread.sleep(3000);
			WebElement ListViewButtonCarWashTab = elements.MapButton();
			Thread.sleep(3000);
			if (ListViewButtonCarWashTab != null && ListViewButtonCarWashTab.isEnabled()) {
				ListViewButtonCarWashTab.click();
				androidLogs.CapturedLogs(pass, "List View Button found and selected");
			} else {
				androidLogs.CapturedLogs(info, "List View Button not found");
			}

			androidLogs.CapturedLogs(info, tab + " Testing completed");

			Thread.sleep(5000);

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(info, "Wex Connect open and close app Completed");

		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);
			} else {
				System.out.println("Error is: " + errorMessage);
			}
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				androidLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}