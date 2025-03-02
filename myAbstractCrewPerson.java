package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractCrewPerson implements CrewMember{

    private String name;
    private int age;
    private int yearsInService;

    public myAbstractCrewPerson (int age, int yearsInService,String name){
        this.name=name;
        this.age=age;
        this.yearsInService=yearsInService;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getYearsInService() {
        return this.yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof myAbstractCrewPerson)) return false;
        myAbstractCrewPerson that = (myAbstractCrewPerson) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
