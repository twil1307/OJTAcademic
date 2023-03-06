/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.List;
import javax.servlet.http.Part;
import shared.FileUploader;

/**
 *
 * @author toten
 */
public class ProgramService {
    private ProgramDAO dao = new ProgramDAO();
    
    public void registerProgram(Program program, List<Part> programImageParts, String path) {
        dao.addProgram(program);

        List<String> imgList = FileUploader.uploadImages(programImageParts, program.getProgramName(), path, "img");
    
       
        System.out.println(imgList.get(0));
    }
}
