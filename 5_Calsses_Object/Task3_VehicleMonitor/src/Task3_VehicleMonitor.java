
import java.time.LocalDateTime;
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
public class Task3_VehicleMonitor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        int n=Integer.parseInt(sc.nextLine());
        Vehicle[] vehicles=new Vehicle[n];
        double[] distances=new double[n];
        
        double fuelPrice=Double.parseDouble(sc.nextLine());
        
        for(int i=0;i<n;i++){
            String st=sc.nextLine();
            String[] s1=st.split(",");
            vehicles[i]=new Vehicle(i,s1[0].trim(),s1[1].trim(),Double.parseDouble(s1[2].trim()),
                    Double.parseDouble(s1[3].trim()),Integer.parseInt(s1[4].trim()));
            distances[i]=Double.parseDouble(s1[5]);
            if(s1.length>6){
                vehicles[i].setWeight(Double.parseDouble(s1[6]));
            }
            if(s1.length>7){
                vehicles[i].setColor(s1[7]);
            }
        } 
        
        for(int i=0;i<n;i++){
            double typeCoefficient=0;
            switch (vehicles[i].getType()){
                case "car":
                    typeCoefficient=1;
                    break;
                case "suv":
                    typeCoefficient=1.12;
                    break;
                case "truck":
                    typeCoefficient=1.2;
                    break;
                case "motorcycle":
                    typeCoefficient=1.5;
                    break;    
            }
            int carAge=LocalDateTime.now().getYear()-vehicles[i].getYearProduced();
            double insuranceCost=0.16*vehicles[i].getPower()*1.25*carAge*
                    0.05*vehicles[i].getFuelConsumption()*typeCoefficient;
            System.out.printf("%04d - %s, %d, %s%nInsurance cost: %.2f - Travel cost: %.2f%n", 
                    vehicles[i].getLicenseNo(),vehicles[i].getModel(),
                    vehicles[i].getYearProduced(),vehicles[i].getColor(),
                    insuranceCost,distances[i]*0.01*vehicles[i].getFuelConsumption()*fuelPrice);
            
        }
    }
}
