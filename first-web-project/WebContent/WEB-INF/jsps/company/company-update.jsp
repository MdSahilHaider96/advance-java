<html>

    <%@ page import="org.first.model.Company" %>
 <body>
<h1> Company UPDATE  <h1>
<form action="companyUpdate" method="POST">
            <%
              Company company = (Company)request.getAttribute("company");
            %>
            <div>
            <input type="hidden" name="id" value="<%= company.getId() %>">
		    </div>
		  <div>
		    <label for="name">Name:</label>
		    <input type="text" name="name" value="<%= company.getName() %>">
		  </div>

		  <div>
		    <label for="location">Location :</label>
            <input type="text" name="location" value="<%= company.getLocation() %>">
          </div>

          <div>
             <label for="totalEmployees">TotalEmployees:</label>
 		     <input type="text" name="totalEmployees" value="<%= company.getTotalEmployees() %>">
 		   </div>

 		   <div>
 		     <label for="email">Email :</label>
 		     <input type="text" name="email" value="<%= company.getEmail() %>">
 		   </div>

 		   <div>
 		   <label for="contactNo">ContactNo :</label>
 		     <input type="text" name="contactNo" value="<%= company.getContactNo() %>">
 		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= company.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>