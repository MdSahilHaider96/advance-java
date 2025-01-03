package org.first.repository;

import org.first.model.City;
import org.first.sql.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityRepo {
    private static Connection connection;
    //    // id , Name , State , pinCode
    public static void create(String name , String state , int pinCode)throws  Exception{
        PreparedStatement preparedStatement =  null;
        connection = ConnectionUtil.openConnection();
        try{
            String query =  "INSERT into city(name , state , pinCode ) VALUES (? , ? , ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,state);
            preparedStatement.setInt(3,pinCode);
            int executeUpdate = preparedStatement.executeUpdate();
        } catch (Exception e) {
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
        }
        ConnectionUtil.closeConnection();
    }
    public static List<City> findAll() throws Exception{

        //    // id , Name , State , pinCode

        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<City> cityList = new ArrayList<>();
        try {
            String query ="SELECT * FROM city";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String state = resultSet.getString(3);
                int pinCode = resultSet.getInt(4);
                City city = new City(id, name , state ,pinCode);
                cityList.add(city);
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
        return cityList;
    }

    public static  City findById(int id) throws Exception{
        connection = ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        City  city = null;
        try{
            String query = "SELECT * FROM city WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString(2);
                String state = resultSet.getString(3);
                int pinCode = resultSet.getInt(4);
                city = new City(id, name , state , pinCode );
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
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
        return city;
    }
    // firstName , middleName , surName ,  emailId , age , gender , specialisation , schoolName
    public static void updateById(int id , String name, String state , int pinCode) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        // id, firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName

        try {
            String query="UPDATE city SET name = ? , state = ? , pinCode = ?  WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,name);
           preparedStatement.setString(2,state);
            preparedStatement.setInt(3,pinCode);
            preparedStatement.setInt(4,id);
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
            String query ="DELETE FROM city WHERE id=?";
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
