/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donate;

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
public class DonateVO extends Donate {
    private String name;
    private String programName;

    public DonateVO(int donate_id, int user_id, int program_id, double amount, String donate_date, String message) {
        super(donate_id, user_id, program_id, amount, donate_date, message);
    }
    
     public DonateVO(int donate_id, int user_id, int program_id, double amount, String donate_date, String message, String name) {
        super(donate_id, user_id, program_id, amount, donate_date, message);
        this.name=name;
    }
      public DonateVO(int donate_id, int user_id, int program_id, double amount, String donate_date, String message,String name, String programName) {
        super(donate_id, user_id, program_id, amount, donate_date, message);
        this.name=name;
        this.programName=programName;
    }
    
}
