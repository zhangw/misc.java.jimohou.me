package jxl.demo;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author vincent
 * @date 2020/10/8
 */
@Slf4j
public class PerfTest {
    public static void main(String[] args) throws IOException, BiffException {
        File file = new File("/Users/vincent/Codes/Java/workspace/Study/src/main/resources/misc/test.xls");
        log.info("start");
        jxl.Workbook sheets = jxl.Workbook.getWorkbook(file);
        log.info("sheets loaded");
        for(int i=2; i<sheets.getNumberOfSheets(); i++) {
            // test jxl.nogc flag
            Sheet sheet = sheets.getSheet(i);
            for (int j = 5; j <= sheet.getRows() - 3; j++) {
                Cell[] row = sheet.getRow(j);
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

    private static String getColumnStringValue(Cell[] row, int columnIndex) {
        Cell cell = row[columnIndex];
        if (cell == null) {
            return "";
        }
        if(CellType.NUMBER.equals(cell.getType())){
            double v = ((NumberCell)cell).getValue();
            return String.valueOf(v);
        }else{
            return cell.getContents();
        }
    }
}
