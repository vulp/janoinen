<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach items="${olvi}" var="bisse">
        <tr>
            <td><c:out value="${bisse.name}"/></td>
            <td><c:out value="${bisse.percent}"/></td>
            <td><c:out value="${bisse.price}"/></td>
            <td><a href="http://www.ratebeer.com/findbeer.asp?BeerName=<c:out value="${bisse.name}"/>">Ratebeer</a> /
               / <a href="http://olutopas.info/namesearch.php?searchterm=<c:out value="${bisse.name}"/>">Olutopas</a>
            </td>
        </tr>
</c:forEach>

