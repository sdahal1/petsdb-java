<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
    <h1>Hello Spring Data I. Here are all the pets!</h1>

    <h3><c:out value='${ allPets }'/></h3>
    <c:forEach items='${ allPets }' var='pet'>
        <h3>${pet.name}</h3>
    </c:forEach>


    <table class="table">
        <thead>
          <tr>
          
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Description</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>

        <c:forEach items='${ allPets }' var='pet'>
          <tr>
            
            <td><a href="/pets/${pet.id}">${pet.name}</a></td>
            <td>${pet.age}</td>
            <td>${pet.description}</td>
            <td><a href="/">View Pet Details</a> | <a href="/pets/${pet.id}/edit">Edit</a> | <a href="/pets/${pet.id}/delete">Delete</a></td>
          </tr>
        </c:forEach>
          
        </tbody>
      </table>

</body>
</html>