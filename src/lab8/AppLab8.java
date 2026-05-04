package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppLab8 {

    public static void scrieOutput3(String inputFisier, String outputFisier) {
        try (FileInputStream fis = new FileInputStream(inputFisier);
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet();

            for (Row rowIn : sheetIn) {
                Row rowOut = sheetOut.createRow(rowIn.getRowNum());


                for (Cell cellIn : rowIn) {
                    Cell cellOut = rowOut.createCell(cellIn.getColumnIndex());
                    if (cellIn.getCellType() == CellType.NUMERIC) {
                        cellOut.setCellValue(cellIn.getNumericCellValue());
                    } else if (cellIn.getCellType() == CellType.STRING) {
                        cellOut.setCellValue(cellIn.getStringCellValue());
                    }
                }


                if (rowIn.getRowNum() > 0) {
                    int excelRow = rowIn.getRowNum() + 1; // Excel incepe de la 1
                    String formula = "AVERAGE(D" + excelRow + ":F" + excelRow + ")";
                    rowOut.createCell(6).setCellFormula(formula);
                } else {
                    rowOut.createCell(6).setCellValue("Medie");
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFisier)) {
                workbookOut.write(fos);
            }

            System.out.println("Fisier generat: " + outputFisier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scrieOutput2(String inputFisier, String outputFisier) {
        try (FileInputStream fis = new FileInputStream(inputFisier);
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet();

            for (Row rowIn : sheetIn) {
                Row rowOut = sheetOut.createRow(rowIn.getRowNum());


                for (Cell cellIn : rowIn) {
                    Cell cellOut = rowOut.createCell(cellIn.getColumnIndex());
                    if (cellIn.getCellType() == CellType.NUMERIC) {
                        cellOut.setCellValue(cellIn.getNumericCellValue());
                    } else if (cellIn.getCellType() == CellType.STRING) {
                        cellOut.setCellValue(cellIn.getStringCellValue());
                    }
                }


                if (rowIn.getRowNum() > 0) {
                    double nota1 = rowIn.getCell(3).getNumericCellValue();
                    double nota2 = rowIn.getCell(4).getNumericCellValue();
                    double nota3 = rowIn.getCell(5).getNumericCellValue();
                    double medie = (nota1 + nota2 + nota3) / 3;
                    rowOut.createCell(6).setCellValue(medie);
                } else {
                    rowOut.createCell(6).setCellValue("Medie");
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFisier)) {
                workbookOut.write(fos);
            }

            System.out.println("Fisier generat: " + outputFisier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void citesteFisier(String numeFisier) {
        try (FileInputStream fis = new FileInputStream(numeFisier);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        default:
                            System.out.print("?\t");
                            break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        citesteFisier("src/lab8/laborator8_input.xlsx");
        scrieOutput2("src/lab8/laborator8_input.xlsx", "src/lab8/laborator8_output2.xlsx");
        scrieOutput3("src/lab8/laborator8_input.xlsx", "src/lab8/laborator8_output3.xlsx");
    }
}
