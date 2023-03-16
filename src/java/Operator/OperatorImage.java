/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import Image.Image;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author toten
 */
@Getter
@Setter
@ToString
public class OperatorImage extends Image {
    private int operatorId;
    
    public OperatorImage(int id, int operatorId, String path) {
        super(id, path);
        this.operatorId = operatorId;
    }
    
    
}