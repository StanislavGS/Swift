
/*

 

* To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */



/**

 *

 * @author Stanislav Stanislavov

 */


public class Person {

    String firstName;
    String lastName;
    int yearOfBirth;
    double weight;
    double height;
    String profession;
    Person(String frstNm, String lstNm, int yeaO, double wei, double hei, String prof) {
        this.firstName = frstNm;
        this.lastName = lstNm;
        this.yearOfBirth = yeaO;
        this.weight = wei;
        this.height = hei;
        this.profession = prof;
    }

    public String Output() {
        short currentYear=(short) (System.currentTimeMillis() / (1000 * 60 * 60 * 24 * 365.25) + 1970);
        String st= firstName + " " + lastName + " is "
                + (currentYear - yearOfBirth)
                + " years old. His weight is "
                + weight + " and he is " + height + " cm tall. He is a " + profession + ".";
        if (currentYear - yearOfBirth<18){
            st+=firstName + " " + lastName + " is under-aged.";
        }
        return st;
    }

}
