<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="data" type="com.lab2.dtos.TabulationData" scope="request" />
    <h1>${data.step}</h1>
</body>
</html>
