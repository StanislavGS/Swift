
import java.util.Arrays;



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
    

    String getFacultyNumber() {
        return this._facultyNumber;
    }

    void setFacultyNumber(String _facultyNumber) {
        this._facultyNumber = _facultyNumber;
    }

  
    Student(String name,String phone,String facultyNumber,Disciplines disciplinesGlobal,String ...disciplines) {
        super(name,phone,disciplinesGlobal,disciplines);        
        this._facultyNumber = facultyNumber;
    }
    
}
