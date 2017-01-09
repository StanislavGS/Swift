/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import insurance.SocialInsuranceRecord;
import java.util.LinkedList;

/**
 *
 * @author stanislav
 */
public interface SocialInsuranceStorage {
    public Object getInsuranceById(int id);
    public int putInsuranceInDB(SocialInsuranceRecord isuranceRecord);
    public void updateInsurance(SocialInsuranceRecord isuranceRecord,int id);  
    public void clearAllInsurances();
    public int putInsurancesInDB(LinkedList<SocialInsuranceRecord> insuranceRecords);
    
}
