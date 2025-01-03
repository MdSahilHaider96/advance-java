<html>

    <%@ page import="org.first.model.Car" %>
 <body>
<h1> Car UPDATE  <h1>
<form action="carUpdate" method="POST">
            <% Car car = (Car)request.getAttribute("car");
            %>
            <div>
            <input type="hidden" name="id" value="<%= car.getId() %>">
		    </div>

		  <div>
		    <label for="model">Model :</label>
		    <input type="text" name="model" value="<%= car.getModel() %>">
		  </div>

		  <div>
		    <label for="company">Company :</label>
            <input type="text" name="company" value="<%= car.getCompany() %>">
          </div>

          <div>  <label for="engine">Engine :</label>
 		     <input type="text" name="engine" value="<%= car.getEngine() %>">
 		   </div>

 		   <div>  <label for="color">Color :</label>
 		     <input type="text" name="color" value="<%= car.getColor() %>">
 		   </div>

 		    <div>  <label for="type">Type :</label>
 		     <input type="text" name="type" value="<%= car.getType() %>">
 		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= car.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>