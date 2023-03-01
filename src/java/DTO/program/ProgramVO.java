/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.program;

//import lombok.Builder;

import java.util.Date;
import java.util.List;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

/**
 *
 * @author toten
 */
//@Builder
//@Getter
//@Setter
//@ToString
public class ProgramVO extends Program {
    
    private List<String> programImg;
    
    public ProgramVO(int program_id, String program_name, String short_des, String detail_des, double raised_amount, double goal_amount, Date start_date, Date end_date, String city, String province, String address, Date sche_start_date, Date sche_end_date, int user_id) {
        super(program_id, program_name, short_des, detail_des, raised_amount, goal_amount, start_date, end_date, city, province, address, sche_start_date, sche_end_date, user_id);
    }

    public ProgramVO(int program_id, String program_name, String short_des, String detail_des, double raised_amount, double goal_amount, Date start_date, Date end_date, String city, String province, String address, Date sche_start_date, Date sche_end_date, int user_id, List<String> programImg) {
        super(program_id, program_name, short_des, detail_des, raised_amount, goal_amount, start_date, end_date, city, province, address, sche_start_date, sche_end_date, user_id);
        this.programImg = programImg;
    }

    public List<String> getProgramImg() {
        return programImg;
    }

    public void setProgramImg(List<String> programImg) {
        this.programImg = programImg;
    }
    
    
    
}
