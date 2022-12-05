<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Find plant family</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">Find plant family!</h1>
    <div class="form">
      <form method="post" action="/app/families/find">
        <label for="plantFamilyName">Plant family name: </label>
        <input type="text" id="plantFamilyName" name="name" />
        <input class="submitButton" type="submit" />
      </form>
    </div>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>
  </div>
</body>
</html>
