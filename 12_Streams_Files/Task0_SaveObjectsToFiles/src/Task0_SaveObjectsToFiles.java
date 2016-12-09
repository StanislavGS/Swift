
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public class Task0_SaveObjectsToFiles {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Movie movie1=new Movie("Gotfather", "Francis Ford Coppola",new String[]{"Marlon Brando","Al Pacino","James Caan"});
        Movie movie2=new Movie("Star Wars", "George Lucas",new String[]{"Harrison Ford","James Earl Jones"});
        
        FileOutputStream fo =new  FileOutputStream("movies.mv");
        
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(movie1);
        oos.writeObject(movie2);
        
        
        
        
        FileInputStream fi=new  FileInputStream("movies.mv");
        ObjectInputStream ois= new ObjectInputStream(fi);
        Movie mv1=(Movie) ois.readObject();
        Movie mv2=(Movie) ois.readObject();
        
        if(mv1.equals(movie1) && mv2.equals(movie2)){
            System.out.println("All that is writed is read.");
        }
        
        
        
    }
    
}
