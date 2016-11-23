/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class OldPasswordConflictException extends Exception{
    private int passwordConflictIndex;
    OldPasswordConflictException(int passwordConflictIndex){
        this.passwordConflictIndex=passwordConflictIndex;
    }
    public int getPasswordConflictIndex(){
        return this.passwordConflictIndex;
    }
}
