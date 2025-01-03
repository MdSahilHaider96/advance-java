<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Car Details </title>
        <%@ page import="org.first.model.Car" %>
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
             <form action="carDetails" method="GET">
                <h1>Car Details </h1>
                    <%
                        Car car = (Car)request.getAttribute("carDetails");
                    %>
                     <div>
                        Id : <%= car.getId() %>
                        Model : <%=  car.getModel() %>
                        Company : <%= car.getCompany() %>
                        Engine : <%= car.getEngine() %>
                        Color : <%= car.getColor() %>
                        Type : <%= car.getType() %>
                     </div>
                     <div>
                         <a href="/first-web-project/carList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/carCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>