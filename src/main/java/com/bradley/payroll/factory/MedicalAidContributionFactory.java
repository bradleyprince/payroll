/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.MedicalAidContribution;

/**
 *
 * @author Balla
 */
public class MedicalAidContributionFactory {
    private static MedicalAidContribution medicalAidContribution;

    private MedicalAidContributionFactory() {
    }
    
    public MedicalAidContribution getMedicalAidContribution(){
        if(medicalAidContribution == null){
            medicalAidContribution = new MedicalAidContribution();
        }
        
        return medicalAidContribution;
    }
}
