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
@Builder
@Getter
@Setter
@ToString
public class Operator {
    private int operatorId;
    private int programId;
    private String operatorDate;
    private String operatorDetailDes;
    private double actualExpense;
    private List<OperatorImage> activiesImgs;
    private List<OperatorImage> billImgs;

}
