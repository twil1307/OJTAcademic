/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Schedule {
    private int schedule_id;
    private int program_id;
    private String date;
    private String detail_des;
    private List<ScheduleImage> imgPath;

    @Getter
    @Setter
    @AllArgsConstructor
    class ScheduleImage {
        private int id;
        private int scheduleId;
        private String path;
    }
}
