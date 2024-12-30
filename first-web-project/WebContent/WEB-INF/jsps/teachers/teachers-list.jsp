<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Teachers List</title>
        <%@ page import= "org.first.model.Teachers" %>
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
     <form action="teachers-list" method="POST">
        <h1>Teachers List </h1>
         <a href="create-teachers" class="button">Create</a>
           <%
                List<Teachers> teachersList = (List<Teachers>)request.getAttribute("teachersList");
                if (teachersList != null && !teachersList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>FirstName</th>
                                <th>MiddleName</th>
                                <th>SurName</th>
                                <th>EmailId</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Specialisation</th>
                                <th>SchoolName</th>
                                <th>Details</th>
                            </tr>
                    <%
                    for (Teachers teachers : teachersList) {
                        %>
                            <tr>
                                <td><%= teachers.getId() %></td>
                                <td><%= teachers.getFirstName() %></td>
                                <td><%= teachers.getMiddleName() %></td>
                                <td><%= teachers.getSurName() %></td>
                                <td><%= teachers.getEmailId() %></td>
                                <td><%= teachers.getAge() %></td>
                                <td><%= teachers.getGender() %></td>
                                <td><%= teachers.getSpecialisation() %></td>
                                <td><%= teachers.getSchoolName() %></td>
                                 <td>   <a href="teachers-details?id=<%= teachers.getId() %>" class="button"> Details </a> </td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>Teachers List is empty</h2>
                    <%
                }
            %>

    </body>
</html>

