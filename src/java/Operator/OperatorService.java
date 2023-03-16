/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import Schedule.Schedule;
import java.util.List;
import javax.servlet.http.Part;
import shared.FileUploader;

/**
 *
 * @author toten
 */
public class OperatorService {
    
    private final OperatorDAO dao = new OperatorDAO();
    
    public void registerOperator(
            List<Operator> operator, 
            List<Part> activitiesParts,
            List<Part> billParts,
            String subName,
            String path
    ) {
        List<Operator> addedOperators = dao.addOperator(operator);
        FileUploader.uploadImages(activitiesParts, subName, path);
        FileUploader.uploadImages(billParts, subName, path);
    }
    
    public List<Operator> getOperatorsByProgramId(int programId) {
        return dao.getOperatorsByProgramId(programId);
    }
}
