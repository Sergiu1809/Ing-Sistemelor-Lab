package lab9;

import lab1.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppLab9 {
    public static void main(String[] args) {

        // Ex9.3.1
        Random random = new Random();

        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());


        System.out.println("Lista initiala: " + numere);

        int suma = numere.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("\na) Suma: " + suma);


        int max = numere.stream()
                .max(Comparator.naturalOrder())
                .get();
        int min = numere.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println("b) Max: " + max + ", Min: " + min);

        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Elemente in [10..20]: " + filtrate);

        List<Double> doubles = numere.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("d) Lista de Double: " + doubles);

        boolean contine12 = numere.stream()
                .anyMatch(n -> n == 12);
        System.out.println("e) Contine valoarea 12: " + contine12);

        //Ex 9.3.2

        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        List<String> cuvinteLungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("\na) Cuvinte cu lungime >= 5: " + cuvinteLungi);

        List<String> cuvinteSortate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("b) Sortate: " + cuvinteSortate);

        Optional<String> cuvantp = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst();
        if (cuvantp.isPresent()) {
            System.out.println("c) Primul cuvant cu 'p': " + cuvantp.get());
        }

        //9.3.3
        List<Student> studentiCuNote = Arrays.asList(
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

        System.out.println("\nStudenti cu nota 10:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(s -> System.out.println(s));

        System.out.println("\nStudenti cu nota sub 5:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(s -> System.out.println(s));

        System.out.println("\nLista cu note minime 4:");
        List<Student> noteMinime4 = studentiCuNote.stream()
                .map(s -> s.getNota() < 4
                        ? new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4)
                        : s)
                .collect(Collectors.toList());
        noteMinime4.forEach(s -> System.out.println(s));

        double sumaNote = studentiCuNote.stream()
                .reduce(0.0, (suma1, s) -> suma1 + s.getNota(), (a, b) -> a + b);
        System.out.println("\nSuma notelor: " + sumaNote);

        double mediaNote = sumaNote / studentiCuNote.size();
        System.out.println("Media notelor: " + mediaNote);

    }
}
