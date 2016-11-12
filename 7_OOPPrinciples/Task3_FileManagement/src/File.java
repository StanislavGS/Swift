
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public abstract class File implements Comparable<File>{

    private String _name;
    private String _location;
    private LocalDateTime _creationDate;
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

    
    LocalDateTime getCreationDate() {
        return this._creationDate;
    }

    void setCreationDate(LocalDateTime creationDate) {
        this._creationDate = creationDate;
    }

    boolean getIsDeleted() {
        return this._isDeleted;
    }

    File(String name, String location) {
        this.setName(name);
        this.move(location);
        this.setCreationDate(LocalDateTime.now());
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
        return String.format("Name: %s/%s %s%nCreation date: %s", 
                this.getLocation(),this.getName(),this.getIsDeleted()?"[DELETED]":"",
                this.getCreationDate().toString());
    }
    
    @Override
    public int compareTo(File compareFile){
        return (this.getName()).compareTo(compareFile.getName());
    }
    
}
