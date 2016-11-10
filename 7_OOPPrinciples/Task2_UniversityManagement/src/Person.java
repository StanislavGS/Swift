
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
public abstract class Person {

    private String name;
    private String phone;
    int tolerance=20;
    private int[] _disciplines;

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPhone() {
        return this.phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
    
    void increaseTolerance(int howMany){
        this.tolerance+=howMany;
    }
    
    boolean decreaseTolerance(int howMany){
        if(this.tolerance<howMany){
            this.tolerance=-1;
            return true;
        }else{
            this.tolerance-=howMany;
            return false;
        }
    }
    
    Person(String name,String phone){
        this.name=name;
        this.phone=phone;
        this.tolerance=20;        
    }
    
    
    /*
    Вмъкнал съм тук дисциплините за да може хем да запазя структурата на заданието, 
        хем да не пиша долните методи 3 пъти.
    */
    
    Person(String name,String phone,Disciplines disciplinesGlobal,String...disciplines){
        this.name=name;
        this.phone=phone;
        this.tolerance=20;
        this._disciplines=new int[disciplines.length];
        for(int i=0;i<disciplines.length;i++){
            this._disciplines[i]=disciplinesGlobal.addOrGetIndex(disciplines[i]);
        }
        Arrays.sort(_disciplines);
    }
      
    
    
    int existDiscipline(String discipline,Disciplines disciplinesGlobal){
        int result=disciplinesGlobal.getIndex(discipline);
        if (result<0){
            return result;
        }
        int result1=Arrays.binarySearch(_disciplines, result);
        return result1;
    }
    void addDiscipline(String discipline,Disciplines disciplinesGlobal) {
        int result=existDiscipline(discipline, disciplinesGlobal);
        if (result<0){
            int[] newDisciplines=Arrays.copyOf(_disciplines,_disciplines.length+1);
            newDisciplines[newDisciplines.length]=disciplinesGlobal.addOrGetIndex(discipline);
            Arrays.sort(newDisciplines);
            _disciplines=newDisciplines;
        }
    }
    
    void removeDiscipline(String discipline,Disciplines disciplinesGlobal){
        int result=existDiscipline(discipline, disciplinesGlobal);
        if (result>=0){
            _disciplines[result]=_disciplines[_disciplines.length]+1;
            Arrays.sort(_disciplines);
            _disciplines=Arrays.copyOf(_disciplines, _disciplines.length-1);
        }
    }

    
}
