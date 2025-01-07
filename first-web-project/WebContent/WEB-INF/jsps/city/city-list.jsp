<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.City" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="cityList" method="GET">
        <h1>City List</h1>
            <%
                List<City> cityList = (List<City>)request.getAttribute("cityList");
                if (cityList != null && !cityList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>State</th>
                                <th>PinCode</th>
                            </tr>
                    <%
                    for (City city : cityList) {
                        %>
                            <tr>
                                <td><%= city.getId() %></td>
                                <td><%= city.getName() %></td>
                                <td><%= city.getState() %></td>
                                <td><%= city.getPinCode() %></td>
                                <td><a href="cityDetails?id=<%= city.getId() %>" class="button"> Details </a></td>
                                <td><a href="cityUpdate?id=<%= city.getId() %>" class="button"> Update </a></td>
                                <td><a href="cityDelete?id=<%= city.getId() %>" class="button"> Delete </a></td>

                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>City List is empty</h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/cityCreate" class=" Create "> Create </a>
           </div>
           <div>
                <a href="/first-web-project/" class="button">Index</a>
           </div>
    </body>
</html>

