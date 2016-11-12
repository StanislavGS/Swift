/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class MediaContentFile extends ContentFile{
    MediaContentFile(String name, String location, String content){
        super(name, location,  content);
    }
    @Override
    public MediaContentFile copy(String newLocation){
        MediaContentFile doc= new MediaContentFile(this.getName(),newLocation,this.getContent());
        doc.setCreationDate(this.getCreationDate());
        doc.setLastModifiedDate(this.getLastModifiedDate());
        return doc;
    }
    @Override
    public String execute(){
        //if (!this.getIsDeleted()){
            return Character.toString((char) 0x266B) +(char) 0x266B+(char) 0x266B+" "+
                    this.getLocation()+"/"+this.getName()+"\n"+this.getContent()+"\n";
           
        //}
    }   
}
