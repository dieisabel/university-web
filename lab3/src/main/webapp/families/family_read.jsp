<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="family" type="com.lab3.domain.models.PlantFamily" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>${family.name}</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">Information</h1>
    <div class="data">
      <p>Name: ${family.name}</p>
    </div>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>  
  </div>
</body>
</html>
