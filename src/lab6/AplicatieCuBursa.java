package lab6;

import lab1.StudentBursier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AplicatieCuBursa {
    static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }
    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add( new StudentBursier(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        lista.add( new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1", 9.80, 801.10));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 780.80));
        lista.add( new StudentBursier(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 100.00));
        return lista;
    }

    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {
        List<StudentBursier> sortata = new ArrayList<>(lst); // copie ca sa nu modificam originala
        sortata.sort(
                Comparator.comparing((StudentBursier s) -> s.getFormatieDeStudiu())
                        .thenComparing(s -> s.getNume())
                        .thenComparing(s -> s.getPrenume())
                        .thenComparing(s -> s.getNota())
                        .thenComparingDouble(s -> s.getCuantumBursa())
        );
        return sortata;
    }

}
