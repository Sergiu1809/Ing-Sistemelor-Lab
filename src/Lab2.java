import java.util.*;

public class Lab2 {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List <Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b //TreeSet elimina duplicatele automat
        List<Integer> xMinusY = new ArrayList();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        Random rand = new Random();
        for(int i = 0;i<5;i++){
            x.add(rand.nextInt(11));
        }

        for(int i =0;i<7;i++){
            y.add(rand.nextInt(11));
        }

        // Sortare liste crescator
        Collections.sort(x);
        Collections.sort(y);

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        //a
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println("xPlusY = " + xPlusY);

        //b
        for(Integer val: x){ //pentru fiecare element din x
            if (y.contains(val)){
                zSet.add(val);
            }
        }
        System.out.println("zSet = " + zSet );

        //c
        for(Integer val : x){
            if (!y.contains(val)){
                xMinusY.add(val);
            }
        }
        System.out.println("xMinusY = " + xMinusY );

        //d
        for(Integer val : xPlusY){
            if(val <= p){
                xPlusYLimitedByP.add(val);
            }
        }
        System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP );
    }
}
