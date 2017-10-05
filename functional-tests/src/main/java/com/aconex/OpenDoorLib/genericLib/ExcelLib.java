package com.aconex.OpenDoorLib.genericLib;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelLib {
    public static final String TEST_DATA_FILE_PATH = "TestData" + File.separator + "TestData.xlsx";


    public String getExcelData(String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(TEST_DATA_FILE_PATH);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        String data = row.getCell(colNum).getStringCellValue();

        return data;
    }


    public int getRowCount(String sheetName) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(TEST_DATA_FILE_PATH);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        return sh.getLastRowNum()+1;

    }

    public void setExceData(String sheetName,int rowNum,int colNum,String data) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(TEST_DATA_FILE_PATH);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        Cell cel = row.createCell(colNum);
        cel.setCellType(cel.CELL_TYPE_STRING);
        FileOutputStream fos = new FileOutputStream(TEST_DATA_FILE_PATH);
        cel.setCellValue(data);
        wb.write(fos);

    }





}
