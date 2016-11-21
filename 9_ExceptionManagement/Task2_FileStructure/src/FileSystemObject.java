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
        this.name=name;
        this.parent=parent;
    }
        
}