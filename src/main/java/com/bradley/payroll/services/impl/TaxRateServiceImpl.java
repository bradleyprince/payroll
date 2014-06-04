/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services.impl;

import com.bradley.payroll.domain.Entries;
import com.bradley.payroll.repository.EntriesRepository;
import com.bradley.payroll.services.TaxRateService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class TaxRateServiceImpl implements TaxRateService{

    @Autowired
    private EntriesRepository entriesRepo;
    
    @Override
    public Integer getTaxRate(BigDecimal grossPay) {
        List<Entries> entriesList = entriesRepo.findAll();
        Integer taxRate = 0;
        
        for(Entries entries : entriesList){ 
            if(grossPay != null){
                int lowerBand = grossPay.compareTo(entries.getLowerBand());
                int upperBand = grossPay.compareTo(entries.getUpperband());
                
                if((lowerBand == 0 || lowerBand == 1) && upperBand == -1){
                    taxRate = entries.getTaxPercentRate();
                }
            }
        }
        
        return taxRate;
    }
    
}
