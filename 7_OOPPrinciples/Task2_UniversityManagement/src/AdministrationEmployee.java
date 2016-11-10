/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class AdministrationEmployee extends Employee{
    
    AdministrationEmployee(String name,String phone,double hourSalary,Disciplines disciplinesGlobal,String ...disciplines) {
        super(name, phone,hourSalary,disciplinesGlobal,disciplines);
    }
}
