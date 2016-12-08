package kft_homework;

public class Employee extends Person {

    public Employee(String name, int worth, int income, int qualification, Corporate corporate) {
        super(name, worth, income, qualification, corporate);
    }

    @Override
    public void apply() {
        try {
            corporate.hireEmployee(this);
        } catch (NotQualifiedException e) {
            System.out.println(e.getMessage());
        }
    }

}
