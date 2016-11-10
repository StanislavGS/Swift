
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_UniversityManagement {

    public static void changeTolerance(Object[] persons,double balance, int... change) {
        for (Object person : persons) {
            if (person instanceof MaintenanceEmployee) {
                ((MaintenanceEmployee) person).increaseTolerance(change[0]);
            }
            if (person instanceof AdministrationEmployee) {
                ((AdministrationEmployee) person).increaseTolerance(change[1]);
            }
            if (person instanceof Teacher) {
                ((Teacher) person).increaseTolerance(change[2]);
            }
            if (person instanceof Student) {
                ((Student) person).increaseTolerance(change[3]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st;
        Object[] persons = new Object[50];
        int numPersons = 0;
        Disciplines disciplines = new Disciplines();
        double balance = 500;
        do {
            st = sc.nextLine();
            if (st.compareToIgnoreCase("end") != 0) {
                String[] elements = st.split(" ");
                switch (elements[0]) {
                    case "WORK":
                        break;
                    case "IDLE":
                        for (Object person : persons) {
                            if (person instanceof MaintenanceEmployee) {
                                balance -= 15;

                            }
                        }
                        break;
                    case "NEW":
                        switch (elements[1]) {
                            case "MAINT":
                                persons[numPersons++] = new MaintenanceEmployee(elements[2], elements[3], 0.0);
                                break;
                            case "ADMIN":
                                persons[numPersons++] = new AdministrationEmployee(elements[2], elements[3], 0.0,
                                        disciplines, Arrays.copyOfRange(elements, 4, elements.length));
                                break;
                            case "TEACH":
                                persons[numPersons++] = new Teacher(elements[2], elements[3], 0.0,
                                        disciplines, Arrays.copyOfRange(elements, 4, elements.length));
                                break;
                            case "STUD":
                                persons[numPersons++] = new Student(elements[2], elements[3], elements[3],
                                        disciplines, Arrays.copyOfRange(elements, 5, elements.length));
                                break;
                        }
                }
            }

        } while (st.compareToIgnoreCase("end") != 0);
    }
}
