package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test

    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/ULKELER.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);

        // ULKELER BASKENTLER NEYI MESHUR NUFUS
        // 0. indexteki satirin, 3. indexteki hucresine NUFUS hucresi ekleyelim

        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80M");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10M");

        // 0. indexteki satirin, 1. indexindeki hucreyi silelim (BASKENTLER)
        Cell silmekIstedigimizHucre = workbook.getSheetAt(0).getRow(0).getCell(1);
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstedigimizHucre);

        workbook.write(fileOutputStream);







        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }
}
