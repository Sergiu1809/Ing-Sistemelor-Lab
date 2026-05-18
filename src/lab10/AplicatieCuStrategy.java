package lab10;

import lab1.Student;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",     "ISM141/2", 8.70),
                new Student(1024, "Ioan",     "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan",   "TI131/1",  8.90),
                new Student(1029, "Bianca",   "Popescu",  "TI131/1",  10),
                new Student(1029, "Maria",    "Pana",     "TI131/2",  4.10),
                new Student(1029, "Gabriela", "Mohanu",   "TI131/2",  7.33),
                new Student(1029, "Marius",   "Nasta",    "TI131/2",  3.20),
                new Student(1029, "Marius",   "Nasta",    "TI131/1",  5.12),
                new Student(1029, "Andrei",   "Dobrescu", "TI131/2",  2.22)
        );

        Exporter exporter = new Exporter();

        // a) Export in consola
        exporter.startExport(new StudentiInConsola(), studenti);

        // b) Export in fisier txt
        exporter.startExport(new StudentiInFisierText("src/lab10/studentiStrategyText.txt"), studenti);

        // c) Export in fisier xlsx
        exporter.startExport(new StudentiInFisierXlsx("src/lab10/studentiStrategyExcel.xlsx"), studenti);

        // d) Import din fisier txt
        StudentiDinFisierText importText = new StudentiDinFisierText("src/lab10/studentiStrategyText.txt");
        List<Student> dinText = importText.doImport();
        System.out.println("\nStudenti cititi din txt:");
        dinText.forEach(s -> System.out.println(s));

        // e) Import din fisier xlsx
        StudentiDinFisierXlsx importXlsx = new StudentiDinFisierXlsx("src/lab10/studentiStrategyExcel.xlsx");
        List<Student> dinXlsx = importXlsx.doImport();
        System.out.println("\nStudenti cititi din xlsx:");
        dinXlsx.forEach(s -> System.out.println(s));
    }
}