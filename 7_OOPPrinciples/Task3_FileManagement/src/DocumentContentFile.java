
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
public class DocumentContentFile extends ContentFile{
    DocumentContentFile(String name, String location, LocalDate creationDate, String content, LocalDate lastModifiedDate){
        super(name, location, creationDate, content, lastModifiedDate);
    }
    @Override
    public DocumentContentFile copy(String newLocation){
        return new DocumentContentFile(this.getName(),newLocation,this.getCreationDate(),
                    this.getContent(),this.getLastModifiedDate());
    }
    @Override
    public String execute(){
        if (this.getIsDeleted()){
            return Character.getName(0x2713);
        }
    }   
}
