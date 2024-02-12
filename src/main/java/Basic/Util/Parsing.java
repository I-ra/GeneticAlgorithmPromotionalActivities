package Basic.Util;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Parsing {
    private ArrayList<Double> listTime = new ArrayList<>();
    private ArrayList<Double> listLoad = new ArrayList<>();
    private ArrayList<Double> listGeneration = new ArrayList<>();
    private ArrayList<Double> listPrice = new ArrayList<>();

    public Parsing() {
        try {
            FileInputStream exl = new FileInputStream(new File("D:\\java\\data.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(exl);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0){
                    exl.close();
                    continue;
                } else {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getColumnIndex()) {
                            case (0):
                                listTime.add(cell.getNumericCellValue());
                                break;
                            case (1):
                                listLoad.add(cell.getNumericCellValue());
                                break;
                            case (2):
                                listGeneration.add(cell.getNumericCellValue());
                                break;
                            case (3):
                                listPrice.add(cell.getNumericCellValue());
                                break;
                        }
                    }
                    exl.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }


    public Double[] getArrayTime() {
        Double[] array = listTime.toArray(new Double[0]);
        return array;
    }

    public Double[] getArrayLoad() {
        Double[] array = listLoad.toArray(new Double[0]);
        return array;
    }

    public Double[] getArrayGeneration() {
        Double[] array = listGeneration.toArray(new Double[0]);
        return array;
    }

    public Double[] getArrayPrice() {
        Double[] array = listPrice.toArray(new Double[0]);
        return array;
    }

    public void write(OneIndividium best) {
        Workbook workbook = new XSSFWorkbook();
        Sheet newSheet = workbook.createSheet("Result");


        for (int i = 0; i < best.action.length+1; i++) {
            Row row = newSheet.createRow(i);
            if (i == 0){
                Cell header = row.createCell(0);
                header.setCellValue("Result");
            } else {
                i--;
                row.createCell(0).setCellValue(best.action[i]);
                i++;
            }

        }

        try {
            FileOutputStream exl = new FileOutputStream(new File("D:\\java\\result.xlsx"));
            workbook.write(exl);
            exl.close();
            System.out.println("Результат успешно записан!");
        } catch (Exception e){
            System.out.println("При записи результата что-то пошло не так, результат не был записан!");
        }

    }
}
