package task5_personcharacteristics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Address {
    String country;
    String city;
    String municipality;
    int postalCode;
    String street;
    String number;
    int floor;
    int apartmentNo;

   
    Address(String country,String city,String municipality,int postalCode,
                    String street, String number){
        this.country=country;
        this.city=city;
        this.municipality=municipality;
        this.postalCode=postalCode;
        this.street=street;
        this.number=number;
        this.floor=99999;
        this.apartmentNo=999999;
    }
    
    Address(String country,String city,String municipality,int postalCode,
                    String street, String number, int floor){
        this(country,city,municipality,postalCode,street,number);
        this.floor=floor;
    }
    
    Address(String country,String city,String municipality,int postalCode,
                    String street, String number, int floor, int apartmentNo){
        this(country, city,municipality,postalCode,street,number,floor);
        this.apartmentNo=apartmentNo;
    }
    @Override
    public String toString(){
        String stFloorApartment="";
        if (this.floor!=99999){
            stFloorApartment="fl. "+this.floor;
        }
        if (this.apartmentNo!=999999){
            stFloorApartment+=", ap. "+this.apartmentNo;
        }
        if(!stFloorApartment.isEmpty()){
            stFloorApartment+="\n";
        }
            
        return String.format("%s %s Street%n%s%d %s%n%s, %s%n", this.number,this.street,
                    stFloorApartment,this.postalCode,this.municipality,this.city,this.country);
    }
    
    public boolean equals(Address compareAddress){
        return (this.country.equals(compareAddress.country) && 
                this.city.equals(compareAddress.city) && 
                this.municipality.equals(compareAddress.municipality) && 
                this.postalCode==compareAddress.postalCode && 
                this.street.equals(compareAddress.street) && 
                this.number.equals(compareAddress.number) && 
                this.floor==compareAddress.floor && 
                this.apartmentNo==compareAddress.apartmentNo );
    }
    
}
