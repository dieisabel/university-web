<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lab2 Tabulation</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <jsp:useBean id="data" type="com.lab2.dtos.TabulationData" scope="request" />
  <div class="form">
    <form method="post" action="/app/tabulate">
      <label for="startInput">Start: </label>
      <input type="text" id="startInput" name="start" />
      <label for="endInput">End: </label>
      <input type="text" id="endInput" name="end" />
      <label for="stepInput">Step: </label>
      <input type="text" id="stepInput" name="step" />
      <input type="submit" />
    </form>
  </div>
  <div class="data">
    <p>Start: ${data.start}</p>
    <p>End: ${data.end}</p>
    <p>Step: ${data.step}</p>
    <p>Amount of steps: ${data.steps}</p>
    <p>Index of a min element: ${data.minIndex}</p>
    <p>Value of a min element: 
      <fmt:formatNumber
        value="${data.minElement}"
        maxFractionDigits="3"
        minFractionDigits="3"/>
    </p>
    <p>Index of a max element: ${data.maxIndex}</p>
    <p>Value of a max element: 
      <fmt:formatNumber
        value="${data.maxElement}"
        maxFractionDigits="3"
        minFractionDigits="3"/>
    </p>
    <p>Sum: 
      <fmt:formatNumber
        value="${data.sum}"
        maxFractionDigits="3"
        minFractionDigits="3"/>
    </p>
    <p>Mean: 
      <fmt:formatNumber
        value="${data.mean}"
        maxFractionDigits="3"
        minFractionDigits="3"/>
    </p>
    <table>
      <thead>
        <tr>
          <th>X</th>
          <th>Y</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${data.pairs}" var="pair">
          <tr>
            <td>
              <fmt:formatNumber
                value="${pair.x}"
                maxFractionDigits="3"
                minFractionDigits="3"/>
            </td>
            <td>
              <fmt:formatNumber
                value="${pair.y}"
                maxFractionDigits="3"
                minFractionDigits="3"/>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
