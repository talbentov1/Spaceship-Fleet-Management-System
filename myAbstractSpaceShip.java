package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceShip implements Spaceship{

    private String name;
    private int CommissionYear;
    private float MaximalSpeed;
    private final int FirePower=10;
    private Set<? extends CrewMember> CrewMembers;
    private int AnnualBasicCost;


    public myAbstractSpaceShip(String name, int CommissionYear, float MaximalSpeed, Set<? extends CrewMember> CrewMembers,int AnnualBasicCost){
        this.name=name;
        this.CommissionYear=CommissionYear;
        this.MaximalSpeed=MaximalSpeed;
        this.CrewMembers=CrewMembers;
        this.AnnualBasicCost=AnnualBasicCost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCommissionYear() {
        return this.CommissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return this.MaximalSpeed;
    }

    @Override
    public int getFirePower() {
        return this.FirePower;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return this.CrewMembers;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return this.AnnualBasicCost;
    }

    @Override
    public String toString() {
        return "\n\tName="+this.name+
                "\n\tCommissionYear="+this.getCommissionYear()+
                "\n\tMaximalSpeed="+this.getMaximalSpeed()+
                "\n\tFirePower="+this.getFirePower()+
                "\n\tCrewMembers="+this.getCrewMembers().size()+
                "\n\tAnnualMaintenanceCost="+this.getAnnualMaintenanceCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof myAbstractSpaceShip)) return false;
        myAbstractSpaceShip that = (myAbstractSpaceShip) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
