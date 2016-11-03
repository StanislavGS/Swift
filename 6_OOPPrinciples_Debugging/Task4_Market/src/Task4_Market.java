
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
public class Task4_Market {
    static void checkNameDouble(String name,double priceOrBalance,String type){
        if (name.isEmpty()){
                System.out.println("Name can’t be empty.");
                System.exit(0);
        }
        if(priceOrBalance<0){
            System.out.println(type+" can’t be negative.");
                System.exit(0);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        
        
        Person[] persons=new Person[200];
        int numPersons=0;
        Product[] products=new Product[500];
        int numProducts=0;
        
        String st=sc.nextLine();
        String[] personsList=st.split(";");
        for(String personString:personsList){
            String[] personData=personString.split("=");            
            Double balance=Double.parseDouble(personData[1]);
            checkNameDouble(personData[0],balance,"Balance");
            persons[numPersons++]=new Person(personData[0],balance);
        }
        Arrays.sort(persons, 0, numPersons);
        
        st=sc.nextLine();
        String[] productList=st.split(";");
        for(String productString:productList){
            String[] productData=productString.split("=");            
            Double price=Double.parseDouble(productData[1]);
            checkNameDouble(productData[0],price,"Price");
            products[numProducts++]=new Product(productData[0],price);
        }
        
        do{
           st=sc.nextLine();
           if (!st.equals("END")){
               String[] s1=st.split(" ");
               String nameProduct=s1[s1.length-1];
               String namePerson=s1[0];
               if (s1.length>1){
                   for(int i=1;i<s1.length-1;i++){
                        namePerson+=" "+s1[i];
                   }
               }
               
               Person trashPerson= new Person(namePerson,0);
               int idxPerson=Arrays.binarySearch(persons, 0, numPersons, trashPerson);
               Product trashProduct= new Product(nameProduct,0.0);
               int idxProduct=Arrays.binarySearch(products, 0, numProducts, trashProduct);
               if (idxPerson<0 || idxProduct<0  ){
                   System.out.println(namePerson + " can’t afford " + nameProduct);
               }else{
                   if(persons[idxPerson].buyingProduct(products[idxProduct])){
                       System.out.println(namePerson + " bought " + nameProduct);
                   }else{
                       System.out.println(persons[idxPerson].name + " can’t afford " + products[idxProduct].name);
                   }                   
               }               
           }
        }while(!st.equals("END"));
        
        for(int i=0;i<numPersons;i++){
            System.out.print(persons[i].name + "-");
            if (persons[i].numProducts>0){
                for(int j=0;j<persons[i].numProducts;j++){
                    System.out.print(persons[i].products[j].name);
                    if (j<persons[i].numProducts-1){
                        System.out.print(",");
                    }
                }
                System.out.println();
            }else{
                System.out.println("Nothing bought");
            }
        }
    }
    
}
