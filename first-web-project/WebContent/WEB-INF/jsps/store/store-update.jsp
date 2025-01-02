<html>

    <%@ page import="org.first.model.Store" %>
 <body>
<h1> STORE UPDATE  <h1>
<form action="storeUpdate" method="POST">
            <% Store store = (Store)request.getAttribute("store");
            %>
            <div>
            <input type="hidden" name="id" value="<%= store.getId() %>">
		    </div>
		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName" value="<%= store.getFirstName() %>">
		  </div>

		  <div>
		    <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" value="<%= store.getLastName() %>">
          </div>

          <div>  <label for="email">Email:</label>
 		     <input type="text" name="email" value="<%= store.getEmail() %>">
 		   </div>

 		  <div>
 		    <label for="address">Address :</label>
            <input type="text" name="address" value="<%= store.getAddress() %>">
          </div>

           <div>
    	     <label for="phnNo">phn No:</label>
		     <input type="text" name="phnNo" value="<%= store.getPhnNo() %>">
		   </div>

           <div>
    	     <label for="totalBill">Total Bill :</label>
		     <input type="text" name="totalBill" value="<%= store.getTotalBill() %>">
		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= store.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>