<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Company Details </title>
        <%@ page import="org.first.model.Company" %>
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
             <form action="companyDetails" method="GET">
                <h1>Company Details </h1>
                    <%
                        Company company = (Company)request.getAttribute("companyDetails");
                    %>
                     <div>

                        Id : <%= company.getId() %>
                        Name : <%=  company.getName() %>
                        Location : <%= company.getLocation() %>
                        totalEmployees : <%= company.getTotalEmployees() %>
                        Email : <%= company.getEmail() %>
                        ContactNo : <%= company.getContactNo() %>

                     </div>
                     <div>
                         <a href="/first-web-project/companyList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/companyCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>