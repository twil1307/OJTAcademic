/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investor;

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
public class Investor {
    private int investorId;
    private int programId;
    private String investorName;
    private String investorImg;
    private String investorDes;
    private String contact;
    private String qualifyImg;
    private String legalRepresent;
}
