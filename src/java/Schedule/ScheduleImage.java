
package Schedule;

import Image.Image;
import java.io.File;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScheduleImage extends Image {
    private int scheduleId;
    
    public ScheduleImage(int id, int scheduleId, String path) {
        super(id, path);
        this.scheduleId = scheduleId;
    }
    
    public static void main(String[] args) {
        System.out.println(File.separatorChar);
    }
}
