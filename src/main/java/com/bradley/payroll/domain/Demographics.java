/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Balla
 */
@Embeddable
public class Demographics implements Serializable{
    private String gender;
    private String race;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    } 
}
