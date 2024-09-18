<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Result</title>
</head>
<body>
    <h2>Form Result</h2>
    <p>ID: <%= request.getParameter("id") %></p>
    <p>Name: <%= request.getParameter("name") %></p>
    <p>Age: <%= request.getParameter("age") %></p>
</body>
</html>
