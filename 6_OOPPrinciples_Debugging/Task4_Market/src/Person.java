/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Person implements Comparable<Person> {
    String name;
    double balance;
    Product[] products;
    int numProducts;
    
    Person(String name,double balance){
        this.name=name;
        this.balance=balance;
        products=new Product[500];
        numProducts=0;
    }
    
    boolean buyingProduct(Product product){
        if(balance< product.price){
            return false;
        }else{
            products[numProducts++]=product;
            balance-=product.price;
            return true;
        }
    }
    
    public int compareTo(Person comparePerson){
        return name.compareTo(comparePerson.name);
    }
}
