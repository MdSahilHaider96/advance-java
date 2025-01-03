<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Community Details </title>
        <%@ page import="org.first.model.Community" %>
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
             <form action="communityDetails" method="GET">
                <h1>Community Details </h1>
                    <%
                        Community community = (Community)request.getAttribute("communityDetails");
                    %>
                     <div>
                        Id : <%= community.getId() %>
                        First Name : <%=  community.getFirstName() %>
                        Last Name : <%= community.getLastName() %>
                        Address : <%= community.getAddress() %>
                        Gender : <%= community.getGender() %>
                        ContactNo : <%= community.getContactNo() %>

                     </div>
                     <div>
                         <a href="/first-web-project/communityList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/communityCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>