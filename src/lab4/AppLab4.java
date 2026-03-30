package lab4;
import lab1.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppLab4 {

    public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> studenti) {
        HashMap<String, Student> byName = new HashMap<>();
        for (Student s : studenti.values()) {
            String key = s.getPrenume() + "-" + s.getNume();
            byName.put(key, s);
        }

        String cautareKey = prenume + "-" + nume;
        Student found = byName.get(cautareKey);

        if (found == null) return 0.0f;
        return found.getNota();
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

        //a
        System.out.println("Afisare initiala");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("\nAfisare dupa adaugare");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //c
        HashMap<String, Tanar> tineri = new HashMap<>();

        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String name = entry.getKey();
            int age = entry.getValue();
            String address = adrese.getOrDefault(name, "Necunoscuta");
            tineri.put(name, new Tanar(name, age, address));
        }

        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        Path studentiPath = Paths.get("src/lab1/studenti_in.txt");
        List<String> studentiLines = Files.readAllLines(studentiPath);

        HashMap<Integer, Student> studenti = new HashMap<>();
        for (String line : studentiLines) {
            String[] parts = line.split(",");
            int numarMatricol = Integer.parseInt(parts[0]);
            String prenume = parts[1];
            String nume = parts[2];
            String formatie = parts[3];

            Student s = new Student(numarMatricol, prenume, nume, formatie);
            studenti.put(numarMatricol, s);
        }

        Path notePath = Paths.get("src/lab4/note_anon.txt");
        List<String> noteLines = Files.readAllLines(notePath);

        for (String line : noteLines) {
            String[] parts = line.split(",");
            int numarMatricol = Integer.parseInt(parts[0]);
            float nota = Float.parseFloat(parts[1]);

            Student s = studenti.get(numarMatricol);
            if (s != null) {
                s.setNota(nota);
            }
        }

        System.out.println("Studenti cu note");
        for (Student s : studenti.values()) {
            System.out.println(s);
        }


        float notaM = gasesteNota("Bianca", "Popescu", studenti);
        float notaN = gasesteNota("Ioan", "Popa", studenti);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);
    }
}
