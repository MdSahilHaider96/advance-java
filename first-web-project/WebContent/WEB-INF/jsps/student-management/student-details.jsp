<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Student Details </title>
        <%@ page import = "org.first.web.studentManagement.Model.Student" %>
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
             border-left: 1px solid #CCCCCC;}
         </style>
        </head>
            <body>
             <form action="studentDetails" method="GET">
                <h1>Student Details </h1>
                    <%
                        Student student = (Student)request.getAttribute("studentDetails");
                    %>
                     <div>
                        Id : <%= student.getId() %>
                        FirstName : <%= student.getFirstName() %>
                        MiddleName : <%= student.getMiddleName() %>
                        SurName : <%= student.getSurName() %>
                        Email : <%= student.getEmail() %>
                        Age : <%= student.getAge() %>
                        Gender : <%= student.getGender() %>
                        RollNo : <%= student.getRollNo() %>
                        Standard : <%= student.getStandard() %>
                        FatherName : <%= student.getFatherName() %>
                        SchoolName : <%= student.getSchoolName() %>
                     </div>
                     <div>
                         <a href="/first-web-project/studentList" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/create-student" class=" Create "> Create </a>
                     </div>
            </body>
</html>