package lab1;

import java.util.Objects;

public class StudentBursier extends Student {
    private double cuantumBursa;

    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa){
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if( !(o instanceof StudentBursier )) return false;
        StudentBursier sb = (StudentBursier) o;
        return Double.compare(sb.cuantumBursa, cuantumBursa) == 0;
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    public String toString(){
        return super.toString() + ", Bursa: " + cuantumBursa;
    }
}
