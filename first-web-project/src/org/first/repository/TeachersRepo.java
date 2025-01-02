package org.first.repository;

import org.first.model.Student;
import org.first.model.Teachers;
import org.first.sql.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeachersRepo {
    private static Connection connection;
    //int id, String firstName, String middleName, String surName, String emailId, int age, int gender, String specialisation, String schoolName
    public static void create(String firstName, String middleName, String surName, String emailId, int age, String gender, String specialisation, String schoolName)throws  Exception{
        PreparedStatement preparedStatement =  null;
        connection = ConnectionUtil.openConnection();
        try{
            String query =  "INSERT into teachers(firstName , middleName , surName , emailId , age , gender , specialisation , schoolName) VALUES (?, ? , ? , ? , ? , ? , ? , ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, surName);
            preparedStatement.setString(4, emailId);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, specialisation);
            preparedStatement.setString(8, schoolName);
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0){
                System.out.println("Create SuccessFully");
            }
            else {
                System.out.println("Failed to create");
            }
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
    public static List<Teachers> findAll() throws Exception{

        // String firstName, String middleName, String surName, String emailId, int age, String gender, String specialisation, String schoolName

            connection=ConnectionUtil.openConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            List<Teachers> teachersList = new ArrayList<>();
            try {
                String query ="SELECT * FROM teachers";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String middleName = resultSet.getString(3);
                    String surName = resultSet.getString(4);
                    String emailId = resultSet.getString(5);
                    int age = resultSet.getInt(6);
                    String gender = resultSet.getString(7);
                    String specialisation = resultSet.getString(8);
                    String schoolName = resultSet.getString(9);
                    Teachers teachers= new Teachers(id, firstName , middleName , surName , emailId , age , gender ,specialisation , schoolName);
                    teachersList.add(teachers);
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
       return teachersList;
    }

    public static  Teachers findById(int id) throws Exception{
        connection = ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        Teachers teachers = null;
        try{
            String query = "SELECT * FROM teachers WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
  // String firstName, String middleName, String surName, String emailId, int age, String gender, String specialisation, String schoolName
           if (resultSet.next()){
               String firstName =  resultSet.getString(2);
               String middleName =  resultSet.getString(3);
               String surName =  resultSet.getString(4);
               String emailId =  resultSet.getString(5);
               int age =  resultSet.getInt(6);
               String gender =  resultSet.getString(7);
               String specialisation =  resultSet.getString(8);
               String schoolName =  resultSet.getString(9);
               teachers = new Teachers(id, firstName , middleName , surName , emailId , age , gender , specialisation , schoolName );
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
        return teachers;
    }
    // firstName , middleName , surName ,  emailId , age , gender , specialisation , schoolName
    public static void updateById(int id , String firstName, String middleName , String surName, String emailId, int age, String gender,String specialisation , String schoolName ) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        // id, firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName

        try {
            String query="UPDATE teachers SET firstName = ? , middleName = ? , surName = ? , emailId = ? , age = ? , gender = ? , specialisation = ? , schoolName = ?  WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,middleName);
            preparedStatement.setString(3,surName);
            preparedStatement.setString(4,emailId);
            preparedStatement.setInt(5,age);
            preparedStatement.setString(6,gender);
            preparedStatement.setString(7,specialisation);
            preparedStatement.setString(8,schoolName);
            preparedStatement.setInt(9,id);
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
            String query ="DELETE FROM teachers WHERE id=?";
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
