<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Student" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="studentRegisteration" method="POST">
        <h1>Student List</h1>
            <%
                List<Student> studentList = (List<Student>)request.getAttribute("studentList");
                if (studentList != null && !studentList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Email</th>
                            </tr>
                    <%
                    for (Student student: studentList) {
                        %>
                            <tr>
                                <td><%= student.getId() %></td>
                                <td><%= student.getName() %></td>
                                <td><%= student.getEmail() %></td>
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
            <div>
                <a href="/first-web-project/" class="button">Index</a
           </div>
    </body>
</html>

