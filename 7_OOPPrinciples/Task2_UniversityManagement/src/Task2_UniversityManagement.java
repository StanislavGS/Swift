
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

    public static void changeTolerance(Object[] persons, double balance, int... change) {
        for (Object person : persons) {
            if (person instanceof MaintenanceEmployee) {
                ((MaintenanceEmployee) person).increaseTolerance(change[0]);
                checkForNegativeTolerance(person);
            }
            if (person instanceof AdministrationEmployee) {
                ((AdministrationEmployee) person).increaseTolerance(change[1]);
                checkForNegativeTolerance(person);
            }
            if (person instanceof Teacher) {
                ((Teacher) person).increaseTolerance(change[2]);
                checkForNegativeTolerance(person);
            }
            if (person instanceof Student) {
                ((Student) person).increaseTolerance(change[3]);
                checkForNegativeTolerance(person);
            }
        }
    }

    static void checkForNegativeTolerance(Object obj) {
        if (((Person) obj).tolerance <= 0) {
            System.out.println(((Person) obj).getName() + " is not happy.");
            System.exit(0);
        }
    }
    
    static int findByName(String name,Object[] persons,int numPersons){
        int idx=0;
        while(idx<numPersons ){ 
            String st=((Person) persons[idx]).getName();
            if(st.equals(name)){
                break;
            }
            idx++;
        }
        if(idx<numPersons){
            return idx;
        }else{
            return -1;
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
                        int idxPerson = findByName(elements[1], persons, numPersons);
                        if (idxPerson >= 0) {
                            if (persons[idxPerson] instanceof MaintenanceEmployee) {
                                changeTolerance(persons, balance, new int[]{2, 2, 2, 2});
                                balance -= 15;
                            }
                            if (persons[idxPerson] instanceof AdministrationEmployee) {
                                changeTolerance(persons, balance, new int[]{1, 0, 3, 3});
                                balance -= 19;
                            }
                            if (persons[idxPerson] instanceof Teacher) {
                                changeTolerance(persons, balance, new int[]{-3, -1, 0, 3});
                                balance -= 25;
                            }
                            if (persons[idxPerson] instanceof Student) {
                                changeTolerance(persons, balance, new int[]{-1, 0, 0, 2});
                                if (((Student) persons[idxPerson]).tolerance >= 50) {
                                    balance += 50;
                                }
                            }
                            if (balance <= 0) {
                                System.out.println("Bankrupcy.");
                                System.exit(0);
                            }
                        }

                        break;
                    case "IDLE":
                        for (Object person : persons) {
                            changeTolerance(persons, balance, new int[]{-5, -5, -5, -5});
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
