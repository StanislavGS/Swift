/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Vehicle {
    String type;
    String model;
    double power;
    double fuelConsumption;
    int yearProduced;
    int licenseNo;
    double weight;
    String color;
    
    private void setType(String type){
        this.type=type;
    }
    private void setModel(String model){
        this.model=model;
    }
    private void setPower(double power){
        this.power=power;
    }
    private void setFuelconsumption(double fuelConsumption){
        this.fuelConsumption=fuelConsumption;
    }
    private void setYearProduced(int yearProduced){
        this.yearProduced=yearProduced;
    }
    private void setLicenseNo(int licenseNo){
        this.licenseNo=licenseNo;
    }
    void setWeight(double weight){
        this.weight=weight;
    }
    void setColor(String color){
        this.color=color;
    }
    
    String getType(){
        return type;
    }
    int getLicenseNo(){
        return licenseNo;
    }
    String getModel(){
        return model;
    }
    int getYearProduced(){
        return yearProduced;
    }
    String getColor(){
        return color;
    }
    double getPower(){
        return power;
    }
    double getFuelConsumption(){
        return fuelConsumption;
    }
    
    Vehicle(int licenseNo,String type,String model,double power,double fuelConsumption,int yearProduced){
        setLicenseNo(licenseNo);
        setType(type);
        setModel(model);
        setPower(power);
        setFuelconsumption(fuelConsumption);
        setYearProduced(yearProduced);
        setWeight(0);
        setColor("N/A");
    }
}
