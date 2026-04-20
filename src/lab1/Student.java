package lab1;

import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume(){
        return prenume;
    }

    public String getNume(){
        return nume;
    }

    public String getFormatieDeStudiu(){
        return formatieDeStudiu;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Student)) return false;

        Student student = (Student) o;

        return prenume.equals(student.prenume) &&
                nume.equals(student.nume) &&
                formatieDeStudiu.equals(student.formatieDeStudiu);
    }

    public int hashCode(){
        return Objects.hash(prenume, nume, formatieDeStudiu);
    }

   public String toString(){
        return "Nr. Matricol: " +  numarMatricol + ", Nume: " + nume  +", Prenume: " + prenume +", Formatie de studiu: " + formatieDeStudiu + ", Nota: " + nota;
    }
}
