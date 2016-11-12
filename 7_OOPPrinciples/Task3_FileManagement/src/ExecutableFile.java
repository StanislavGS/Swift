
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime _lastExecutionDate;
    private String[] _requiredResources;

    LocalDateTime getLastExecutionDate() {
        return this._lastExecutionDate;
    }

    void setLastExecutionDate(LocalDateTime lastExecutionDate) {
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

    ExecutableFile(String name, String location, String ... resourses) {
        super(name, location);
        this.setLastExecutionDate(LocalDateTime.now());
        this._requiredResources=resourses;
        
    }
    @Override
    public ExecutableFile copy(String newLocation){
        return new ExecutableFile(this.getName(), newLocation, this._requiredResources);
    }
    
    @Override
    public String execute(){
        String st=String.format("Executing %s/%s", this.getLocation(),this.getName())+
                ";"+String.join(";", this._requiredResources);
        this.setLastExecutionDate(LocalDateTime.now());
        return st;
    }
    
    @Override
    String getInfo(){
        String st="Required resources:\n";
        for (int i = 0; i < this._requiredResources.length; i++) {
             st += this._requiredResources[i] ;
             if (i<this._requiredResources.length-1){
                 st +="\n";
             }
        }
        return String.format("%s%nLast execution date:%s%n%s",super.getInfo(),
                this.getLastExecutionDate().toString(),st);
   }

}
