<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="families" type="java.util.List<com.lab3.domain.models.PlantFamily>" scope="request" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>All families</title>
  <link rel="stylesheet" href="/app/css/styles.css">
</head>
<body>
  <div class="container">
    <h1 class="header">All families</h1>
    <div class="table">
      <table>
        <thead>
          <tr>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${families}" var="family">
            <tr>
              <td>
                ${family.name}
              </td>
              <td>
                <a href="/app/families/edit?name=${family.name}">Edit</a>
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
