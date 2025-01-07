<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Car Details </title>
        <%@ page import="org.first.model.User2" %>
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
             <form action="user2Details" method="GET">
                <h1>User Details </h1>
                    <%
                        User2 user2 = (User2)request.getAttribute("user2Details");
                    %>
                     <div>
                        Id : <%= user2.getId() %>
                     </div>
                     <div>
                        Name : <%=  user2.getName() %>
                      </div>
                      <div>
                        Email : <%= user2.getEmail() %>
                      </div>
                      <div>
                        DOB : <%= user2.getDob() %>
                     </div>

                         <a href="/first-web-project/user2List" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/user2Create" class=" Create "> Create </a>
                     </div>
            </body>
</html>