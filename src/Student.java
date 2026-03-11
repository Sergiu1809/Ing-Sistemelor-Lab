public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
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


   public String toString(){
        return "Nr. Matricol: " +  numarMatricol + "\n" + "Nume: " + nume  + "\n" +"Prenume: " + prenume + "\n" +"Formatie de studiu: " + formatieDeStudiu;
    }
}

