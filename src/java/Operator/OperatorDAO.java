/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import Image.ImageDAO;
import User.UserDAO;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class OperatorDAO {

    private final ImageDAO imageDao = new ImageDAO();

    public List<Operator> addOperator(List<Operator> operators, String[] unchangeOperatorId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        int index = 0;

        try {
            String query = "insert into operator values (?, ?, ?, ?)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            for (Operator operator : operators) {
                ps.setInt(1, operator.getProgramId());
                ps.setString(2, operator.getOperatorDate());
                ps.setString(3, operator.getOperatorDetailDes());
                ps.setDouble(4, operator.getActualExpense());
                ps.addBatch();
            }

            ps.executeBatch();
            if (unchangeOperatorId == null) {
                query = "select operator_id from operator where program_id=? order by operator_date asc";
            } else {
                query = getQueryNotIn(unchangeOperatorId);
            }
            ps = conn.prepareStatement(query);
            ps.setInt(1, operators.get(index).getProgramId());

            if (unchangeOperatorId != null) {
                for (int i = 0; i < unchangeOperatorId.length; i++) {
                    ps.setInt(i + 2, Integer.parseInt(unchangeOperatorId[i]));
                }
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Operator opratorAdd = operators.get(index);
                int operatorId = rs.getInt("operator_id");
                opratorAdd.setOperatorId(operatorId);

                opratorAdd.getActiviesImgs().forEach(imgPath -> imgPath.setOperatorId(operatorId));
                opratorAdd.getBillImgs().forEach(imgPath -> imgPath.setOperatorId(operatorId));
                imageDao.addImage(opratorAdd.getActiviesImgs(), "activies_img");
                imageDao.addImage(opratorAdd.getBillImgs(), "bill_img");
                index++;
            }

            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return operators;
    }

    public List<Operator> getOperatorsByProgramId(int programId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<Operator> operators = new ArrayList();
        ImageDAO imageDao = new ImageDAO();

        try {
            String query = "select * from operator where program_id=? order by operator_date asc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int operatorId = rs.getInt("operator_id");
                String operatorDate = rs.getString("operator_date");
                String detailDes = rs.getString("operator_detail_des");
                double actualExpense = rs.getDouble("actual_expense");
                Operator operator = Operator.builder()
                        .operatorId(operatorId)
                        .programId(programId)
                        .operatorDate(operatorDate)
                        .operatorDetailDes(detailDes.trim())
                        .actualExpense(actualExpense)
                        .build();

                List<OperatorImage> activitiesImages = (List<OperatorImage>) imageDao.getImages(operatorId, "activies_img");
                List<OperatorImage> billsImages = (List<OperatorImage>) imageDao.getImages(operatorId, "bill_img");
                operator.setActiviesImgs(activitiesImages);
                operator.setBillImgs(billsImages);
                operators.add(operator);
            }

            // close connection after execute query
            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operators;
    }

    public List<OperatorVO> getOperatorsHome() {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<OperatorVO> operators = new ArrayList();

        try {
            String query = "select top 4 opr.*, des.city, des.province, des.address from operator opr, program pr, destination des \n"
                    + "where opr.program_id = pr.program_id and pr.program_id=des.program_id order by operator_date asc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                int operatorId = rs.getInt("operator_id");
                int programId = rs.getInt("program_id");
                String operatorDate = rs.getString("operator_date");
                String detailDes = rs.getString("operator_detail_des");
                double actualExpense = rs.getDouble("actual_expense");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String address = rs.getString("address");
                OperatorVO operator = OperatorVO.builder()
                        .operatorId(operatorId)
                        .programId(programId)
                        .operatorDate(operatorDate)
                        .operatorDetailDes(detailDes.trim())
                        .actualExpense(actualExpense)
                        .city(city)
                        .province(province)
                        .address(address)
                        .build();
                
               
                List<OperatorImage> activitiesImages = (List<OperatorImage>) imageDao.getImages(operatorId, "activies_img");
                operator.setActiviesImgs(activitiesImages);
                operators.add(operator);
            }

            // close connection after execute query
            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operators;
    }

    public void deleteOperatorById(int programId) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "delete from operator where program_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteOperatorByIds(List<Operator> operators) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "delete from operator where operator_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            for (Operator operator : operators) {
                ps.setInt(1, operator.getOperatorId());
                ps.addBatch();
            }

            ps.executeBatch();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getQueryNotIn(String[] unChangedOperator) {
        String query = "select operator_id from operator where program_id=? ";

        if (unChangedOperator != null) {
            query += "and operator_id not in (";

            for (int i = 0; i < unChangedOperator.length; i++) {

                if (i == unChangedOperator.length - 1) {
                    query += " ?";
                } else {
                    query += " ?,";

                }

            }

            query += ")";
        }

        return query + " order by operator_date asc";

    }

    public static void main(String[] args) {
        OperatorDAO dao = new OperatorDAO();
        List<Operator> operators = new ArrayList<>();

//        operators.add(new Operator(0, 2143, "2023-11-11", "Desadwjoawidj awijd aow", 2000, null, null));
//        operators.add(new Operator(0, 2143, "2023-11-12", "Desadwjoawidj awijd aow", 2000, null, null));
//        operators.add(new Operator(0, 2143, "2023-11-13", "Desadwjoawidj awijd aow", 2000, null, null));
        String[] id = {"123", "125", "126"};

        System.out.println(dao.getQueryNotIn(id));

    }

    void deleteMultipleOperator(String[] operatorIdDels) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "delete from operator where operator_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            for (String id : operatorIdDels) {
                ps.setInt(1, Integer.parseInt(id));
                ps.addBatch();
            }

            ps.executeBatch();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
