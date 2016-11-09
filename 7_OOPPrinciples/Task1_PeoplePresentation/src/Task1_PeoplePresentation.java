
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
public class Task1_PeoplePresentation {

    public static class BadInputDataExeption extends RuntimeException {

        public BadInputDataExeption(String s) {
            super(s);
        }
    }

    
    static void checkTotal(String st,int... whatCheck){
        if((whatCheck[0] & CHECK_LENGTH)!=0){
            if (st.length()<whatCheck[1]||st.length()>whatCheck[2]){
                    throw new BadInputDataExeption("BadLengt!");
                }
        } 
        if((whatCheck[0] & CHECK_LATIN_ALPABET)!=0){
            for(int i=0;i<st.length();i++){
                if (st.charAt(i)<'A' || st.charAt(i)>'z'||
                        (st.charAt(i)>'Z' && st.charAt(i)<'a')){
                    throw new BadInputDataExeption("noLattinLetter!");
                }
            }            
        } 
        if((whatCheck[0] & CHECK_FIRST_LETTER)!=0){
            if (st.charAt(0)<'A' || st.charAt(0)>'Z'){
                    throw new BadInputDataExeption("BadFirstLetter!");
                }
        } 
        if((whatCheck[0] & CHECK_UNNEGATIVE)!=0){
            double trash=Double.parseDouble(st);
            if (trash<0){
                    throw new BadInputDataExeption("NegativeNumber!");
                }
        } 
        if((whatCheck[0] & CHECK_INTEGER)!=0){
            int trash=Integer.parseInt(st);
        } 
        
        
        
        
    }
    
    static final int CHECK_LENGTH=0b00001;
    static final int CHECK_LATIN_ALPABET=0b00010;
    static final int CHECK_FIRST_LETTER=0b00100;
    static final int CHECK_UNNEGATIVE=0b01000;
    static final int CHECK_INTEGER=0b10000;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String st;
        do {
            st = sc.nextLine();
            if (st.compareToIgnoreCase("end") != 0) {
                String[] elements = st.split(" ");
                if (elements.length != 4 && elements.length != 5) {
                    //System.out.println("Unexpected count of elements!");
                    //System.exit(0);
                    throw new BadInputDataExeption("UnexpectedCountOfElements!");
                }
                
                boolean isStudent=elements.length == 5;
                
                checkTotal(elements[0],CHECK_LENGTH | CHECK_LATIN_ALPABET | CHECK_FIRST_LETTER,2,30);
                checkTotal(elements[1],CHECK_LENGTH | CHECK_LATIN_ALPABET | CHECK_FIRST_LETTER,2,30);
                if (isStudent){
                    checkTotal(elements[3],CHECK_LENGTH ,5,10);
                    checkTotal(elements[4],CHECK_INTEGER | CHECK_UNNEGATIVE);
                    checkTotal(elements[5],CHECK_INTEGER | CHECK_UNNEGATIVE);
                    Student student=new Student(elements[0],elements[1], elements[2],
                            Integer.parseInt(elements[3]),Integer.parseInt(elements[4]));
                    System.out.println(student);
                }else{
                    checkTotal(elements[3],CHECK_UNNEGATIVE);
                    checkTotal(elements[4],CHECK_UNNEGATIVE);
                    Worker worker= new Worker(elements[0],elements[1],
                            Double.parseDouble(elements[2]),Double.parseDouble(elements[3]));
                    System.err.println(worker);
                }
                
            }
        } while (st.compareToIgnoreCase("end") != 0);
    }
}
