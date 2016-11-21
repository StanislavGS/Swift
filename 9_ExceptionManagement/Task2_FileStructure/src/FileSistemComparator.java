
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class FileSistemComparator implements Comparator<FileSystemObject> {
    @Override
    public int compare(FileSystemObject o1, FileSystemObject o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
