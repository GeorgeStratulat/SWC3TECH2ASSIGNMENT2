<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:forEach var = "course"  items="${courses}" varStatus="status">
    <div class="container">


        <ul class="list-group">
            <li class="list-group-item">${course.id}</li>
            <li class="list-group-item">${course.name_course_dk}</li>
            <li class="list-group-item">${course.name_course_en}</li>
            <li class="list-group-item">${course.class_code}</li>
            <li class="list-group-item">${course.study_programme}</li>
            <li class="list-group-item">${course.mandatory}</li>
            <li class="list-group-item">${course.etcs}</li>
            <li class="list-group-item">${course.course_language}</li>
            <li class="list-group-item">${course.minimum_students}</li>
            <li class="list-group-item">${course.expected_students}</li>
            <li class="list-group-item">${course.maximum_students}</li>
            <li class="list-group-item">${course.prerequisites}</li>
            <li class="list-group-item">${course.learning_outcome}</li>
            <li class="list-group-item">${course.content}</li>
            <li class="list-group-item">${course.exam_form}</li>
            <li class="list-group-item">${course.teachers}</li>
        </ul>

        <ul class="list-group">
                <li class="list-group-item">${students[status.index]}</li>
        </ul>

    </div>


</c:forEach>
<br><a href="/logOut">Log Out</a>
</body>
</html>
