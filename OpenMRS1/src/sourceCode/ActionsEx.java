package sourceCode;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsEx {

	WebDriver driver;
	LoginPage logpage;
	HomePage homepage;
	RegistrationPage regpage;
	Screenshots screenshort;

	public ActionsEx(WebDriver driver) {
		this.driver = driver;
		this.logpage = new LoginPage(driver);
		this.homepage = new HomePage(driver);
		this.regpage = new RegistrationPage(driver);
		this.screenshort = new Screenshots();
	}

	public void setUsername(String admin) {
		logpage.username.sendKeys(admin);
	}

	public void setPassword(String passwrd) {
		logpage.password.sendKeys(passwrd);
	}

	public void clickRegistration() {
		logpage.RegistrationDesk.click();
	}

	public void clickLogin() {
		logpage.loginButton.click();
	}

	public void clickReg() {
		homepage.regPatient.click();
	}

	public void setName(String name) {
		regpage.Name.sendKeys(name);
	}

	public void setFamilyName(String familyname) {
		regpage.familyName.sendKeys(familyname);
	}

	public void selectGender(String gender) {
		regpage.genderLabel.click();
		WebElement lstGender = regpage.genderfield;
		Select select = new Select(lstGender);
		select.selectByVisibleText(gender);
	}

	public void setBirthLabel(String date, String month, String year) {
		regpage.birthdateLabel.click();
		regpage.birthdateDayfield.sendKeys(date);
		WebElement lstMonth = regpage.birthdateMonthfield;
		Select select = new Select(lstMonth);
		select = new Select(lstMonth);
		select.selectByVisibleText(month);

		regpage.birthdateYearfield.sendKeys(year);
	}

	public void setAdress(String state) {
		regpage.clickaddress.click();
		regpage.address.sendKeys(state);
	}

	public void clickConfirmation() {
		regpage.confirmation_label.click();
	}

	public void clickOnLogOut() {
		WebElement element = regpage.Logout;
		Actions actions = new Actions(driver);
		actions.click(element).perform();

	}
	public void takeScreenshot(WebDriver driver) throws IOException {
		String folderPath = "D:/Bala Jelenium/OpenMRS/Screenshots/";

		Date dt = new Date();

		SimpleDateFormat simplDate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String timestamp = simplDate.format(dt).replace(" ", "").replace(":", "_");

		String filePath = folderPath + timestamp + ".jpg";

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File file1 = screenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(filePath);

		FileUtils.copyFile(file1, destFile);
	}


}
