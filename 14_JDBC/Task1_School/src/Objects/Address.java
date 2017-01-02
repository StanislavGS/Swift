/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author stanislav
 */
public class Address {
    String country;
    String city;
    String street;
    String number;
    int floor;
    int apartment;

    public Address(String country, String city, String street, String number, int floor, int apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    public int getApartment() {
        return apartment;
    }
    
    
}
