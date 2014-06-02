/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Entries;
import com.bradley.payroll.domain.TaxTable;

/**
 *
 * @author Balla
 */
public class TaxTableFactory {
    private static TaxTable taxTable;
    private static Entries entries;
    
    private TaxTableFactory(){
    }
    
    public TaxTable getTaxTable(){
        if(taxTable == null){
            taxTable = new TaxTable();
        }
        
        return taxTable;
    }
    
    public Entries getEntries(){
        if(entries == null){
            entries = new Entries();
        }
        
        return entries;
    }
}
