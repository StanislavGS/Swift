
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class Task4_PersonCharacteristics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.parseInt(sc.nextLine()) ;
        Person[] persons = new Person[n];
        String st;        
        for (int i = 0; i < n; i++) {
           
            st = sc.nextLine();
            String[] s1=st.split(";");
            Address address;
            if(!s1[12].trim().equals("") && !s1[13].trim().equals("")){
                address=new Address(s1[6],s1[7],s1[8],Integer.parseInt(s1[9]),s1[10],s1[11],
                        Integer.parseInt(s1[12]),Integer.parseInt(s1[13]));
            }else if(s1[12].trim().equals("") && s1[13].trim().equals("") ){
                address=new Address(s1[6],s1[7],s1[8],Integer.parseInt(s1[9]),s1[10],s1[11]);
            }else{
                address=new Address(s1[6],s1[7],s1[8],Integer.parseInt(s1[9]),s1[10],s1[11],Integer.parseInt(s1[12]));
            }
            
            Object education=null;
            LocalDate graduationDate=LocalDate.parse(s1[17], DateTimeFormatter.ofPattern("d.M.y"));
            float grade=0f;
            if (s1[14].trim().toUpperCase()!="P" && graduationDate.compareTo(LocalDate.now())<=0){
                grade=Float.parseFloat(s1[18]);
            }
            switch (s1[14].trim().toUpperCase()){                
                case "P":
                    education=new PrimaryEducation(s1[15],
                            LocalDate.parse(s1[16],DateTimeFormatter.ofPattern("d.M.y")), 
                            graduationDate);
                    break;
                case "S":
                    education=new SecondaryEducation(s1[15], 
                            LocalDate.parse(s1[16],DateTimeFormatter.ofPattern("d.M.y")), 
                            graduationDate,grade);
                    break;
                case "B":
                    education=new HigherEducation(s1[15], 
                            LocalDate.parse(s1[16],DateTimeFormatter.ofPattern("d.M.y")), 
                            graduationDate,grade,"bachelor");
                    break;
                case "M":
                    education=new HigherEducation(s1[15], 
                            LocalDate.parse(s1[16],DateTimeFormatter.ofPattern("d.M.y")), 
                            graduationDate,grade,"master");
                    break;
                case "D":
                    education=new HigherEducation(s1[15], 
                            LocalDate.parse(s1[16],DateTimeFormatter.ofPattern("d.M.y")), 
                            graduationDate,grade,"doctorate");                    
            }
            persons[i] = new Person(s1[0],s1[1],s1[2],s1[3].trim().charAt(0),
                            LocalDate.parse(s1[4],DateTimeFormatter.ofPattern("d.M.y")),
                            Float.parseFloat(s1[5]),education,address);
        }

        for (int i = 0; i < n; i++) {
           
           System.out.println(persons[i]);
        }

    }
}
