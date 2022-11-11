<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="data" type="com.lab2.dtos.TabulationData" scope="request" />
    <form method="post" action="/app/tabulate">
        <label for="startInput">Start: </label>
        <input type="text" id="startInput" name="start" />
        <label for="endInput">End: </label>
        <input type="text" id="endInput" name="end" />
        <label for="stepInput">Step: </label>
        <input type="text" id="stepInput" name="step" />
        <input type="submit" />
    </form>
    <p>Start: ${data.start}</p>
    <p>End: ${data.end}</p>
    <p>Step: ${data.step}</p>
    <p>Amount of steps: ${data.steps}</p>
    <p>Index of a min element: ${data.minIndex}</p>
    <p>Value of a min element: ${data.minElement}</p>
    <p>Index of a max element: ${data.maxIndex}</p>
    <p>Value of a max element: ${data.maxElement}</p>
    <p>Sum: ${data.sum}</p>
    <p>Mean: ${data.mean}</p>
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
                    <td>${pair.x}</td>
                    <td>${pair.y}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
