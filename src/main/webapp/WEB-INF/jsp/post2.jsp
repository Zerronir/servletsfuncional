<%--
  Created by IntelliJ IDEA.
  User: Raul
  Date: 28/10/2020
  Time: 19:08
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

    <c:choose>

        <c:when test="${not empty nom}">
            <p>Hola, ${nom}</p>
        </c:when>

        <c:otherwise>
            <p>El dni ${dni} no es correcto</p>
        </c:otherwise>

    </c:choose>

</body>
</html>
