/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Address;
import com.bradley.payroll.domain.Contact;
import com.bradley.payroll.domain.Demographics;
import com.bradley.payroll.domain.Names;

/**
 *
 * @author Balla
 */
public class InformationFactory {
    
    private static Contact contact;
    private static Address address;
    private static Names employeeNames;
    private static Demographics demographics;
    
    private InformationFactory() {
    }
    
    public static Contact getContact(){
        if(contact == null){
            contact = new Contact();
        }
        
        return contact;
    }
    
    public static Address getAddress(){
        if(address == null){
            address = new Address();
        }
        
        return address;
    }
    
    public static Names getNames(){
        if(employeeNames == null){
            employeeNames = new Names();
        }
        
        return employeeNames;
    }
    
    public static Demographics getDemographics(){
        if(demographics == null){
            demographics = new Demographics();
        }
        
        return demographics;
    }
}
