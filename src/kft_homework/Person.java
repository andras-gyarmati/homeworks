package kft_homework;

public abstract class Person {

    private String name;
    private int worth;
    private int income;
    private int qualification;
    Corporate corporate;

    public Person(String name, int worth, int income, int qualification, Corporate corporate) {
        this.name = name;
        this.worth = worth;
        this.income = income;
        this.qualification = qualification;
        this.corporate = corporate;
    }

    public abstract void apply();

    public void getsPaid(int income) {
        if (income >= 0) {
            worth += income;
        }
    }

    public String getName() {
        return name;
    }

    public int getWorth() {
        return worth;
    }

    public int getQualification() {
        return qualification;
    }

    public int getIncome() {
        return income;
    }
}
