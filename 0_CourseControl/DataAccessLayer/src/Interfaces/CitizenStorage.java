/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Exceptions.DALException;
import java.util.ArrayList;
import personaldetails.Citizen;
/**
 *
 * @author stanislav
 */
public interface CitizenStorage {
    public Citizen getCitizenById(int id)throws DALException;
    public int putCitizenInDB(Citizen citizen);
    public void updateCitizen(Citizen citizen,int id);
    public void clearAllCitizens();
    public void putCitizensInDB(ArrayList<Citizen> citizens,int adressesIdx[]) throws DALException;
    public int getCitizensCount() throws DALException;
    public void clearWholeDB() throws DALException;
}
