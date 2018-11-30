package com.telesens.academy.tests.loginform;

import com.telesens.academy.lesson16.PropertyDemo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderExcel {

    private File file = new File(PropertyDemo.readProperty("loginFile"));
//    public static String[][] readFromXL(String firstName, String secondName, String address, String city, String state, int zipCode, String country, int homePhone, int mobilePhone, String addressAlias){


    public static void main(String[] args) {
        ReaderExcel readerExcel = new ReaderExcel();
        readerExcel.getDataExcel("sheet1");
    }

    public void readExcel(String sheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = workbook.getSheet(sheetName);
        for (int r = 0; r < sheet.getLastRowNum() + 1; r++) {
            StringBuilder data = new StringBuilder();
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < row.getLastCellNum(); c++) {
                data.append(row.getCell(c).getStringCellValue());
                data.append(" ");
            }
            System.out.println("\t" + data);
        }
        workbook.close();
    }

    public void getDataExcel(String sheet) {
        System.out.println(String.format("\nДанные из таблицы: %s", sheet));
        try {
            readExcel(sheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
