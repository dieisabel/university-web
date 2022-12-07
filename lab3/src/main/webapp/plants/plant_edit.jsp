<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="plant" type="com.lab3.domain.models.Plant" scope="request" />
<jsp:useBean id="families" type="java.util.List<com.lab3.domain.models.PlantFamily>" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit ${plant.name}</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">Edit ${plant.name}</h1>
    <div class="form">
    <form method="post" action="/app/plants/edit">
      <input type="hidden" name="oldName" value="${plant.name}" readonly />
      
      <label for="plantName">Name: </label>
      <input type="text" id="plantName" name="newName" value="${plant.name}" />
        
      <label for="plantTemperature">Temperature: </label>
      <input type="number" id="plantTemperature" name="temperature" value="${plant.temperature}" />
        
      <label for="plantLight">Light: </label>
      <input type="text" id="plantLight" name="light" value="${plant.light}" />
        
      <label for="plantSize">Size: </label>
      <input type="number" id="plantSize" name="size" value="${plant.size}" />

      <label for="plantIsPoisonous">Is poisonous: </label>
      <input type="checkbox" id="plantIsPoisonous" name="isPoisonous" 
		<c:if test="${plant.isPoisonous}">
		  checked
		</c:if>
      />

      <label for="plantFamily">Family: </label>
      <input list="plantFamilies" type="text" id="plantFamily" name="familyName" value="${plant.family.name}" />
      <datalist id="plantFamilies">
        <c:forEach items="${families}" var="family">
          <option value="${family.name}"></option>
        </c:forEach>
      </datalist>

      <input class="submitButton" type="submit" />
    </form>
    <form method="post" action="/app/plants/delete">
      <input type="hidden" name="name" value="${plant.name}" readonly />
      <input class="submitButton" type="submit" value="Delete" />
    </form>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>
  </div>
</body>
</html>
