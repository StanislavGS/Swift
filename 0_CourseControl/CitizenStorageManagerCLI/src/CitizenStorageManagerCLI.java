
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stanislav
 */
public class CitizenStorageManagerCLI {
    public static void main(String[] args) {
     if (args==null || args.length<1){
         return;
     }
     File file=new File(args[0]); 
     if(file.canRead()){
         
     }
    }    
}
