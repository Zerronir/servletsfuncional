<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 28/10/2020
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Adivina el numero</h1>

<c:choose>
    <c:when test="${not empty finish}">
        <p>Has ganado!!</p>
    </c:when>

    <c:otherwise>
        <form action="/guess3" method="post">
            Número: <input type="text" name="num"> <br>
            <button type="submit">Enviar</button>
        </form>
    </c:otherwise>
</c:choose>



<p>${msg}</p>

</body>
</html>
