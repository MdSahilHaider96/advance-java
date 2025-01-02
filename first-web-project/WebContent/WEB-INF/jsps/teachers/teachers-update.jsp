<html>

    <%@ page import="org.first.model.Teachers" %>
 <body>
<h1> TEACHERS UPDATE  <h1>
<form action="teachersUpdate" method="POST">
            <% Teachers teachers = (Teachers)request.getAttribute("teachers");
            %>
            <div>
            <input type="hidden" name="id" value="<%= teachers.getId() %>">
		    </div>
		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName" value="<%= teachers.getFirstName() %>">
		  </div>

		   <label for="middleName">Middle Name:</label>
          	<input type="text" name="middleName" value="<%= teachers.getMiddleName() %>">
           </div>

		  <div>
		    <label for="surName">Sur Name:</label>
            <input type="text" name="surName" value="<%= teachers.getSurName() %>">
          </div>

          <div>  <label for="emailId">EmailId:</label>
 		     <input type="text" name="emailId" value="<%= teachers.getEmailId() %>">
 		   </div>

 		   <div>  <label for="age">Age :</label>
 		     <input type="text" name="age" value="<%= teachers.getAge() %>">
 		   </div>

 		   <div>  <label for="gender">Gender :</label>
 		     <input type="text" name="gender" value="<%= teachers.getGender() %>">
 		   </div>

            <div>
                <label for="specialisation">Roll No :</label>
                <input type="text" name="specialisation" value="<%= teachers.getSpecialisation() %>">
              </div>

           <div>
    	     <label for="schoolName">School Name :</label>
		     <input type="text" name="schoolName" value="<%= teachers.getSchoolName() %>">
		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= teachers.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>