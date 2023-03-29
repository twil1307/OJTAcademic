/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.List;
import java.util.Map;
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

    int getTotalProgram(Map<String, String> conditions) {
        return dao.getTotalProgram(conditions);
    }

    int getTotalProgramClosed(Map<String, String> conditions) {
        return dao.getTotalProgramClosed(conditions);
    }

    List<Program> getListProgram(int beginElement, int PAGE_SIZE) {
        return dao.getListProgram(beginElement, PAGE_SIZE);
    }

    public List<Program> getListProgramWithCondition(int beginElement, int size, Map<String, String> conditions) {
        return dao.getListProgramWithCondition(beginElement, size, conditions);
    }
    
    public List<Program> getListProgramClosedWithCondition(int beginElement, int size, Map<String, String> conditions) {
        return dao.getListProgramClosedWithCondition(beginElement, size, conditions);
    }
    
    
    

    public List<Program> getListProgramAllAvaiable() {
        return dao.getListProgramAllAvaiable();
    }

    double getProgramRaisedAmount(int programId) {
        return dao.getProgramRaisedAmount(programId);
    }

    public void autoUpdate() {
        dao.autoUpdate();
    }

    public void closeProgram(int programId) {
        dao.closeProgram(programId);
    }

    public void openProgram(int programId) {
        dao.openProgram(programId);
    }

    public double getGoalAmountAll(String statusCase) {
        return dao.getGoalAmountAll(statusCase);
    }

    public double getActutalAmountAll(String statusCase) {
        return dao.getActutalAmountAll(statusCase);
    }
}
