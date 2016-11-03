/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Product implements Comparable<Product>{
    String name;
    Double price;
    
    Product(String name,Double price){
        this.name=name;
        this.price=price;
    }
    
    public int compareTo(Product product){
        return this.name.compareTo(product.name);
    }
}
