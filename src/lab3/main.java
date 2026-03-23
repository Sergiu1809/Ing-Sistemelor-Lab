package lab3;

import lab1.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("src/lab3/in.txt");
        List<String> lines = Files.readAllLines(inPath);

        // Problema 3.5.1
        //a)

        List<String> listA = new ArrayList<>();
        for(String line: lines){
            String modified = line + "\n";
            listA.add(modified);
        }
        System.out.println("Rezultat a): ");
        for(String line: listA){
            System.out.println(line);
        }

        //b
        List<String> listB = new ArrayList<>();
        for(String line : lines){
            String modified = line.replace(". ", ".\n").replace(".", ".\n");
            listB.add(modified);
        }
        System.out.println("Rezultat b): ");
        for(String line: listB){
            System.out.println(line);
        }

        //c
        Path outPath = Paths.get("src/lab3/out.txt");

        List<String> output1 = new ArrayList<>();
        output1.addAll(listA);
        output1.addAll(listB);

        Files.write(outPath, output1);

        //Problema 3.5.2
        Path inPath2 = Paths.get("src/lab1/studenti_in.txt");
        List<String> lines2 = Files.readAllLines(inPath2);

        List<Student> studenti = new ArrayList<>();
        for(String line: lines2) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String prenume = parts[1];
            String nume = parts[2];
            String formatie = parts[3];
            studenti.add(new Student(id, prenume, nume, formatie));
        }

        for(Student s: studenti){
            System.out.println(s);
        }

        studenti.sort(Comparator.comparing((Student s) -> s.getNume()));

        Path outPath2 = Paths.get("src/lab1/studenti_out.txt");
        List<String> output2 = new ArrayList<>();
        for(Student s: studenti){
            output2.add(s.toString());
        }

        Files.write(outPath2, output2);

        //Tema Problema 3.5.3
        studenti.sort(
                Comparator.comparing((Student s) -> s.getFormatieDeStudiu())
                        .thenComparing((Student s) -> s.getNume())
        );

        for (Student s : studenti) {
            System.out.println(s);
        }

        Path outPath3 = Paths.get("src/lab1/studenti_out_sorted.txt");
        List<String> output3 = new ArrayList<>();
        for(Student s: studenti){
            output3.add(s.toString());
        }
        Files.write(outPath3, output3);
    }
}

