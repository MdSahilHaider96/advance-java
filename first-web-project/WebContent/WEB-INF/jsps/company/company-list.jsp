<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Company" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="companyList" method="GET">
        <h1>COMPANY List</h1>
            <%
                List<Company> companyList = (List<Company>)request.getAttribute("companyList");
                if (companyList != null && !companyList.isEmpty()) {
                    %>
                        <table>
                            <tr>

                                <th>Id</th>
                                <th> Name</th>
                                <th Name</th>
                                <th>Location</th>
                                <th>TotalEmployees</th>
                                <th>Email</th>
                                <th>Contact No</th>
                            </tr>
                    <%
                    for (Company company : companyList) {
                        %>
                            <tr>
                                <td><%= company.getId() %></td>
                                <td><%= company.getName() %></td>
                                <td><%= company.getLocation() %></td>
                                <td><%= company.getTotalEmployees() %></td>
                                <td><%= company.getEmail() %></td>
                                <td><%= company.getContactNo() %></td>
                                <td><a href="companyDetails?id=<%= company.getId() %>" class="button"> Details </a></td>
                                <td><a href="companyUpdate?id=<%= company.getId() %>" class="button"> Update </a></td>
                                <td><a href="companyDelete?id=<%= company.getId() %>" class="button"> Delete </a></td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2> Commpany List is empty </h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/companyCreate" class=" Create "> Create </a>
           </div>
    </body>
</html>

