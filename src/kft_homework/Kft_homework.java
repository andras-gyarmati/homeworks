package kft_homework;

public class Kft_homework {

    public static void main(String[] args) {
        Corporate co1 = new Corporate("Berenyi Kft.", "Budapest", "kereskedelem", 30000000);
        Boss boss1 = new Boss("Fonok Feri", 40000000, 200000, 8, co1);
        Employee emp1 = new Employee("Dolgozo Dori", 500000, 120000, 3, co1);
        Employee emp2 = new Employee("Dolgozo Dani", 1200000, 120000, 4, co1);
        Employee emp3 = new Employee("Dolgozo Denes", 200000, 120000, 2, co1);
        boss1.apply();
        emp1.apply();
        emp2.apply();
        emp3.apply();
        boss1.fire(emp1);
        co1.endOfMonth();
    }

}
