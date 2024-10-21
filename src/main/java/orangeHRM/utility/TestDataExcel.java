package orangeHRM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import orangeHRM.constant.Constants;

public class TestDataExcel {

	public static String excelUtility(int rowNumber, int cellNumber) throws EncryptedDocumentException, IOException {

		File file = new File(Constants.PATH_EXCEL);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheetAt(0);
		return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}

}
