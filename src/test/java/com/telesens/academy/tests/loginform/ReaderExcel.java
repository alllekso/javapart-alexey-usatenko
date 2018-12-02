package com.telesens.academy.tests.loginform;

import com.telesens.academy.lesson16.PropertyDemo;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReaderExcel {
    private static final int COUNT_COLUMNS = 0;
    public static void main(String[] args) {
        File file = new File(PropertyDemo.readProperty("loginFile"));

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            XSSFRow row = sheet.getRow(r);
                String firstName = row.getCell(0).getStringCellValue();
                String secondName = row.getCell(1).getStringCellValue();
                String address = row.getCell(2).getStringCellValue();
                String city = row.getCell(3).getStringCellValue();
                String region = row.getCell(4).getStringCellValue();
                int zip = (int) row.getCell(5).getNumericCellValue();
                String state = row.getCell(6).getStringCellValue();
                int mobilePhone = (int) row.getCell(7).getNumericCellValue();
                int phone = (int) row.getCell(7).getNumericCellValue();
                String addressRef = row.getCell(9).getStringCellValue();
                System.out.printf("%s | %s | %s| %s | %s | %d | %s | %d | %d | %s \n", firstName, secondName, address, city, region, zip, state, mobilePhone, phone, addressRef);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//Kolya	Ivanov	Petrovskogo st. 35	Kharkov	Alaska	61033	United States	3,80935E+12	93234567	addressAddedRef