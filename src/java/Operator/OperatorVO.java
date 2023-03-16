/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import java.util.List;
import lombok.Builder;
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
public class OperatorVO extends Operator {
    private String operatorStartDate;
    private String operatorEndDate;

    public OperatorVO(int operatorId, int programId, String operatorDate, String operatorDetailDes, double actualExpense, List<OperatorImage> activiesImgs, List<OperatorImage> billImgs) {
        super(operatorId, programId, operatorDate, operatorDetailDes, actualExpense, activiesImgs, billImgs);
    }

   
    
    
    
}
