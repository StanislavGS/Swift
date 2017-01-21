/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.DALException;
import insurance.SocialInsuranceRecord;
import java.util.ArrayList;


/**
 *
 * @author stanislav
 */
public interface SocialInsuranceStorage {
    public Object getInsuranceById(int id);
    public int putInsuranceInDB(SocialInsuranceRecord isuranceRecord);
    public void updateInsurance(SocialInsuranceRecord isuranceRecord,int id);  
    public void clearAllInsurances();
    public void putInsurancesInDB(ArrayList<SocialInsuranceRecord> insuranceRecords,
            int[][] personInsurance) throws DALException;
    
}
