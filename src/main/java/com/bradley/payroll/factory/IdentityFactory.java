/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.IdentityDocument;


/**
 *
 * @author Balla
 */
public class IdentityFactory {
    private static IdentityDocument idDocument;
    
    private IdentityFactory(){
    }
    
    public static IdentityDocument getIdDocument(){
        if(idDocument == null){
           idDocument = new IdentityDocument();
        }
        
        return idDocument;
    }
}
