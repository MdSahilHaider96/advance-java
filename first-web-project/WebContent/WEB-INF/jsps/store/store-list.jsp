<html>
    <head>
        <%@ page import="java.util.List" %>
        <%@ page import="org.first.model.Store" %>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <form action="StoreList" method="GET">
        <h1>Store List</h1>
            <%
                List<Store> storeList = (List<Store>)request.getAttribute("storeList");
                if (storeList != null && !storeList.isEmpty()) {
                    %>
                        <table>
                            <tr>
                                <th>Id</th>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>PhnNo</th>
                                <th>TotalBill</th>
                            </tr>
                    <%
                    for (Store store : storeList) {
                        %>
                            <tr>
                                <td><%= store.getId() %></td>
                                <td><%= store.getFirstName() %></td>
                                <td><%= store.getLastName() %></td>
                                <td><%= store.getEmail() %></td>
                                <td><%= store.getAddress() %></td>
                                <td><%= store.getPhnNo() %></td>
                                <td><%= store.getTotalBill() %></td>
                                <td>   <a href="storeDetails?id=<%= store.getId() %>" class="button"> Details </a> </td>
                                <td>   <a href="storeUpdate?id=<%= store.getId() %>" class="button"> Update </a> </td>
                            </tr>
                        <%
                    }
                    %>
                        </table>
                    <%
                } else {
                    %>
                        <h2>Store List is empty</h2>
                    <%
                }
            %>
            <div>
                 <a href="/first-web-project/storeCreate" class=" Create "> Create </a>
           </div>
    </body>
</html>

