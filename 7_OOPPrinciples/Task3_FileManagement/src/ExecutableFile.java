
import java.time.LocalDate;
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
public class ExecutableFile extends File {

    private LocalDate _lastExecutionDate;
    private String[] _requiredResources;

    LocalDate getLastExecutionDate() {
        return this._lastExecutionDate;
    }

    void setLastExecutionDate(LocalDate lastExecutionDate) {
        this._lastExecutionDate = lastExecutionDate;
    }
    
    void addResource(String resource){
        if (this._requiredResources==null){
            this._requiredResources=new String[]{resource};
            return;
        }
        this._requiredResources=Arrays.copyOf(this._requiredResources, this._requiredResources.length+1);
        this._requiredResources[this._requiredResources.length-1]=resource;
    }

    ExecutableFile(String name, String location, LocalDate creationDate, LocalDate lastExecutionDate,String ... resourses) {
        super(name, location, creationDate);
        this.setLastExecutionDate(lastExecutionDate);
        if (!resourses.equals(null)){
            this._requiredResources=resourses;
        }
        
    }
    @Override
    public ExecutableFile copy(String newLocation){
        return new ExecutableFile(this.getName(), newLocation, this.getCreationDate(),this.getLastExecutionDate());
    }
    
    @Override
    public String execute(){
        return String.format("Executing %s/%s%n", this.getLocation(),this.getName());
        ...
    }

}
