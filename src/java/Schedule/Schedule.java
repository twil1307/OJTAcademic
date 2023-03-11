/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;


import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class Schedule {
    private int schedule_id;
    private int program_id;
    private String date;
    private String detail_des;
    private List<ScheduleImage> imgPath;

}
