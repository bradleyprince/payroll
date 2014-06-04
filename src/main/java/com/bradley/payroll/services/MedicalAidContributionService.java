/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.services;

import java.math.BigDecimal;

/**
 *
 * @author Balla
 */
public interface MedicalAidContributionService {
    public BigDecimal getMedicalAidContribution(Integer numberOfDependants);
}
