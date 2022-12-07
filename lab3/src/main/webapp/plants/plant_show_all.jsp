<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="plants" type="java.util.List<com.lab3.domain.models.Plant>" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>All plants</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">All plants</h1>
    <div class="table">
      <table style="width: 80%;">
        <thead>
          <tr>
            <th>Name</th>
            <th>Temperature</th>
            <th>Light</th>
            <th>Is poisonous</th>
            <th>Size</th>
            <th>Family</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${plants}" var="plant">
            <tr>
              <td>
                ${plant.name}
              </td>
              <td>
                ${plant.temperature}
              </td>
              <td>
                ${plant.light}
              </td>
              <td>
                ${plant.isPoisonous ? "Yes" : "No"}
              </td>
              <td>
                ${plant.size}
              </td>
              <td>
                ${plant.family.name}
              </td>
              <td>
                <a href="/app/plants/edit?name=${plant.name}">Edit</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="backlink">
	  <a href="/app/">Go back</a>
    </div>
  </div>
</body>
</html>
