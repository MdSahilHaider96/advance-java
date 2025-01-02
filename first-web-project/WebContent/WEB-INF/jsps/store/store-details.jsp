<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Store Details </title>
        <%@ page import="org.first.model.Store" %>
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
             <form action="storeDetails" method="GET">
                <h1>Store Details </h1>
                    <%
                        Store store = (Store)request.getAttribute("storeDetails");
                    %>
                     <div>
                        Id : <%= store.getId() %>
                        FirstName : <%=  store.getFirstName() %>
                        LastName : <%= store.getLastName() %>
                        Email : <%=store.getEmail() %>
                        Address : <%=  store.getAddress()  %>
                        Phone No : <%= store.getPhnNo() %>
                        Total Bill : <%=  store.getTotalBill()  %>

                     </div>
                     <div>
                         <a href="/first-web-project/storeList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/storeCreate" class=" Create "> Create </a>
                     </div>
            </body>
</html>