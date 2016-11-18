/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Discipline extends SchoolObject {

    Discipline(String name) {
        this.name = name;
        this.classes = new Class[50];
        this.numClasses = 0;
        this.teachers = new Teacher[50];
        this.numTeachers = 0;
    }    
}
