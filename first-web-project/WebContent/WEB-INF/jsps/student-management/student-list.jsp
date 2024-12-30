<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>INDEX</title>
        <%@ page import= "org.first.web.studentManagement.Model.Student" %>
        <%@ page import="java.util.List" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
            button {
                          font: bold 11px Arial;
                          text-decoration: none;
                          background-color: #EEEEEE;
                          color: #333333;
                          padding: 2px 6px 2px 6px;
                          border-top: 1px solid #CCCCCC;
                          border-right: 1px solid #333333;
                          border-bottom: 1px solid #333333;
                          border-left: 1px solid #CCCCCC;
                        }
            </style>

    </head>
    <body>
     <form action="studentList" method="POST">
        <h1>Students List</h1>
         <a href="create-student" class="button">Create</a>
           <%
                List<Student> studentList = (List<Student>)request.getAttribute("studentList");
                if (studentList != null && !studentList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>FirstName</th>
                                <th>MiddleName</th>
                                <th>SurName</th>
                                <th>Email</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>RollNo</th>
                                <th>Standard</th>
                                <th>FatherName</th>
                                <th>SchoolName</th>
                            </tr>
                    <%
                    for (Student student: studentList) {
                        %>
                            <tr>
                                <td><%= student.getId() %></td>
                                <td><%= student.getFirstName() %></td>
                                <td><%= student.getMiddleName() %></td>
                                <td><%= student.getSurName() %></td>
                                <td><%= student.getEmail() %></td>
                                <td><%= student.getAge() %></td>
                                <td><%= student.getGender() %></td>
                                <td><%= student.getRollNo() %></td>
                                <td><%= student.getStandard() %></td>
                                <td><%= student.getFatherName() %></td>
                                <td><%= student.getSchoolName() %></td>
                            </tr>

                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>Student List is empty</h2>
                    <%
                }
            %>

    </body>
</html>

