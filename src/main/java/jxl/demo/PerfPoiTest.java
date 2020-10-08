package jxl.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

/**
 * @author vincent
 * @date 2020/10/8
 */
@Slf4j
public class PerfPoiTest {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        File file = new File("/Users/vincent/Codes/Java/workspace/Study/src/main/resources/misc/test.xls");
        log.info("start");
        Workbook sheets = WorkbookFactory.create(file);
        log.info("sheets loaded");
        for(int i=2; i<sheets.getNumberOfSheets(); i++) {
            Sheet sheet = sheets.getSheetAt(i);
            for (int j = 5; j <= sheet.getLastRowNum() - 2; j++) {
                Row row = sheet.getRow(j);
                getColumnStringValue(row, 0);
                getColumnStringValue(row, 2);
                getColumnStringValue(row, 3);
                getColumnStringValue(row, 4);
                getColumnStringValue(row, 5);
                getColumnStringValue(row, 6);
                getColumnStringValue(row, 7);
            }
        }
        log.info("sheets readed");
    }

    private static String getColumnStringValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            Double d = cell.getNumericCellValue();
            return String.valueOf(d.doubleValue());
        } else {
            return cell.getStringCellValue();
        }
    }
}
