<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach items="${olvi}" var="bisse">
        <tr>
            <td><c:out value="${bisse.name}"/></td>
            <td>
                <c:choose>
                    <c:when test="${bisse.percent == -1}">
                        <c:out value="?"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${bisse.percent}"/>
                    </c:otherwise>
                </c:choose>

            </td>
            <td>
                <c:choose>
                    <c:when test="${bisse.price == -1}">
                        <c:out value="?"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${bisse.price}"/>
                    </c:otherwise>
                </c:choose>
            </td>
            <td><c:out value="${bisse.description}"/></td>
            <td><a href="http://www.ratebeer.com/findbeer.asp?BeerName=<c:out value="${bisse.name}"/>" target="_blank">Ratebeer</a> /
                <a href="http://olutopas.info/namesearch.php?searchterm=<c:out value="${bisse.name}"/>" target="_blank">Olutopas</a>
            </td>
        </tr>
</c:forEach>

