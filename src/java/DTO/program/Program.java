/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.program;

import java.util.Date;
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
public class Program {
    private int program_id;
    private String program_name;
    private String short_des;
    private String detail_des;
    private double raised_amount;
    private double goal_amount;
    private Date start_date;
    private Date end_date;
    private String city;
    private String province;
    private String address;
    private Date sche_start_date;
    private Date sche_end_date;
    private int user_id;

    public Program(int program_id, String program_name, String short_des, String detail_des, double raised_amount, double goal_amount, Date start_date, Date end_date, String city, String province, String address, Date sche_start_date, Date sche_end_date, int user_id) {
        this.program_id = program_id;
        this.program_name = program_name;
        this.short_des = short_des;
        this.detail_des = detail_des;
        this.raised_amount = raised_amount;
        this.goal_amount = goal_amount;
        this.start_date = start_date;
        this.end_date = end_date;
        this.city = city;
        this.province = province;
        this.address = address;
        this.sche_start_date = sche_start_date;
        this.sche_end_date = sche_end_date;
        this.user_id = user_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getShort_des() {
        return short_des;
    }

    public void setShort_des(String short_des) {
        this.short_des = short_des;
    }

    public String getDetail_des() {
        return detail_des;
    }

    public void setDetail_des(String detail_des) {
        this.detail_des = detail_des;
    }

    public double getRaised_amount() {
        return raised_amount;
    }

    public void setRaised_amount(double raised_amount) {
        this.raised_amount = raised_amount;
    }

    public double getGoal_amount() {
        return goal_amount;
    }

    public void setGoal_amount(double goal_amount) {
        this.goal_amount = goal_amount;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSche_start_date() {
        return sche_start_date;
    }

    public void setSche_start_date(Date sche_start_date) {
        this.sche_start_date = sche_start_date;
    }

    public Date getSche_end_date() {
        return sche_end_date;
    }

    public void setSche_end_date(Date sche_end_date) {
        this.sche_end_date = sche_end_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Program{" + "program_id=" + program_id + ", program_name=" + program_name + ", short_des=" + short_des + ", detail_des=" + detail_des + ", raised_amount=" + raised_amount + ", goal_amount=" + goal_amount + ", start_date=" + start_date + ", end_date=" + end_date + ", city=" + city + ", province=" + province + ", address=" + address + ", sche_start_date=" + sche_start_date + ", sche_end_date=" + sche_end_date + ", user_id=" + user_id + '}';
    }
    
    
    
}
