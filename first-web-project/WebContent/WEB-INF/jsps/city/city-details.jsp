<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>CITY Details </title>
        <%@ page import="org.first.model.City" %>
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
             <form action="cityDetails" method="GET">
                <h1>Store Details </h1>
                    <%
                        City city = (City)request.getAttribute("cityDetails");
                    %>
                     <div>
                        Id : <%= city.getId() %>
                        Name : <%=  city.getName() %>
                        State : <%= city.getState() %>
                        PinCode : <%= city.getPinCode() %>
                     </div>
                     <div>
                         <a href="/first-web-project/cityList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/cityCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>