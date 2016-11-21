/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public class FileObject extends FileSystemObject{
    
    public FileObject(String name, FolderObject parent) {
        super(name, parent);
        int indexDot=name.lastIndexOf(".");
        if(indexDot>=0 && name.length()-indexDot-1>6){
           throw(new IllegalArgumentException("Invalid name specified"));            
        }        
        
    }
    
}
