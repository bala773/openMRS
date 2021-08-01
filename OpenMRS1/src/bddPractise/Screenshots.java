package bddPractise;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		String folderPath = "C:\\Users\\Bala\\git\\openMRS\\OpenMRS1\\Screenshots/";

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
