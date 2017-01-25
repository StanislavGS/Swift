/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import Interfaces.AddressStorage;
import address.Address;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stanislav
 */
public class MySqlAddressStorage implements AddressStorage{

    public MySqlAddressStorage() {
    }

    
    @Override
    public int putAddressInDB(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddressFromDB(int id) throws DALException{
        String        sqlQuery="SELECT * FROM `citizen_insurance`.`addresses` WHERE `id`='"+id+"';";
        MySQLRequest request= new MySQLRequest(sqlQuery, TypeStatement.executeQuery, TypeResult.Address);
          try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while getting address by citizen from DB", ex);
        }
        return (Address) request.getResult();
    }

    @Override
    public void updateAddress(Address address, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAllAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAddressesInDB(LinkedList<Address> addresses) throws DALException{
        
        ArrayList<CharSequence> sts=new ArrayList<>();
        //String sqlQuery="INSERT INTO `citizen_insurance`.`addresses` VALUES \n";
        sts.add("INSERT INTO `citizen_insurance`.`addresses` VALUES \n");
        for (int i = 0; i < addresses.size(); i++) {
            Address current=addresses.get(i);
            //System.out.println("get end" + System.currentTimeMillis());
            if(i>0){
                //sqlQuery+=",\n";
                sts.add(",\n");
            }
            //sqlQuery+=
            sts.add(String.format("('%d','%s','%s','%s','%s','%s','%s','%d','%d')",
                    i+1,current.getCountry(),current.getCity(),current.getMunicipality(),
                    current.getPostalCode(),current.getStreet(),current.getNumber(),
                    current.getFloor(),current.getApartmentNo()));  
            //System.out.println("String+ format end" + System.currentTimeMillis());
        }
        //sqlQuery+=";";
        sts.add(";");
        String sqlQuery=String.join("",sts);
        MySQLRequest request=new MySQLRequest(sqlQuery, TypeStatement.execute, TypeResult.Void);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting addresses in DB", ex);
        }
    }
    
}
