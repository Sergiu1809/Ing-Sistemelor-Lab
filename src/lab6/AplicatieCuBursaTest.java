package lab6;

import lab1.StudentBursier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);

        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier current = sortata.get(i);
            StudentBursier next = sortata.get(i + 1);

            int cmpFormatie = current.getFormatieDeStudiu().compareTo(next.getFormatieDeStudiu());
            if (cmpFormatie != 0) {
                Assertions.assertTrue(cmpFormatie < 0);
                continue;
            }

            int cmpNume = current.getNume().compareTo(next.getNume());
            if (cmpNume != 0) {
                Assertions.assertTrue(cmpNume < 0);
                continue;
            }

            int cmpPrenume = current.getPrenume().compareTo(next.getPrenume());
            if (cmpPrenume != 0) {
                Assertions.assertTrue(cmpPrenume < 0);
                continue;
            }

            int cmpNota = Double.compare(current.getNota(), next.getNota());
            if (cmpNota != 0) {
                Assertions.assertTrue(cmpNota < 0);
                continue;
            }

            Assertions.assertTrue(
                    Double.compare(current.getCuantumBursa(), next.getCuantumBursa()) <= 0
            );
        }
    }

    @Test
    void sortTestListaGoala() {
        List<StudentBursier> listaGoala = new ArrayList<>();
        List<StudentBursier> sortata = appCuBursa.sorteaza(listaGoala);
        Assertions.assertTrue(sortata.isEmpty());
    }

    @Test
    void sortTestOriginalaNeschimbata() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        int sizeInitial = lista.size();
        appCuBursa.sorteaza(lista);
        Assertions.assertEquals(sizeInitial, lista.size());
    }

    @Test
    void sortTestPrimulEsteISM() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        Assertions.assertTrue(
                sortata.get(0).getFormatieDeStudiu().startsWith("ISM")
        );
    }

    @Test
    void sortTestDimensiuneListaSortata() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        Assertions.assertEquals(lista.size(), sortata.size());
    }
}
