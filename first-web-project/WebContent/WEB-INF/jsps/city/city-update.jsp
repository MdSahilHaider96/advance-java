<html>

    <%@ page import="org.first.model.City" %>
 <body>
<h1> CITY UPDATE  <h1>
<form action="cityUpdate" method="POST">
            <% City city = (City)request.getAttribute("city");
            %>
            <div>
            <input type="hidden" name="id" value="<%= city.getId() %>">
		    </div>
		  <div>
		    <label for="name">Name:</label>
		    <input type="text" name="name" value="<%= city.getName() %>">
		  </div>

		  <div>
		    <label for="state">State :</label>
            <input type="text" name="state" value="<%= city.getState() %>">
          </div>

          <div>  <label for="pinCode">Email:</label>
 		     <input type="text" name="pinCode" value="<%= city.getPinCode() %>">
 		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= city.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>