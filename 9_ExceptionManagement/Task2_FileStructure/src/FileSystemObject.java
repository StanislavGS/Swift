/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class FileSystemObject {
    private FolderObject parent;
    private String name;
    
    String getName(){
        return this.name;
    }
    
    FolderObject getParent(){
        return this.parent;
    }

    FileSystemObject(String name,FolderObject parent) {
        
        if(((name.isEmpty()) || !name.matches("[a-zA-Z0-9()_!.&]+")) ||  
                (!name.substring(0, 1).matches("[a-zA-Z0-9]"))){
           throw(new IllegalArgumentException("Invalid name specified")); 
        }
        
        this.name=name;
        this.parent=parent;
    }
        
}