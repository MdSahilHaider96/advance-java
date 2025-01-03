package org.first.web.student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.first.model.Student;
import org.first.service.StudentService;
import org.first.sql.util.ConnectionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class StudentController extends HttpServlet {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static Connection connection;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoGET");
        String destination = "/WEB-INF/jsps/student/student-registration.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("DoPost");
        Statement st;
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        //TODO : SAVE INTO DATABASE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?","root","root");
            st = connection.createStatement();
            System.out.println("Connection Successfull");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            String query = "INSERT into student2 (name , email) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(query);
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
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        StudentService studentService = new StudentService();


        //fetch all student from db - list of students
        try {
            List<Student> studentList = studentService.findAll();
            System.out.println(studentList);

            req.setAttribute("studentList",studentList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //send this list to jsp
        String destination = "/WEB-INF/jsps/student/student-list.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
        requestDispatcher.forward(req,resp);
        try {
            ConnectionUtil.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
