import java.util.ArrayList;
import java.util.List;

public class main {

    public static boolean existaStudent(List<Student> studenti, Student studentCautat){
        for(Student s: studenti){
            if((s.getNume() == studentCautat.getNume()) &&
                    (s.getPrenume() == studentCautat.getPrenume()) &&
                    (s.getFormatieDeStudiu() ==  studentCautat.getFormatieDeStudiu()) &&
                    (s.getNumarMatricol() == studentCautat.getNumarMatricol()) ) return true;
        }
        return false;
    }


    public static void main(String[] args) {

        Student s1 = new Student(128,"Sergiu","Tanase","ISM21/1");
        Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
        List<Student> studenti = new ArrayList<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);

        for(Student s: studenti){
            System.out.println(s);
        }

        System.out.println(existaStudent(studenti,s2));
        System.out.println(existaStudent(studenti,s3));

    }
}
