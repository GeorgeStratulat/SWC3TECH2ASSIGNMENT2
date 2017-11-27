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
        <li class="list-group-item">
            <a href="/view/${list.id}">Take a look</a>
        </li>
        <li class="list-group-item">
            <a href="/delete/${list.id}">Delete</a>
        </li>
        <li class="list-group-item">
            <a href="/edit/${list.id}">Edit</a>
        </li>

    </ul>
</div>
</c:forEach>

<div class="container">
    <h2>Add class</h2>
    <form class="form-horizontal" method="post" action="/save">
        <input type="hidden" name="id" value="">
        <div class="form-group">
            <label class="control-label col-sm-2" >Name course DK:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="name_course_dk">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Name course EN:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="name_course_en">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Class code:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="class_code">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Study programme:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="study_programme">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Mandatory:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="mandatory">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Etcs:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="etcs">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Course language:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="course_language">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Minimum number of students:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="minimum_students">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Expected number of students:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="expected_students">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Maximum number of students:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="maximum_students">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Prerequisites:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="prerequisites">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Learning outcome:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="learning_outcome">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Content:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="content">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Learning activities:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="learning_activities">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Exam form:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="exam_form">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" >Teachers:</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="teachers">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Submit" ></input>
            </div>
        </div>
    </form>
</div>

</body>
</html>