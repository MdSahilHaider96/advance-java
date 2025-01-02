<html>

    <%@ page import="org.first.web.studentManagement.Model.Student" %>
 <body>
<h1> STUDENT UPDATE  <h1>
<form action="studentsUpdate" method="POST">
            <% Student student = (Student)request.getAttribute("student");
            %>

            <div>
            <input type="hidden" name="id" value="<%= student.getId() %>">
		    </div>
		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName" value="<%= student.getFirstName() %>">
		  </div>

		   <label for="middleName">Middle Name:</label>
          	<input type="text" name="middleName" value="<%= student.getMiddleName() %>">
           </div>

		  <div>
		    <label for="surName">Sur Name:</label>
            <input type="text" name="surName" value="<%= student.getSurName() %>">
          </div>

          <div>  <label for="email">Email:</label>
 		     <input type="text" name="email" value="<%= student.getEmail() %>">
 		   </div>

 		   <div>  <label for="age">Age :</label>
 		     <input type="text" name="age" value="<%= student.getAge() %>">
 		   </div>

 		   <div>  <label for="gender">Gender :</label>
 		     <input type="text" name="gender" value="<%= student.getGender() %>">
 		   </div>

            <div>
                <label for="rollNo">Roll No :</label>
                <input type="text" name="rollNo" value="<%= student.getRollNo() %>">
              </div>

              <div>
                <label for="standard">Standard :</label>
                <input type="text" name="standard" value="<%= student.getStandard() %>">
              </div>

              <div>
                <label for="fatherName">Father Name :</label>
                <input type="text" name="fatherName" value="<%= student.getFatherName() %>">
              </div>


           <div>
    	     <label for="schoolName">School Name :</label>
		     <input type="text" name="schoolName" value="<%= student.getSchoolName() %>">
		   </div>

            <div>
                  <input type="hidden" name="id" value="<%= student.getId() %>">
            </div>
		  <input type="submit" value="Submit">
</body>
</html>