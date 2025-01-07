<html>

    <%@ page import="org.first.model.User2" %>
 <body>
<h1> USER UPDATE  <h1>
<form action="user2Update" method="POST">
            <% User2 user2 = (User2)request.getAttribute("user2");
            %>
            <div>
            <input type="hidden" name="id" value="<%= user2.getId() %>">
		    </div>

		  <div>
		    <label for="name">Name :</label>
		    <input type="text" name="name" value="<%= user2.getName() %>">
		  </div>

		  <div>
		    <label for="email">Email :</label>
            <input type="text" name="email" value="<%= user2.getEmail() %>">
          </div>

 		   <div>
             <label for="dob">DOB : </label>
             <input type="date" name="dob" value = "<%= user2.getDob() %>" >
           </div>

            <div>
                  <input type="hidden" name="id" value="<%= user2.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>