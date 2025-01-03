package org.first.repository;

import org.first.model.Company;
import org.first.sql.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanyRepo {
    ////id , name , location , totalEmployees , email , contactNo
    private static Connection connection;
    public static void  create ( String name , String location, String totalEmployees,  String email, String contactNo ) throws Exception {
        connection= ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        try {
            String query = "INSERT into company ( name , location , totalEmployees , email ,contactNo ) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location );
            preparedStatement.setString(3, totalEmployees);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, contactNo);
            int executeUpdate = preparedStatement.executeUpdate();
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
    public static List<Company> findAll()throws Exception{
////id , name , location , totalEmployees , email , contactNo
         connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<Company> companyList = new ArrayList<>();
        try {
            String query ="SELECT * FROM company";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String location = resultSet.getString(3);
                String totalEmployees = resultSet.getString(4);
                String email = resultSet.getString(5);
                String contactNo = resultSet.getString(6);
                Company company = new Company(id, name, location , totalEmployees , email , contactNo );
                companyList.add(company);
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
        return companyList;
    }
    public static Company findById(int id) throws Exception{
        //id , name , location , totalEmployees , email , contactNo
        connection = ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Company company = null;
        try {
            String query = "SELECT * FROM company WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                String location = resultSet.getString(3);
                String totalEmployees = resultSet.getString(4);
                String email = resultSet.getString(5);
                String contactNo = resultSet.getString(6);
                company  = new Company(id , name , location , totalEmployees ,email ,  contactNo );
            }
            return company;
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
    public static void updateById(int id , String name , String location, String totalEmployees,  String email, String contactNo ) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        //id , name , location , totalEmployees , email ,  contactNo

        try {
            String query="UPDATE company SET name = ? , location = ? , totalEmployees = ? , email = ? , contactNo = ? WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,location);
            preparedStatement.setString(3,totalEmployees);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,contactNo);
            preparedStatement.setInt(6,id);
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
            String query ="DELETE FROM company WHERE id=?";
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
