package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends myAbstractCrewPerson {

	private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber=modelNumber;
	}

	public int getModelNumber(){
		return this.modelNumber;
	}
	

}
