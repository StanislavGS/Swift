
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class File {

    private String _name;
    private String _location;
    private LocalDate _creationDate;
    private boolean _isDeleted;

    String getName() {
        return this._name;
    }

    void setName(String name) {
        this._name = name;
    }

    String getLocation() {
        return this._location;
    }

    
    LocalDate getCreationDate() {
        return this._creationDate;
    }

    void setCreationDate(LocalDate creationDate) {
        this._creationDate = creationDate;
    }

    boolean getIsDeleted() {
        return this._isDeleted;
    }

    File(String name, String location, LocalDate creationDate) {
        this.setName(name);
        this.move(location);
        this.setCreationDate(creationDate);
        this._isDeleted = false;
    }

    void delete() {
        this._isDeleted = true;
    }

    void move(String newLocation) {
        this._location = newLocation;
    }
    abstract File copy(String newLocation);
    abstract String execute();    
    String getInfo(){
        return String.format("Name: %s/%s %s%nCreation date: %s%n", 
                this.getLocation(),this.getName(),this.getIsDeleted()?"[DELETED]":"",
                this.getCreationDate().toString());
    }
    
}
