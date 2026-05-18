package lab10;

import lab1.Student;
import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport strategyInstance, List<Student> studenti) {
        strategyInstance.doExport(studenti);
    }
}
