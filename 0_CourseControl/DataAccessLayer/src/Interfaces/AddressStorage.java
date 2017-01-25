/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.DALException;
import address.Address;
import java.util.LinkedList;

/**
 *
 * @author stanislav
 */
public interface AddressStorage {

    public int putAddressInDB(Address address);

    public Address getAddressFromDB(int id)  throws DALException;

    public void updateAddress(Address address, int id);

    public void clearAllAddresses();

    public void putAddressesInDB(LinkedList<Address> addresses) throws DALException;
}
