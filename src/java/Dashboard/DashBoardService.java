/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

/**
 *
 * @author toten
 */
public class DashBoardService {
    DashBoardDAO dao = new DashBoardDAO();
    
    public long getTotal(String totalCase) {
        return dao.getTotal(totalCase);
    }
    
    public long getTotalGoal() {
        return dao.getTotalGoal();
    }
    
    
}
