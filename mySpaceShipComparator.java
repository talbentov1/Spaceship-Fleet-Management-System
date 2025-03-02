package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class mySpaceShipComparator implements Comparator<Spaceship> {

    @Override
    public int compare(Spaceship s1, Spaceship s2) {
        int num=Integer.compare(s1.getFirePower(),s2.getFirePower());
        if (num!=0){
            return -num;
        }
        num=Integer.compare(s1.getCommissionYear(),s2.getCommissionYear());
        if (num!=0){
            return -num;
        }
        return s1.getName().compareTo(s2.getName());
    }
}
