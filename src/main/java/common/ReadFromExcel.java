package common;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ReadFromExcel {
    XSSFWorkbook wb = null;
    //HSSFSheet sheet = null;
    XSSFSheet sheet = null;
    Cell cell = null;
    FileOutputStream fio = null;
    int numberOfRows, numberOfCol, rowNum;

    public static String ReadFromExcelFile(String filePath, int sheetIndex) {
        //  String filePath = "../LearnJava_QE_SUMMER2022/DataTest/TestData.xlsx";
        Workbook workbook;
        FileInputStream inputStream;
        Cell currentCell;
        String cellValue = null;

        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            Sheet dataTypeSheet = workbook.getSheetAt(sheetIndex);

            Iterator<Row> rowIterator = dataTypeSheet.iterator();
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    currentCell = cellIterator.next();
                    cellValue = currentCell.getStringCellValue();
                    //  System.out.println("Values: " + currentCell.getStringCellValue());
                }
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found Exception " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException Exception " + e.getMessage());
        }

        return cellValue;
    }


    public  String[]  readFromExcelColumn(String path, int sheetIndex) throws IOException {
        String[] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        // wb = new HSSFWorkbook(fis);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(sheetIndex);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1];

        for (int i = 1; i < data.length; i++) {
            XSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                XSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }


    public String getCellValue(XSSFCell cell) {
        Object value = null;

        CellType dataType = cell.getCellType();
        switch (dataType) {
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();
    }

//    public  String [][] readFromExcelColumn1(String path, int sheetIndex) throws IOException {
//        DataFormatter formatter=new DataFormatter();
//        File file = new File(path);
//        FileInputStream fis = new FileInputStream(file);
//        // wb = new HSSFWorkbook(fis);
//        wb = new XSSFWorkbook(fis);
//        sheet = wb.getSheetAt(sheetIndex);
//        //wb.getSheet()
//        numberOfRows = sheet.getPhysicalNumberOfRows();
//        XSSFRow rows = sheet.getRow(0);
//        numberOfCol =rows.getLastCellNum();
//        String [][]data = new String[numberOfRows-1][numberOfCol];
//
//        for (int i = 1; i < numberOfRows -1; i++) {
//            rows = sheet.getRow(i+1);
//            //rows = sheet.getRow(i);
//            for (int j = 0; j < numberOfCol; j++) {
//                XSSFCell cell = rows.getCell(j);
//                data [i][j]= formatter.formatCellValue(cell);
//
//            }
//        }
//        return data;
//    }


    public  static String [][] readFromExcelSheet(String path, int sheetIndex) throws IOException {
        DataFormatter formatter=new DataFormatter();
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        // wb = new HSSFWorkbook(fis);
        Workbook wb1 = new XSSFWorkbook(fis);
        // Sheet sheet1= wb1.getSheetAt(sheetIndex);
        // XSSFSheet sheet1= wb1.getSheetAt(sheetIndex);
        XSSFSheet sheet1= (XSSFSheet) wb1.getSheetAt(sheetIndex);
        int rows = sheet1.getLastRowNum();
        int cols =sheet1.getRow(0).getLastCellNum();
        String [][]data = new String[rows][cols];

        for (int r = 0; r <rows; r++) {
            XSSFRow row = sheet1.getRow(r+1);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                data [r][c]= formatter.formatCellValue(cell);

            }
        }
        return data;
    }



}
