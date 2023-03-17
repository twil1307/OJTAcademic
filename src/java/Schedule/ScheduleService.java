/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.List;
import javax.servlet.http.Part;
import shared.FileUploader;

/**
 *
 * @author toten
 */
public class ScheduleService {
    private final ScheduleDAO scheduleDao = new ScheduleDAO();
    
    public void registerSchedule(
        List<Schedule> schedules, 
        List<Part> scheduleImageParts, 
        String subName,
        String path
    ) {
        List<Schedule> addedSchedules = scheduleDao.addSchedule(schedules);
        
        FileUploader.uploadImages(scheduleImageParts, subName, path);
    }
    
    public void updateSchedule(
        List<Schedule> schedules, 
        List<Part> scheduleImageParts, 
        String subName,
        String path,
        boolean isNewlyAdded
    ) {
        scheduleDao.updateSchedule(schedules, isNewlyAdded);
        
        if (scheduleImageParts.size() > 0) {
            FileUploader.uploadImages(scheduleImageParts, subName, path);
        }
    }
    
    public List<Schedule> getSchedulesByProgramId(int programId) {
        return scheduleDao.getSchedulesByProgramId(programId);
    }
}
