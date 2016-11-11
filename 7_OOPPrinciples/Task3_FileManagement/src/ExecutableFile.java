
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class ExecutableFile extends File {

    private LocalDate _lastExecutionDate;

    LocalDate getLastExecutionDate() {
        return this._lastExecutionDate;
    }

    void setLastExecutionDate(LocalDate lastExecutionDate) {
        this._lastExecutionDate = lastExecutionDate;
    }

    ExecutableFile(String name, String location, LocalDate creationDate, LocalDate lastExecutionDate) {
        super(name, location, creationDate);
        this.setLastExecutionDate(lastExecutionDate);
    }
    @Override
    public ExecutableFile copy(String newLocation){
        return new ExecutableFile(this.getName(), newLocation, this.getCreationDate(),this.getLastExecutionDate());
    }
    
    @Override
    public String execute(){
        return String.format("Executing %s/%s%n", this.getLocation(),this.getName());
    }

}
