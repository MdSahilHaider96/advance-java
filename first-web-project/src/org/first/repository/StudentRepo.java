package org.first.repository;


import org.first.model.Student;
import org.first.sql.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private static Connection connection;
 public static void Create(String name , String email) throws Exception{
     connection= ConnectionUtil.openConnection();
     PreparedStatement preparedStatement = null;
     try{
         String query = "INSERT into student2 (name , email) VALUES (?,?)";
         preparedStatement.setString(1,name);
         preparedStatement.setString(2,email);
         int executeUpdate = preparedStatement.executeUpdate();
         if (executeUpdate > 0){
             System.out.println("CREATED SUCCESSFULLY");
         }
         else {
             System.out.println("FAILED TO CREATE");
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
 }
    public static List<Student> findAll()throws Exception{
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List<Student> studentList = new ArrayList<>();
        try {
            String query ="SELECT * FROM student2";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Student student= new Student(id,name,email);
                studentList.add(student);
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
        return studentList;
    }
    public static void updateById(int id , String firstName,String middleName , String surName, String email, int age, String gender, int rollNo , int standard ,String fatherName , String schoolName ) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        // id, firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName

        try {
            String query="UPDATE student3 SET firstName = ? , middleName = ? , surName = ? , email = ? , age = ? , gender = ? , rollNo = ? , standard = ? , fatherName = ? , schoolName = ?   WHERE id=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,middleName);
            preparedStatement.setString(3,surName);
            preparedStatement.setString(4,email);
            preparedStatement.setInt(5,age);
            preparedStatement.setString(6,gender);
            preparedStatement.setInt(7,rollNo);
            preparedStatement.setInt(8,standard);
            preparedStatement.setString(9,fatherName);
            preparedStatement.setString(10,schoolName);
            preparedStatement.setInt(11,id);
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
            String query ="DELETE FROM student3 WHERE id=?";
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
