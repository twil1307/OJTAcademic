/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import Donate.Donate;
import Program.Program;
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
public class DashBoard {
    private double totalAmountPerDay;
    private double totalAmountPerMonth;
    private double totalAmountDonate;
    private int programNumber;
    private int programCloseNumber;
    private List<Program> listProgram;
    private List<Donate> listDonate;
}
