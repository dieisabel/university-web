<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="plant" type="com.lab3.domain.models.Plant" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${plant.name}</title>
  <link rel="stylesheet" href="/app/css/styles.css"
</head>
<body>
  <div class="container">
    <h1 class="header">Information</h1>
    <div class="data">
      <p>Name: ${plant.name}</p>
      <p>Temperature: +-${plant.temperature}</p>
      <p>Light: ${plant.light}</p>
      <p>Size: +-${plant.size}</p>
      <p>Is poisonous: ${plant.isPoisonous}</p>
      <p>Family: ${plant.family.name}</p>
    </div>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>  
  </div>
</body>
</html>
