package lab8;

import lab1.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AppLab8Studenti {

    // 8.5.4 a)
    public static void writeToXls(Set<Student> studenti, String numeFisier) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");


            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nr. Matricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");


            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }

            try (FileOutputStream fos = new FileOutputStream(numeFisier)) {
                workbook.write(fos);
            }

            System.out.println("Studenti salvati in: " + numeFisier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.4 b)
    public static List<Student> readFromXls(String numeFisier) {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(numeFisier);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // sare peste header

                int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume    = row.getCell(1).getStringCellValue();
                String nume       = row.getCell(2).getStringCellValue();
                String formatie   = row.getCell(3).getStringCellValue();
                double nota       = row.getCell(4).getNumericCellValue();

                studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }

    public static void main(String[] args) {
        java.util.Set<Student> studenti = new java.util.HashSet<>();
        studenti.add(new Student(1024, "Ioan",     "Mihalcea", "TI211", 9.80));
        studenti.add(new Student(1025, "Andrei",   "Popa",     "TI211", 8.70));
        studenti.add(new Student(1026, "Anamaria", "Prodan",   "TI211", 8.90));
        studenti.add(new Student(1027, "Paul",     "Mohanu",   "TI211", 5.40));
        studenti.add(new Student(1028, "Mihai",    "Ionescu",  "TI211", 6.20));
        studenti.add(new Student(1029, "Bianca",   "Popescu",  "TI211", 9.10));

        // 8.5.4 a)
        String xlsFileName = "src/lab8/laborator8_students.xlsx";
        writeToXls(studenti, xlsFileName);

        // 8.5.4 b)
        List<Student> studentsFromXls = readFromXls(xlsFileName);
        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }
}
