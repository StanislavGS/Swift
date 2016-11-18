/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Teacher extends SchoolObject{
    
    Teacher(String name) {
        this.name=name;
        this.disciplines=new Discipline[50];
        this.classes=new Class[50];
        this.numDisciplines=0;
        this.numClasses=0;
    }    
    

}
