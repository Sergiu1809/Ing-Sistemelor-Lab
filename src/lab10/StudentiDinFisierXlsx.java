package lab10;

import lab1.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // sarim peste header

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
}
