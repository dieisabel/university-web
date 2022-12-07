<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="families" type="java.util.List<com.lab3.domain.models.PlantFamily>" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Create new plant</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">Create new plant!</h1>
    <div class="form">
      <form method="post" action="/app/plants/create">
        <label for="plantName">Name: </label>
        <input type="text" id="plantName" name="name" />
        
        <label for="plantTemperature">Temperature: </label>
        <input type="number" id="plantTemperature" name="temperature" />
        
        <label for="plantLight">Light: </label>
        <input type="text" id="plantLight" name="light" />
        
        <label for="plantSize">Size: </label>
        <input type="number" id="plantSize" name="size" />

        <label for="plantIsPoisonous">Is poisonous: </label>
        <input type="checkbox" id="plantIsPoisonous" name="isPoisonous" />

        <label for="plantFamily">Family: </label>
        <input list="plantFamilies" type="text" id="plantFamily" name="familyName" />
        <datalist id="plantFamilies">
          <c:forEach items="${families}" var="family">
            <option value="${family.name}"></option>
          </c:forEach>
        </datalist>

        <input class= "submitButton" type="submit" />
      </form>
    </div>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>
  </div>
</body>
</html>
