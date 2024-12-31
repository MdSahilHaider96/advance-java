package org.first.repository;

import jakarta.servlet.ServletContext;
import org.first.model.Store;
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
            String query ="SELECT * FROM Student2";
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
}
