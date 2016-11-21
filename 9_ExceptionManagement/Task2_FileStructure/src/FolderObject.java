/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Stanislav Stanislavov
 */
public class FolderObject extends FileSystemObject{
    LinkedList<FileSystemObject> children;

    FolderObject(String name, FolderObject parent) {
        super(name, parent);
        this.children = new LinkedList<>();
    }
    
    public void addFileOrFolder(byte type,String[] st){//type 0-folder; 1-file;
        int i=Collections.binarySearch(children,new FileObject(st[0],null) , new FileSistemComparator());
        if(st.length>1){           
           if (i<0){
               throw(new IllegalArgumentException("Directory does not exist"));
           }else if(children.get(i) instanceof FileObject){
               throw(new IllegalArgumentException("Illegal operation"));
           }else{
              ((FolderObject) children.get(i)).addFileOrFolder(type,Arrays.copyOfRange(st, 1, st.length));
           }
        }else{
           if (i<0){
               switch(type){
                   case 0:
                       children.add(-i-1, new FolderObject(st[0], this));
                       break;
                   case 1:
                       children.add(-i-1, new FileObject(st[0], this));
               }               
           }else{
              throw(new IllegalArgumentException("There is a file/folder with a same name"));
           }
        }
    }
}

