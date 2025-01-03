<html>
 <body>
<h1> EMPLOYEES REGISTERATION <h1>
<form action="employeesCreate" method="POST">

		  <div>
		    <label for="firstName">First Name:</label>
		    <input type="text" name="firstName">
		  </div>
		  <div>
		    <label for="lastName">Last Name:</label>
		    <input type="text" name="lastName">
		  </div>
            <div>
		    <label for="userName">User Name:</label>
		    <input type="text" name="userName">
		  </div>
    	  <label for="password">Password :</label>
		   <input type="text" name="password">
		   </div>

           <div>
    	     <label for="address">Address :</label>
		     <input type="text" name="address">
		   </div>
		   <div>
          	  <label for="contactNo">Contact No :</label>
              <input type="text" name="contactNo">
            </div>
		   <div>
               <a href="/first-web-project/employeesList" class=" List "> List </a>
           </div>

		  <input type="submit" value="Submit">
</body>
</html>