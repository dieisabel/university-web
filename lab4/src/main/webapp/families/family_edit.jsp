<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="family" type="com.lab3.domain.models.PlantFamily" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit ${family.name}</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">Edit ${family.name}</h1>
    <div class="form">
    <form method="post" action="/app/families/edit">
      <input type="hidden" name="oldName" value="${family.name}" readonly />
      <label for="plantFamilyName">Plant family name: </label>
      <input type="text" id="plantFamilyName" name="newName" value="${family.name}" />
      <input class="submitButton" type="submit" />
    </form>
    <form method="post" action="/app/families/delete">
      <input type="hidden" name="name" value="${family.name}" readonly />
      <input class="submitButton" type="submit" value="Delete" />
    </form>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>
  </div>
</body>
</html>
