package lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
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

    public static boolean existaStudentv2(HashSet<Student> studenti, Student studentCautat){
        return  studenti.contains(studentCautat);
    }

    public static void main(String[] args) throws IOException {

        Student s1 = new Student(128,"Sergiu","Tanase","ISM21/1");
        Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
        Student s4 = new Student(167, "Ana", "Popa", "TI21/2");
        List<Student> studenti = new ArrayList<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);

        for(Student s: studenti){
            System.out.println(s);
        }

        System.out.println(existaStudent(studenti,s2));
        System.out.println(existaStudent(studenti,s3));

        HashSet<Student> set = new HashSet<>(studenti);

        System.out.println(existaStudentv2(set,s1));
        System.out.println(existaStudentv2(set,s4));
    }
}


