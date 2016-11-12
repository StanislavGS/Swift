
import com.sun.xml.internal.ws.util.StringUtils;
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
public class DocumentContentFile extends ContentFile{
    DocumentContentFile(String name, String location, String content){
        super(name, location,  content);
    }
    @Override
    public DocumentContentFile copy(String newLocation){
        DocumentContentFile doc= new DocumentContentFile(this.getName(),newLocation,this.getContent());
        doc.setCreationDate(this.getCreationDate());
        doc.setLastModifiedDate(this.getLastModifiedDate());
        return doc;
    }
    @Override
    public String execute(){
        //if (!this.getIsDeleted()){
            return Character.toString((char) 0x2713) +(char) 0x2713+(char) 0x2713+" "+
                    this.getLocation()+"/"+this.getName()+"\n"+this.getContent()+"\n";
           
        //}
    }   
}
