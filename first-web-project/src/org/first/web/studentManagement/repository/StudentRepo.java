package org.first.web.studentManagement.repository;

import org.first.sql.util.ConnectionUtil;
import org.first.sql.util.ConnectionUtil;
import org.first.web.studentManagement.Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private static  Connection connection;
    //firstName , middleName , surName , email , age , gender , rollNo , standard , fatherName , schoolName
    public static void Create(String  firstName, String middleName, String surName, String email, int age, String gender, int rollNo, int standard , String fatherName, String schoolName) throws Exception{
        connection= ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        try{
            String query = "INSERT into student3 (firstName , middleName , surName , email , age , gender , rollNo , standard , fatherName , schoolName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement=connection.prepareStatement(query);
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
            int execureUpdate = preparedStatement.executeUpdate();
            if (execureUpdate > 0){
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
        ConnectionUtil.closeConnection();
    }
    public static List<Student> findAll() throws Exception{
        //String  firstName, String middleName, String surName, String email, int age, String gender, int rollNo, int standard , String fatherName, String schoolName)
        connection =  ConnectionUtil.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        try {
            String query = "SELECT * from student3";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =  resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String middleName = resultSet.getString(3);
                String surName = resultSet.getString(4);
                String email = resultSet.getString(5);
                int age = resultSet.getInt(6);
                String gender = resultSet.getString(7);
                int rollNo = resultSet.getInt(8);
                int standard = resultSet.getInt(9);
                String fatherName = resultSet.getString(10);
                String schoolName = resultSet.getString(11);
                Student student = new Student(id, firstName, middleName, surName, email, age, gender, rollNo, standard, fatherName, schoolName);
                studentList.add(student);
            }
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
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
}
