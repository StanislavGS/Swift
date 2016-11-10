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

    private Discipline _firstElement;
    private Discipline _lastElement;
    private int _length;

    public Disciplines() {
        this._firstElement = null;
        this._lastElement = null;
        this._length = 0;
    }

    public Disciplines(Discipline discipline) {
        this._firstElement = discipline;
        this._lastElement = discipline;
        this._length = 1;
    }

    public void addToEnd(Discipline disci) {
        if (this._lastElement != null) {
            this._lastElement.next = disci;
            this._lastElement = disci;
            this._length++;
        } else {
            this._firstElement = disci;
            this._lastElement = disci;
            this._length = 1;
        }
    }
    
    public String[] getDisciplines(){
        String[] st=new String[_length];
        Discipline current=this._firstElement;
        for(int i=0;i<_length;i++){
            st[i]=current.name;
            current=current.next;
        }
        return st;
    }

}
