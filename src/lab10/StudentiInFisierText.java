package lab10;

import lab1.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student s : studenti) {
                writer.write(s.toString() + "\n");
            }
            System.out.println("Export txt realizat: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

