<html>

    <head>
        	<meta charset="ISO-8859-1">
        	<title>Teachers Details </title>
        <%@ page import= "org.first.model.Teachers" %>
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
             <form action="teachers-details" method="GET">
                <h1>Teachers Details </h1>
                    <%
                    Teachers teachers = (Teachers)request.getAttribute("teachersDetails");
                    %>
                     <div>
                        id : <%= teachers.getId() %>
                        FirstName : <%= teachers.getFirstName() %>
                        MiddleName : <%= teachers.getMiddleName() %>
                        SurName : <%= teachers.getSurName() %>
                        EmailId : <%= teachers.getEmailId() %>
                        Age : <%= teachers.getAge() %>
                        Gender : <%= teachers.getGender() %>
                        Specialisation : <%= teachers.getSpecialisation() %>
                        SchoolName : <%= teachers.getSchoolName() %>
                     </div>
                     <div>
                         <a href="/first-web-project/teachers-list" class=" List "> List </a>
                     </div>
                     <div>
                          <a href="/first-web-project/create-teachers" class=" Create "> Create </a>
                     </div>
            </body>
</html>