<html>

    <%@ page import="org.first.model.Community" %>
 <body>
<h1> Community UPDATE  <h1>
<form action="communityUpdate" method="POST">
            <%
              Community community = (Community)request.getAttribute("community");
            %>
            <div>
            <input type="hidden" name="id" value="<%= community.getId() %>">
		    </div>
		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName" value="<%= community.getFirstName() %>">
		  </div>

		  <div>
		    <label for="lastName">Last Name :</label>
            <input type="text" name="lastName" value="<%= community.getLastName() %>">
          </div>

          <div>
             <label for="address">Address :</label>
 		     <input type="text" name="address" value="<%= community.getAddress() %>">
 		   </div>

 		   <div>
 		     <label for="gender"> Gender :</label>
 		     <input type="text" name="gender" value="<%= community.getGender() %>">
 		   </div>

 		   <div>
 		   <label for="contactNo">ContactNo :</label>
 		     <input type="text" name="contactNo" value="<%= community.getContactNo() %>">
 		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= community.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>