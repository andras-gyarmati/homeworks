package kft_homework;

import java.util.ArrayList;
import java.util.List;

public class Corporate {

    final int BOSS_LEVEL = 5;
    final int EMP_LEVEL = 3;
    private String name;
    private String locale;
    private String areaOfActivity;
    private int worth;
    private List<Boss> bosses;
    private List<Employee> employees;

    public Corporate(String name, String locale, String areaOfActivity, int worth) {
        this.name = name;
        this.locale = locale;
        this.areaOfActivity = areaOfActivity;
        this.worth = worth;
        bosses = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void hireBoss(Boss boss) throws NotQualifiedException {
        if (boss.getQualification() >= BOSS_LEVEL) {
            addBoss(boss);
        } else {
            throw new NotQualifiedException(boss.getName() + " is not qualified! Level: " + boss.getQualification() + "/" + BOSS_LEVEL);
        }
    }

    public void hireEmployee(Employee employee) throws NotQualifiedException {
        if (employee.getQualification() >= EMP_LEVEL) {
            addEmployee(employee);
        } else {
            throw new NotQualifiedException(employee.getName() + " is not qualified! Level: " + employee.getQualification() + "/" + EMP_LEVEL);
        }
    }

    private void addBoss(Boss newBoss) {
        bosses.add(newBoss);
    }

    private void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void endOfMonth(){
        worth *= 1.03;
        pay(bosses, employees);
    }
    
    private void pay(List<Boss> bosses, List<Employee> employees){
        for(Boss b : bosses){
            b.getsPaid(b.getIncome());
            worth -= b.getIncome();
        }
        for(Employee e : employees){
            e.getsPaid(e.getIncome());
            worth -= e.getIncome();
        }
    }
    
    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public String getAreaOfActivity() {
        return areaOfActivity;
    }

    public int getWorth() {
        return worth;
    }

    public List<Boss> getBosses() {
        return bosses;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
