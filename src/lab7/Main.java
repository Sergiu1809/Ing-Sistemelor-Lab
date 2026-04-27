package lab7;

import lab1.Student;
import lab7.forms.Circle;
import lab7.forms.Form;
import lab7.forms.Square;
import lab7.forms.Triangle;
import lab7.util.PasswordMaker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        lab7.util.PasswordMaker pm2 = lab7.util.PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());

        Set<Student> studenti = new HashSet<>();
        studenti.add(new Student(1024, "Ioan",     "Mihalcea", "TI211", 9.80));
        studenti.add(new Student(1025, "Andrei",   "Popa",     "TI211", 8.70));
        studenti.add(new Student(1026, "Anamaria", "Prodan",   "TI211", 8.90));
        studenti.add(new Student(1027, "Paul",     "Mohanu",   "TI211", 5.40));
        studenti.add(new Student(1028, "Mihai",    "Ionescu",  "TI211", 6.20));
        studenti.add(new Student(1029, "Bianca",   "Popescu",  "TI211", 9.10));

        System.out.println("\n7.6.3 Inainte de impartire:");
        for (Student s : studenti) {
            System.out.println(s);
        }

        studenti = imparteInDouaFormatii(studenti, "TI211_1", "TI211_2");

        System.out.println("\nDupa impartire:");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }

    static Student schimbaFormatia(Student st, String nouaFormatie){
        return new Student(
                st.getNumarMatricol(),
                st.getPrenume(),
                st.getNume(),
                nouaFormatie,
                st.getNota()
        );
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2){
        Set<Student> rezultat = new HashSet<>();
        List<Student> lista = new ArrayList<>(studenti);

        int jumatate = (lista.size() + 1)/2;

        for(int i = 0; i < lista.size(); i++){
            if(i<jumatate){
                rezultat.add(schimbaFormatia(lista.get(i), formatia1));
            }
            else{
                rezultat.add(schimbaFormatia(lista.get(i), formatia2));
            }
        }
        return rezultat;
    }
}
