<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Employees Details </title>
        <%@ page import="org.first.model.Employees" %>
         <style>
         button {
             font: bold 11px Arial;
             text-decoration: none;
             background-color: #EEEEEE;
             color: #333333;
             padding: 2px 6px 2px 6px;
             border-top: 1px solid #CCCCCC;
             border-right: 1px solid #333333;
             border-bottom: 1px solid #333333;
             border-left: 1px solid #CCCCCC;}
         </style>
        </head>
            <body>
             <form action="employeesDetails" method="GET">
                <h1>Employees Details </h1>
                    <%
                        Employees employees = (Employees)request.getAttribute("employeesDetails");
                    %>
                     <div>
                        Id : <%= employees.getId() %>
                        FirstName : <%=  employees.getFirstName() %>
                        LastName : <%= employees.getLastName() %>
                        UserName : <%= employees.getUserName() %>
                        Password : <%= employees.getPassword() %>
                        Address : <%= employees.getAddress() %>
                        ContactNo : <%= employees.getContactNo() %>

                     </div>
                     <div>
                         <a href="/first-web-project/employeesList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/employeesCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>