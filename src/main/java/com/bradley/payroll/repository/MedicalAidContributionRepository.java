/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.repository;

import com.bradley.payroll.domain.MedicalAidContribution;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Balla
 */
public interface MedicalAidContributionRepository extends JpaRepository<MedicalAidContribution, Long>{
    
}
