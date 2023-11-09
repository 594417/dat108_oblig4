<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Deltagerliste</title>
</head>
<body>
<p>Innlogget som: ${deltager.mobil} / ${deltager.fornavn} ${deltager.etternavn}</p>
<h2>Deltagerliste</h2>
<table>
    <tr>
        <th>Kjønn</th>
        <th>Navn</th>
        <th>Mobil</th>
    </tr>
    <c:forEach items="${deltagere}" var="valgtDeltager">
        <tr <c:if test="${valgtDeltager.mobil == deltager.mobil}">style="background-color: green"</c:if>>
            <c:choose>
                <c:when test="${valgtDeltager.kjonn=='mann'}">
                    <td>&#9794;</td>
                </c:when>
                <c:otherwise>
                    <td>&#9792;</td>
                </c:otherwise>
            </c:choose>
            <td>${valgtDeltager.fornavn} ${valgtDeltager.etternavn}</td>
            <td>${valgtDeltager.mobil}</td>
        </tr>
    </c:forEach>

</table>
<br>
<form method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>