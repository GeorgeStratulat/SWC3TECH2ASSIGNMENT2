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


<table class="table">
    <tbody>
    <tr>
        <td>ID</td>
        <td>${lists.id}</td>
    </tr>

    <tr>
        <td>Name of course DK</td>
        <td>${lists.name_course_dk}</td>
    </tr>

    <tr>
        <td>Name of course EN</td>
        <td>${lists.name_course_en}</td>
    </tr>

    <tr>
        <td>Class code</td>
        <td>${lists.class_code}</td>
    </tr>

    <tr>
        <td>Study programme</td>
        <td>${lists.study_programme}</td>
    </tr>

    <tr>
        <td>Mandatory</td>
        <td>${lists.mandatory}</td>
    </tr>

    <tr>
        <td>Etcs</td>
        <td>${lists.etcs}</td>
    </tr>

    <tr>
        <td>Course language</td>
        <td>${lists.course_language}</td>
    </tr>

    <tr>
        <td>Minimum students</td>
        <td>${lists.minimum_students}</td>
    </tr>

    <tr>
        <td>Expected students</td>
        <td>${lists.expected_students}</td>
    </tr>

    <tr>
        <td>Maximum students</td>
        <td>${lists.maximum_students}</td>
    </tr>

    <tr>
        <td>Prerequisites</td>
        <td>${lists.prerequisites}</td>
    </tr>

    <tr>
        <td>Learning outcome</td>
        <td>${lists.learning_outcome}</td>
    </tr>

    <tr>
        <td>Content</td>
        <td>${lists.content}</td>
    </tr>

    <tr>
        <td>Exam form</td>
        <td>${lists.exam_form}</td>
    </tr>

    <tr>
        <td>Teachers</td>
        <td>${lists.teachers}</td>
    </tr>

    </tbody>
</table>
<a href="/" class="btn btn-default" role="button">Back</a>
</body>
</html>