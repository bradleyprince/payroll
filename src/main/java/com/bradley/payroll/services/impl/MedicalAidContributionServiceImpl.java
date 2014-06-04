/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services.impl;

import com.bradley.payroll.domain.MedicalAidContribution;
import com.bradley.payroll.repository.MedicalAidContributionRepository;
import com.bradley.payroll.services.MedicalAidContributionService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class MedicalAidContributionServiceImpl implements MedicalAidContributionService{

    @Autowired
    private MedicalAidContributionRepository medicalAidContributionRepository;
    
    @Override
    public BigDecimal getMedicalAidContribution(Integer numberOfDependants) {
        List<MedicalAidContribution> medicalAidContributionList = medicalAidContributionRepository.findAll();
        BigDecimal amountContributed = null;
        
        for(MedicalAidContribution medicalAidContribution : medicalAidContributionList){
            if(medicalAidContribution.getNumberOfPeople().compareTo(numberOfDependants) == 0){
                amountContributed = medicalAidContribution.getAmount();
            }
        }
        
        return amountContributed;
    }
    
}
