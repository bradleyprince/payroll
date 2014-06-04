/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.repository;

import com.bradley.payroll.domain.Entries;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Balla
 */
public interface EntriesRepository extends JpaRepository<Entries, Long>{
    
}
