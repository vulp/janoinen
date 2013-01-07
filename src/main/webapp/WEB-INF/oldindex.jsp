<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>testi
<br />
<br />


<table class="table">
    <tbody>
    <tr><th>Nimi</th><th>%</th><th>€</th><th>Ratebeer / Olutopas</th></tr>
    <c:forEach items="${olvi}" var="bisse">
        <tr>
            <td><c:out value="${bisse.name}"/></td>
            <td><c:out value="${bisse.percent}"/></td>
            <td><c:out value="${bisse.price}"/></td>
            <td><a href="http://www.ratebeer.com/findbeer.asp?BeerName=karhu">Ratebeer</a></td>
        </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>