package bddPractises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	private static final String String = null;
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public@FindBy(how = How.NAME, using = "givenName") WebElement Name;
	public@FindBy(how = How.NAME, using = "familyName") WebElement familyName;
	public@FindBy(how = How.ID, using = "genderLabel")	WebElement genderLabel;
	public@FindBy(how = How.ID, using = "gender-field")	WebElement genderfield;
	public@FindBy(how = How.ID, using = "birthdateLabel") WebElement birthdateLabel;
	public@FindBy(how = How.ID, using = "birthdateDay-field") WebElement birthdateDayfield;
	public@FindBy(how = How.ID, using = "birthdateMonth-field") WebElement birthdateMonthfield;
	public@FindBy(how = How.ID, using = "birthdateYear-field") WebElement birthdateYearfield;
	public@FindBy(how = How.XPATH, using = "//span[text()='Address']") WebElement clickaddress;
	public@FindBy(how = How.ID, using = "address1")	WebElement address;
	public@FindBy(how = How.ID, using = "confirmation_label") WebElement confirmation_label;
	public@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Logout") WebElement Logout;

	
	public void setName(String name) {
		Name.sendKeys(name);
	}

	public void setFamilyName(String familyname) {
		familyName.sendKeys(familyname);
	}

	public void selectGender(String gender) {
		genderLabel.click();
		WebElement lstGender = genderfield;
		Select select = new Select(lstGender);
		select.selectByVisibleText(gender);
	}

	public void setBirthLabel(String date, String month, String year) {
		birthdateLabel.click();
		birthdateDayfield.sendKeys(date);
		WebElement lstMonth = birthdateMonthfield;
		Select select = new Select(lstMonth);
		select = new Select(lstMonth);
		select.selectByVisibleText(month);

		birthdateYearfield.sendKeys(year);
	}

	public void setAdress(String state) {
		clickaddress.click();
		address.sendKeys(state);
	}

	public void clickConfirmation() {
		confirmation_label.click();
	}

	public void clickOnLogOut() {
		WebElement element = Logout;
		Actions actions = new Actions(driver);
		actions.click(element).perform();

	}

	
	}
