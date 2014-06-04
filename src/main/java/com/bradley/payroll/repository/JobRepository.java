/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.repository;


import com.bradley.payroll.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Balla
 */
public interface JobRepository extends JpaRepository<Job, Long>{
    
}
