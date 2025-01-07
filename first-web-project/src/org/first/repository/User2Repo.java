package org.first.repository;


import org.first.model.User2;
import org.first.sql.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User2Repo {
        //user ( id , name , email  , dob)
        private static Connection connection = null;
    public static void create(String name,String email, java.sql.Date dob) throws Exception{
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        try {
            String query = "Insert INTO user2(name , email , dob) VALUES (?,?,?)";
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setDate(3,dob);
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0){
                System.out.println("Successfully Create");
            }
            else {
                System.out.println("Failed To Create");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            ConnectionUtil.closeConnection();
        }
    }
    public static void UpdateById(int id , String name , String email , java.sql.Date dob) throws Exception {
        connection=ConnectionUtil.openConnection();
        PreparedStatement preparedStatement=null;
        try {
            String query= "UPDATE user2 SET name= ? ,email= ? ,dob= ?  WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setDate(3,dob);
            preparedStatement.setInt(4,id);
            int executeUpdate = preparedStatement.executeUpdate();
            if(executeUpdate > 0){
                System.out.println("UPDATE SUCCESSFULLY");
            }
            else {
                System.out.println("FAILED TO UPDATE"+executeUpdate);
            }
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
        public static List<User2> findAll() throws Exception {
            connection = ConnectionUtil.openConnection();
            PreparedStatement pstatement = null;
            ResultSet rs = null;
            List<User2> userList = new ArrayList<>();
            try {
                String query = " select * from user2 ";
                pstatement = connection.prepareStatement(query);
                rs = pstatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String email = rs.getString(3);
                    Date dob =  rs.getDate(4);
                    User2 user = new User2(id, name, email, dob);
                    userList.add(user);
                }
            } catch (Exception e) {
                System.out.println("e");
            } finally {
                try {
                    if (pstatement != null) {
                        pstatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ConnectionUtil.closeConnection();
            }
            return userList;
        }
        public  static User2 findById(int id) throws Exception{
            connection = ConnectionUtil.openConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            User2 user = null;
            try {
                String query = "SELECT * FROM user2 WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    String name = resultSet.getString(2);
                    String email = resultSet.getString(3);
                    Date dob =  resultSet.getDate(4);
                    user = new User2(id, name, email, dob);
                }
                return user;
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ConnectionUtil.closeConnection();
            }
        }

        public static void DeleteById(int id)throws Exception{
            connection=ConnectionUtil.openConnection();
            PreparedStatement preparedStatement=null;
            try{
                String query ="DELETE FROM user2 WHERE id=?";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setInt(1,id);
                int Delete=preparedStatement.executeUpdate();
                if (Delete > 0){
                    System.out.println("DELETE SUCCESSFULLY");
                }
                else {
                    System.out.println("Failed to DELETE");
                }
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


