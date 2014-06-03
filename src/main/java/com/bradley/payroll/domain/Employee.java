/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author bradley
 */
@Entity 
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberOfDependants;
    private Integer employeeNumber;
    @Embedded
    private Address address;
    @Embedded
    private Contact contact;
    @Embedded
    private Names employeeNames;
    @Embedded
    private Demographics demographics;
    @OneToMany
    @JoinColumn(name="EmployeeID")
    private List<PaySlip> paySlipList;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="EmployeeID")
    private List<IdentityDocument> identityList;
    @OneToOne
    @JoinColumn(name="EmployeeID")
    private Position position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfDependants() {
        return numberOfDependants;
    }

    public void setNumberOfDependants(Integer numberOfDependants) {
        this.numberOfDependants = numberOfDependants;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Names getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(Names employeeNames) {
        this.employeeNames = employeeNames;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public List<PaySlip> getPaySlipList() {
        return paySlipList;
    }

    public void setPaySlipList(List<PaySlip> paySlipList) {
        this.paySlipList = paySlipList;
    }

    public List<IdentityDocument> getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List<IdentityDocument> identityList) {
        this.identityList = identityList;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Employee[ id=" + id + " ]";
    }
    
}
