package sourceCode;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	File file;
	FileInputStream fis;
	XSSFWorkbook wrkBook;
	XSSFSheet moduleSheet, testCaseSheet, testStepsSheet;
	int modSheetRowCount, modSheetColumnCount, tcSheetRowCount, tcSheetColumnCount, tsSheetRowCount, tsSheetColumnCount;
	String testCaseId, testStepId, keyword, testData1, flag;

	DataFormatter formater = new DataFormatter();

	public Map<String, List<String>> readDataFromExcel(String propFilePath, String moduleSheetName, String tcSheetName,
			String tsSheetName) throws Exception {

		file = new File(propFilePath);
		fis = new FileInputStream(file);

		wrkBook = new XSSFWorkbook(fis);
		moduleSheet = wrkBook.getSheet(moduleSheetName);
		modSheetRowCount = moduleSheet.getLastRowNum();
		modSheetColumnCount = moduleSheet.getRow(0).getLastCellNum();
		List<String> keywords = new ArrayList<String>();
		List<String> testData = new ArrayList<String>();
		Map<String, List<String>> keyWordsAndTestData = new HashMap<String, List<String>>();

		for (int i = 1; i < modSheetRowCount; i++) {
			Row moduleRow = moduleSheet.getRow(i);
			Cell moduleExecFlag = moduleRow.getCell(3);
			if (moduleExecFlag != null) {
				flag = moduleRow.getCell(3).getStringCellValue();
			} else
				continue;

			if (flag.equalsIgnoreCase("Y")) {
				String modSheetModuleName = moduleRow.getCell(0).getStringCellValue();

				System.out.println(modSheetModuleName);

				testCaseSheet = wrkBook.getSheet(tcSheetName);

				tcSheetRowCount = testCaseSheet.getLastRowNum();

				tcSheetColumnCount = testCaseSheet.getRow(0).getLastCellNum();

				for (int j = 1; j < tcSheetRowCount; j++) {
					Row testCaseIdRow = testCaseSheet.getRow(j);

					Cell testCaseExecFlag = testCaseIdRow.getCell(3);

					if (testCaseExecFlag != null) {
						flag = testCaseIdRow.getCell(3).getStringCellValue();
					} else
						continue;

					String testCaseSheetModuleName = testCaseIdRow.getCell(0).getStringCellValue();

					if (flag.equalsIgnoreCase("Y") && testCaseSheetModuleName.equalsIgnoreCase(modSheetModuleName)) {
						Cell testCaseIdFlag = testCaseIdRow.getCell(1);
						if (testCaseIdFlag != null) {
							testCaseId = testCaseIdRow.getCell(1).getStringCellValue();
//							System.out.println(testCaseId);
						} else
							continue;

						testStepsSheet = wrkBook.getSheet(tsSheetName);

						Iterator<Row> rowIterator = testStepsSheet.iterator();

						while (rowIterator.hasNext()) {
							Row row = rowIterator.next();
							// For each row, iterate through all the columns
							Iterator<Cell> cellIterator = row.cellIterator();
							while (cellIterator.hasNext()) {
								if (cellIterator.next().toString().equalsIgnoreCase(testCaseId)) {
									Cell cell2 = cellIterator.next();
									if (cell2.getCellType() == Cell.CELL_TYPE_STRING) {
										keyword = cell2.getStringCellValue();
										keywords.add(keyword);
									}
									Cell cell3 = cellIterator.next();
									if (cell3.getCellType() == Cell.CELL_TYPE_NUMERIC) {
										testData1 = formater.formatCellValue(cell3);
										testData.add(testData1);
									} else if (cell3.getCellType() == Cell.CELL_TYPE_STRING) {
										testData1 = cell3.getStringCellValue();
										testData.add(testData1);
									}
								}
							}
						}

					}

				}
			}

		}

		keyWordsAndTestData.put("Keywords", keywords);
		keyWordsAndTestData.put("TestData", testData);
		return keyWordsAndTestData;
	}

	
}
