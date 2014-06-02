/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.payroll.factory;

import com.bradley.payroll.domain.Position;

/**
 *
 * @author Balla
 */
public class PositionFactory {
    private static Position position;
    
    private PositionFactory(){
    }
    
    public static Position getPosition(){
        if(position == null){
            position = new Position();
        }
        
        return position;
    }
}
