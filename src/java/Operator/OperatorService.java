/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import Image.ImageDAO;
import java.util.List;
import javax.servlet.http.Part;
import shared.FileUploader;

/**
 *
 * @author toten
 */
public class OperatorService {

    private final OperatorDAO dao = new OperatorDAO();
    private final ImageDAO imgDao = new ImageDAO();

    public void registerOperator(
            List<Operator> operator,
            List<Part> activitiesParts,
            List<Part> billParts,
            String subName,
            String path,
            String[] unChangedActivitiesProgram,
            String[] unChangedBillProgram,
            String[] unChangeOperatorId
    ) {

        dao.deleteOperatorByIds(operator);
        if (!operator.isEmpty()) {
            List<Operator> addedOperators = dao.addOperator(operator, unChangeOperatorId);
        }
        FileUploader.uploadImages(activitiesParts, subName, path);
        FileUploader.uploadImages(billParts, subName, path);
    }

    public List<Operator> getOperatorsByProgramId(int programId) {
        return dao.getOperatorsByProgramId(programId);
    }
    
    public List<OperatorVO> getOperatorsHome() {
        return dao.getOperatorsHome();
    }
    
    public List<OperatorImage> getActivitiesImage(int operatorId) {
        return ImageDAO.getActivitiesImage(operatorId);
    }
    
    public List<OperatorImage> getBillsImage(int operatorId) {
        return ImageDAO.getBillsImage(operatorId);
    }

    void deleteMultipleOperator(String[] operatorIdDels) {
        dao.deleteMultipleOperator(operatorIdDels);
    }
}
