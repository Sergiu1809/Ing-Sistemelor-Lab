public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private int formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, int formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String toString(){
        return "Nr. Matricol: " +  numarMatricol + "\n" + "Nume: " + nume  + "\n" +"Prenume: " + prenume + "\n" +"Formatie de studiu: " + formatieDeStudiu;
    }
}
