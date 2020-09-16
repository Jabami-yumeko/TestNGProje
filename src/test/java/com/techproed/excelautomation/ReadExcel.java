package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test1() throws IOException {

        String dosyaYolu = "src/test/resources/ULKELER.xlsx";
        // Java da bir dosyayi acmak icin kullanilir.
        // Parametre bolumunde acmak istedigimiz dosyanin adresi yazilir
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        //Workbook (excel) dosyasini okumaya basladik/
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 1. sayfaya gider (index degeri 0 dan baslar)
        Sheet sheet       = workbook.getSheetAt(0);

        //1. satira gidelim
        Row row           = sheet.getRow(0);

        // indexe gore hucrelere gidelim
        Cell ulkeler      =row.getCell(0);
        Cell baskentler   =row.getCell(1);
        Cell meshurlar    =row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        int satirSayisi = workbook.getSheetAt(0).getLastRowNum()+1;
        System.out.println("Satir sayisi : " + satirSayisi);

        // bu direk satir sayisini verir (index 1 den baslar)
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu satir sayisi : " + doluSatirSayisi);

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();

        System.out.println("-------------------------------------------------");
        // tum ulkeleri yazdirma
        for (int  i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        System.out.println("--------------------------------------------------");
        // tum baskentleri yazdirma
        for (int  i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }

        // bir satirin son sutunun indexini alma
        // 1 den basliyor
        System.out.println("-----------------------------------------------------");

        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son sutun index : " + sonSutunIndex);

        for (int i = 0 ; i <sonSutunIndex ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(i));
        }






    }




}
