<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Car" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="carList" method="GET">
        <h1>Car List</h1>
            <%
                List<Car> carList = (List<Car>)request.getAttribute("carList");
                if (carList != null && !carList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Model</th>
                                <th>Company</th>
                                <th>Engine</th>
                                <th>Color</th>
                                <th>Type</th>
                            </tr>
                    <%
                    for (Car car : carList) {
                        %>
                            <tr>
                                <td><%= car.getId() %></td>
                                <td><%= car.getModel() %></td>
                                <td><%= car.getCompany() %></td>
                                <td><%= car.getEngine() %></td>
                                <td><%= car.getColor() %></td>
                                <td><%= car.getType() %></td>
                                <td><a href="carDetails?id=<%= car.getId() %>" class="button"> Details </a></td>
                                <td><a href="carUpdate?id=<%= car.getId() %>" class="button"> Update </a></td>
                                <td><a href="carDelete?id=<%= car.getId() %>" class="button"> Delete </a></td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>Car List is empty</h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/carCreate" class=" Create "> Create </a>
           </div>
           <div>
               <a href="/first-web-project/" class="button">Index</a>
           </div>
    </body>
</html>

