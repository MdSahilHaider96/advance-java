<html>

    <%@ page import="org.first.model.Employees" %>
 <body>
<h1> EMPLOYEES UPDATE  <h1>
<form action="employeesUpdate" method="POST">
            <% Employees employees = (Employees)request.getAttribute("employees");
            %>
            <div>
            <input type="hidden" name="id" value="<%= employees.getId() %>">
		    </div>
		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName" value="<%= employees.getFirstName() %>">
		  </div>

		  <div>
		    <label for="lastName">Last Name :</label>
            <input type="text" name="lastName" value="<%= employees.getLastName() %>">
          </div>

          <div>
             <label for="userName">UserName:</label>
 		     <input type="text" name="userName" value="<%= employees.getUserName() %>">
 		   </div>

 		   <div>
 		     <label for="password">Password :</label>
 		     <input type="password" name="password" value="<%= employees.getPassword() %>">
 		   </div>

 		   <div>
 		     <label for="address">UserName:</label>
 		     <input type="text" name="address" value="<%= employees.getAddress() %>">
 		   </div>

 		   <div>
 		   <label for="contactNo">ContactNo :</label>
 		     <input type="text" name="contactNo" value="<%= employees.getContactNo() %>">
 		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= employees.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>