<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Employees" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="employeesList" method="GET">
        <h1>Employees List</h1>
            <%
                List<Employees> employeesList = (List<Employees>)request.getAttribute("employeesList");
                if (employeesList != null && !employeesList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>Address</th>
                                <th>Contact No</th>
                            </tr>
                    <%
                    for (Employees employees : employeesList) {
                        %>
                            <tr>
                                <td><%= employees.getId() %></td>
                                <td><%= employees.getFirstName() %></td>
                                <td><%= employees.getLastName() %></td>
                                <td><%= employees.getUserName() %></td>
                                <td><%= employees.getPassword() %></td>
                                <td><%= employees.getAddress() %></td>
                                <td><%= employees.getContactNo() %></td>
                                <td><a href="employeesDetails?id=<%= employees.getId() %>" class="button"> Details </a></td>
                                <td><a href="employeesUpdate?id=<%= employees.getId() %>" class="button"> Update </a></td>
                                <td><a href="employeesDelete?id=<%= employees.getId() %>" class="button"> Delete </a></td>

                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>Employees List is empty</h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/employeesCreate" class=" Create "> Create </a>
           </div>
    </body>
</html>

