package org.first.repository;

import org.first.model.Store;
import org.first.model.Student;
import org.first.sql.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreRepo {
    // String firstName, String lastName, String email, String address, String phnNo, String totalBill
    private static Connection connection;
    public static void  create ( String firstName, String lastName, String email,  String address, String phnNo, String totalBill) throws Exception {
        connection= ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        try {
            String query = "INSERT into store ( firstName , lastName, email , address , phnNo , totalBill ) VALUES (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, phnNo);
            preparedStatement.setString(6,totalBill);
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0){
                System.out.println("CREATED");
            }
            else {
                System.out.println("FAILED");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        ConnectionUtil.closeConnection();
    }
    public static List<Store> findAll()throws Exception{
        //    // String firstName, String lastName, String email, String address, String phnNo, String totalBill
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<Store> storeList = new ArrayList<>();
        try {
            String query ="SELECT * FROM store";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String address = resultSet.getString(5);
                String phnNo = resultSet.getString(6);
                String totalBill = resultSet.getString(7);
                Store store= new Store(id, firstName, lastName, email, address, phnNo ,totalBill );
                storeList.add(store);
            }
        }

        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionUtil.closeConnection();
        }
        return storeList;
    }
    public static Store findById(int id) throws Exception{
        //    // String firstName, String lastName, String email, String address, String phnNo, String totalBill
        connection = ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Store store = null;
        try {
            String query = "SELECT * FROM store WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String address = resultSet.getString(5);
                String phnNo = resultSet.getString(6);
                String totalBill = resultSet.getString(7);
                store = new Store(id , firstName , lastName , email , address , phnNo , totalBill);
            }
            return store;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionUtil.closeConnection();
        }
    }
    public static void updateById(int id , String firstName, String lastName, String email, String address, String phnNo, String totalBill) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        //    // String firstName, String lastName, String email, String address, String phnNo, String totalBill

        try {
            String query="UPDATE store SET firstName = ? , lastName = ? , email = ? , address = ? , phnNo = ? , totalBill = ? WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,phnNo);
            preparedStatement.setString(6,totalBill);
            preparedStatement.setInt(7,id);
            int executeUpdate = preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement !=null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        ConnectionUtil.closeConnection();
    }

    public static void deleteById(int id)throws Exception{
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        try{
            String query ="DELETE FROM store WHERE id=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int Delete=preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        ConnectionUtil.closeConnection();
    }
}
