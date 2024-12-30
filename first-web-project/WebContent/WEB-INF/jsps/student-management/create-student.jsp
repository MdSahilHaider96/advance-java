<html>
    <head>
        <style>
            button {
                font: bold 11px Arial;
                text-decoration: none;
                background-color: #EEEEEE;
                color: #333333;
                padding: 2px 6px 2px 6px;
                border-top: 1px solid #CCCCCC;
                border-right: 1px solid #333333;
                border-bottom: 1px solid #333333;
                border-left: 1px solid #CCCCCC;
                   }
        </style>
    </head>
 <body>
<h1> STUDENT REGISTERATION <h1>
    <form action="create-student" method="POST">
		  <label for="firstName">First Name:</label><br>
		  <input type="text" name="firstName"><br>

		   <label for="middleName">Middle Name:</label><br>
           <input type="text" name="middleName"><br>

            <label for="surName">Sur Name:</label><br>
           	<input type="text" name="surName"><br>

    	  <label for="email">Email:</label><br>
		  <input type="text" name="email"><br>

		  <label for="age">Age:</label><br>
          <input type="text" name="age"><br>

          <label for="gender">Gender:</label><br>
          <input type="radio" name="gender" Value = "Male" /> Male <input type = "radio" name = "gender"  Value = "Female"/> Female  <br>

          <label for="roll">RollNo:</label><br>
          <input type="text" name="rollNo"><br>

          <label for="standard">Standard:</label><br>
          <input type="text" name="standard"><br>

          <label for="fatherName">Father Name:</label><br>
          <input type="text" name="fatherName"><br>

          <label for="schoolName">SchoolName:</label><br>
          <input type="text" name="schoolName"><br>

		  <input type="submit" value="Submit">
		  <div>
           <a href="/first-web-project/studentList" class="button">ListOfStudents</a>
           </div>
</body>
</html>