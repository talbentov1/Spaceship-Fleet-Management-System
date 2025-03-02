package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class mygetWeaponAndFirePower extends myAbstractSpaceShip {

    protected List<Weapon> weaponslist;
    private static int FirePower=10;

    public mygetWeaponAndFirePower(String name, int CommissionYear, float MaximalSpeed, Set<? extends CrewMember> CrewMembers, int AnnualBasicCost, List<Weapon> weaponslist) {
        super(name, CommissionYear, MaximalSpeed, CrewMembers, AnnualBasicCost);
        this.weaponslist=weaponslist;
    }

    public int getFirePower(){
        return Weapon.SumOfFirePower(this.weaponslist)+ FirePower;
    }

    public List<Weapon> getWeapon(){
        return this.weaponslist;
    }

    @Override
    public String toString(){
        return super.toString()+"\n\tWeaponArray="+this.getWeapon();
    }


}
