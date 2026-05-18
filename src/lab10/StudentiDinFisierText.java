package lab10;

import lab1.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport{

    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                // formatul din toString(): "Nr. Matricol: X, Nume: Y, Prenume: Z, Formatie de studiu: W, Nota: N"
                String[] parts = linie.split(", ");
                int numarMatricol = Integer.parseInt(parts[0].split(": ")[1]);
                String nume       = parts[1].split(": ")[1];
                String prenume    = parts[2].split(": ")[1];
                String formatie   = parts[3].split(": ")[1];
                double nota       = Double.parseDouble(parts[4].split(": ")[1]);

                studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }
}
