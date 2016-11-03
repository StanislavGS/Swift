/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */

//Put element in full list and keep sorting 
public class Task2_EmployeeSalarySort {
    
    static void putEmployeeInTop3orMore(Employee compareEmployee,Employee[] employers){
        int n=employers.length;
        boolean isFinded=false;
        Employee trash=null, trash1;
        for(int i=0;i<n;i++){
            if (isFinded){                  
                if(employers[i]==null){
                    employers[i]=trash;
                    break;
                }
                trash1=employers[i];
                employers[i]=trash;
                trash=trash1;
                
            }else{
                if(employers[i]==null){
                    employers[i]=compareEmployee;
                    break;
                }
                if(compareEmployee.getSalary()>employers[i].getSalary()){
                    isFinded=true;
                    trash=employers[i];
                    employers[i]=compareEmployee;
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        
        Employee[] employers=new Employee[3];
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String st=sc.nextLine();
            String[] s1=st.split(",");
            Employee currentEmployee=new Employee(s1[0].trim(),Double.parseDouble(s1[1].trim()),s1[2].trim(),s1[3].trim());
            if (s1.length>4){
                currentEmployee.setAge(Integer.parseInt(s1[4].trim()));
            }
            if (s1.length>5){
                currentEmployee.setEmail(s1[5]);
            }
            putEmployeeInTop3orMore(currentEmployee,employers);
        }
        
        //Output 3 employers with hihgt salary 
        
        for(int i=0;i<employers.length;i++){
            System.out.printf("%s,%s,%s", employers[i].getName(),employers[i].getDepartment(),employers[i].getPosition());
            if (employers[i].getEmail()!=""){
                System.out.print(","+employers[i].getEmail());
            }
            System.out.println();
        }
        
    }
    
}
