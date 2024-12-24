package org.first.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionutil {
        public static final String dbURL = "jdbc:mysql://localhost:3306/studentdb?";
        public static final String  user = "root";
        public static final String  password = "root";
        public static Connection connection;

        public static Connection openConnection() throws Exception{
            try {
                connection = DriverManager.getConnection(dbURL,user,password);
                if(connection != null){
                    System.out.println("Connection Successfull");
                }
                return connection;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                throw new Exception("Unable to Connect");
            }
        }
        public static boolean closeConnection() throws Exception{
            try {
                connection.close();
                return true;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                throw new Exception("Unable to Close Connection");
            }
        }
}

