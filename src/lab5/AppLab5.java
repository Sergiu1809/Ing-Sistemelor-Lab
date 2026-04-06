package lab5;

import lab1.Student;
import lab1.StudentBursier;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AppLab5 {
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).sub(3).multiply(2).result();
        System.out.println("a) " + result);

        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        int result2 = advancedCalculator.divide(4).power(2).root(2).result();
        System.out.println("b) " + result2);

        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        writeToFile("src/lab5/bursieri_out.txt", bursieri);
    }

    public static void writeToFile(String filename, List<StudentBursier> studenti) {
        List<String> lines = new ArrayList<>();
        for (Student s : studenti) {
            lines.add(s.toString());
            try {
                Files.write(Paths.get(filename), lines);
            } catch (Exception e) {
                System.out.println("Eroare la scriere");
            }
        }
    }
}