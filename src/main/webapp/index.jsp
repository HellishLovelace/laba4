<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        /* Добавить стили для заголовков */

        h2 {
            font-size: 24px;
        }

        /* Добавить стили для формы */

        form {
            margin-bottom: 20px;
        }

        label {
            display: inline-block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 7px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Добавить стили для таблицы */

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th,
        td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Добавить стили для ссылок */

        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            color: #45a049;
        }

    </style>
</head>
<body>
<h2>Add Student</h2>
<form action="insert" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" required><br>
    <label for="group">Group:</label>
    <input type="text" id="group" name="group" required><br>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required><br>
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" required><br>
    <input type="submit" value="Add">
</form>
<h2>Student List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Group</th>
        <th>Age</th>
        <th>Subject</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.group}</td>
            <td>${student.age}</td>
            <td>${student.subject}</td>
            <td>
                <a href="edit?id=${student.id}">Edit</a> |
                <a href="delete?id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
