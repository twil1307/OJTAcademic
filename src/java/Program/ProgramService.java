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
    
    public int registerProgram(Program program, List<Part> programImageParts, String path) {
        int programId = dao.addProgram(program);

        List<String> imgList = FileUploader.uploadImages(programImageParts, program.getProgramName(), path);

        return programId;
    }
    
    public int updateProgram(Program program, List<Part> programImageParts, String path) {
        int result = dao.updateProgram(program);
        if (program.getProgramImgs().size() > 0) {
            FileUploader.uploadImages(programImageParts, program.getProgramName(), path);
        }
        
        return result;
    }

    public Program getProgramById(int programId) {
        return dao.getProgram(programId);
    }

    int getTotalProgram() {
        return dao.getTotalProgram();
    }

    List<Program> getListProgram(int beginElement, int PAGE_SIZE) {
        return dao.getListProgram(beginElement, PAGE_SIZE);
    }

    double getProgramRaisedAmount(int programId) {
        return dao.getProgramRaisedAmount(programId);
    }
    
    public void autoUpdate() {
        dao.autoUpdate();
    }
}
