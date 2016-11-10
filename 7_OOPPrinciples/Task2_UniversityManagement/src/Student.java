

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Student extends Person {

    private String _facultyNumber;
    private Disciplines _disciplines;

    String getFacultyNumber() {
        return this._facultyNumber;
    }

    void setFacultyNumber(String _facultyNumber) {
        this._facultyNumber = _facultyNumber;
    }

    Disciplines getDisciplines() {
        return this._disciplines;
    }

    void addDiscipline(Discipline discipline) {
        this._disciplines.addToEnd(discipline);
    }

    
    Student(String name,String phone,String facultyNumber,String ...disciplines) {
        super(name,phone);        
        this._facultyNumber = facultyNumber;
        this._disciplines = new Disciplines();
        for (String discipline : disciplines) {
            this._disciplines.addToEnd(new Discipline(discipline));
        } 
    }
    
}
