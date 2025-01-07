<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.User2" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="user2List" method="GET">
        <h1>User List</h1>
            <%
                List<User2> user2List = (List<User2>)request.getAttribute("user2List");
                if (user2List != null && !user2List.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>DOB</th>
                           </tr>
                    <%
                    for (User2 user2 : user2List) {
                        %>
                            <tr>
                                <td><%= user2.getId() %></td>
                                <td><%= user2.getName() %></td>
                                <td><%= user2.getEmail() %></td>
                                <td><%= user2.getDob() %></td>
                             <td> <a href="user2Details?id=<%= user2.getId() %>" class="button"> Details </a> </td>
                             <td><a href="user2Update?id=<%= user2.getId() %>" class="button"> Update </a></td>
                             <td><a href="user2Delete?id=<%= user2.getId() %>" class="button"> Delete </a></td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>User List is empty</h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/user2Create" class=" Create "> Create </a>
           </div>
           <div>
              <a href="/first-web-project/" class="button">Index</a>
           </div>
    </body>
</html>

