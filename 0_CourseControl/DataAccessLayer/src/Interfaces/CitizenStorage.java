/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import personaldetails.Citizen;
/**
 *
 * @author stanislav
 */
public interface CitizenStorage {
    public Citizen getCitizenById(int id);
    public int putCitizenInDB(Citizen citizen);
    public void updateCitizen(Citizen citizen,int id);
}
