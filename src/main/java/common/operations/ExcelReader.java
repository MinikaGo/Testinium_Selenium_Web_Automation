package common.operations;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {

    private static Sheet sh;
    private static Workbook workBook;

    static {
        //System.getProperty("user.dir")
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/BeymenTestData.xls";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            workBook = WorkbookFactory.create(fis);
            sh = workBook.getSheet("TestData");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getCellValue(int column) {

        Iterator<Row> rows = sh.rowIterator();
        String value = null;
        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Cell cell = currentRow.getCell(column);
            value = (cell == null ? null : cell.getStringCellValue());
            // use value here
        }
        return value;
    }
}
