/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Donate;

import java.util.Date;
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
public class Donate {
    private int donate_id;
    private int user_id;
    private int program_id;
    private double amount;
    private Date donate_date;
    private String message;
}
