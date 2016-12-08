package kft_homework;

public class Boss extends Person {

    public Boss(String name, int worth, int income, int qualification, Corporate corporate) {
        super(name, worth, income, qualification, corporate);
    }

    public void fire(Employee employee) {
        corporate.fire(employee);
    }

    @Override
    public void apply() {
        try {
            corporate.hireBoss(this);
        } catch (NotQualifiedException e) {
            System.out.println(e.getMessage());
        }
    }

}
