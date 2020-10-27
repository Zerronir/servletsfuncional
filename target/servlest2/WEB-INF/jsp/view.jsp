<%--
  Created by IntelliJ IDEA.
  User: raulmiralles
  Date: 27/10/2020
  Time: 19:28
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
    <h1>Modelo vista-controlador</h1>
    <p>Hola, ${nom}</p>

    <h2>Prova del tag if</h2>
    <!--  c: sirve para ejecutar tags  -->
    <c:if test="${temperature > 25}">
        <p>Fa calor</p>
    </c:if>

    <h2>Prova del tag Choose</h2>
    <c:choose>
        <c:when test="${money > 1000000}">
            <p>Ojalá</p>
        </c:when>

        <c:when test="${money > 100000}">
            <p>Ets ric</p>
        </c:when>

        <c:otherwise>
            <p>Eres del montón</p>
        </c:otherwise>

    </c:choose>

    <c:if test="${empty water}">
        <p>No hay agua</p>
    </c:if>

    <h2>Prova foreach</h2>
    <ul>
        <c:forEach var="p" items="${personas}">
            <li>${p.age} - ${p.name}</li>
        </c:forEach>
    </ul>

    <p>Mesas:</p>
    <ul>
        <c:forEach var="t" items="${personas}">

            <c:choose>
                <c:when test="${t == null}">
                    <li>Mesa vacía</li>
                </c:when>

                <c:when test="${fn:length(personas) <= 5}">
                    <li>${t.name}</li>
                </c:when>

                <c:otherwise>
                    <li>mesa llena</li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </ul>

</body>
</html>
