/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Balla
 */
@Entity
public class Benefits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String benefitType;
    private BigDecimal benefitValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public BigDecimal getBenefitValue() {
        return benefitValue;
    }

    public void setBenefitValue(BigDecimal benefitValue) {
        this.benefitValue = benefitValue;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benefits)) {
            return false;
        }
        Benefits other = (Benefits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.payroll.domain.Benefits[ id=" + id + " ]";
    }
    
}
