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
<h2>Courses which you signed up for</h2>
<c:forEach var = "course"  items="${courses}">
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


    </div>

</c:forEach>

<h2>All courses: </h2>
<c:forEach var = "list" items="${lists}">
    <div class="container">

        <h2>Course</h2>
        <ul class="list-group">
            <li class="list-group-item">${list.id}</li>
            <li class="list-group-item">${list.name_course_dk}</li>
            <li class="list-group-item">${list.name_course_en}</li>
            <li class="list-group-item">${list.class_code}</li>
            <li class="list-group-item">${list.study_programme}</li>
            <li class="list-group-item">${list.mandatory}</li>
            <li class="list-group-item">${list.etcs}</li>
            <li class="list-group-item">${list.course_language}</li>
            <li class="list-group-item">${list.minimum_students}</li>
            <li class="list-group-item">${list.expected_students}</li>
            <li class="list-group-item">${list.maximum_students}</li>
            <li class="list-group-item">${list.prerequisites}</li>
            <li class="list-group-item">${list.learning_outcome}</li>
            <li class="list-group-item">${list.content}</li>
            <li class="list-group-item">${list.exam_form}</li>
            <li class="list-group-item">${list.teachers}</li>
            <form method="post" action="/signup">
                <input type="hidden" name="course_id" value=${list.id}>
                <input type="submit" value="Sign up" ></input>
            </form>

        </ul>
        <div class="col-sm-offset-2 col-sm-10">

        </div>
    </div>
</c:forEach>
<br><a href="/logOut">Log Out</a>
</body>
</html>
