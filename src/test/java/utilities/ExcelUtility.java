package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static String getData(int row, int cell) throws IOException {

        FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        String data = sheet.getRow(row).getCell(cell).getStringCellValue();

        workbook.close();

        return data;
    }
}
