<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Community" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="communityList" method="GET">
        <h1>COMPANY List</h1>
            <%
                List<Community> communityList = (List<Community>)request.getAttribute("communityList");
                if (communityList != null && !communityList.isEmpty()) {
                    %>
                        <table>
                            <tr>

                                <th>Id</th>
                                <th> First Name</th>
                                <th Last Name</th>
                                <th>Address</th>
                                <th>Gender</th>
                                <th>Contact No</th>
                            </tr>
                    <%
                    for (Community community : communityList) {
                        %>
                            <tr>
                                <td><%= community.getId() %></td>
                                <td><%= community.getFirstName() %></td>
                                <td><%= community.getLastName() %></td>
                                <td><%= community.getAddress() %></td>
                                <td><%= community.getGender() %></td>
                                <td><%= community.getContactNo() %></td>
                                <td><a href="communityDetails?id=<%= community.getId() %>" class="button"> Details </a></td>
                                <td><a href="communityUpdate?id=<%= community.getId() %>" class="button"> Update </a></td>
                                <td><a href="communityDelete?id=<%= community.getId() %>" class="button"> Delete </a></td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2> Community List is empty </h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/communityCreate" class=" Create "> Create </a>
           </div>
    </body>
</html>

