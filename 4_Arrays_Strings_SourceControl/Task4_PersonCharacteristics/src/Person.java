/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Person {
    String firstName;
    String lastName;
    char gender;
    short yearOfBirth;
    float weight;
    float heigh;
    String proffesion;
    float[] grades=new float[4];
    
    public Person(String st){
        String[] s1=st.split(";");
        firstName=s1[0];
        lastName=s1[1];
        gender=s1[2].charAt(0);
        yearOfBirth=Short.parseShort(s1[3]);
        weight=Float.parseFloat(s1[4]);
        heigh=Float.parseFloat(s1[5]);
        proffesion=s1[6];
        for(int i=0;i<4;i++){
            grades[i]=Float.parseFloat(s1[i+7]);
        }
    }
    
    public void printf(){
        short currentYear=(short) (System.currentTimeMillis()/(1000*60*60*24*365.25)+1970);
        System.out.printf("%s %s is %d years old. %s was born in %d." +
                " %s weight is %.1f and %s is %.0f cm tall. %4$s is a %s with an average grade of %.3f.%n",
                firstName,lastName,currentYear-yearOfBirth,
                gender=='M'?"He":"She", yearOfBirth,
                gender=='M'?"His":"Her",weight,gender=='M'?"he":"she",heigh,
                proffesion,0.25*(grades[0]+grades[1]+grades[2]+grades[3]));
    }
}
