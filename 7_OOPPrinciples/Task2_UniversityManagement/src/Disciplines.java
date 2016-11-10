
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
public class Disciplines {
    String[] list;
    int countelements;
    Disciplines(){
        this.list=new String[100];
        this.countelements=0;
    }
    
    int getIndex(String discipline){
        int idx=0;
        while(idx< countelements && !list[idx].equals(discipline)){
            idx++;
        }
        if (idx< countelements){
            return idx;
        }else{
            return -1;
        }            
    }
    
    int addOrGetIndex(String discipline){
        int idx=getIndex(discipline);
        if (idx >=0){
            return idx;
        }else{
            list[countelements++]=discipline;
            return countelements-1;
        }
    }
}
