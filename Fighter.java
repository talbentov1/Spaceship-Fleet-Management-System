package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fighter extends mygetWeaponAndFirePower{

	protected static int FighterAnnualBasicCost= 2500;
	protected int OtherAnnualBasicCost;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,crewMembers, FighterAnnualBasicCost,weapons);
	}

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers,int OtherAnnualBasicCost, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,crewMembers, OtherAnnualBasicCost,weapons);
		this.OtherAnnualBasicCost=OtherAnnualBasicCost;
	}

	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost()+ Weapon.SumOfAnnualMaintenanceCost(this.weaponslist)+
				(int) (this.getMaximalSpeed()*1000);
	}

	public int getFirePower(){
		return super.getFirePower();
	}

	public List<Weapon> getWeapon(){
		return super.weaponslist;
	}

	@Override
	public String toString(){
		return "Fighter"+super.toString();
	}
}
