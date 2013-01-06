<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>testi
<br />
<br />


<c:forEach items="${olvi}" var="bisse">
<c:out value="${bisse.name}"/>
<br />
</c:forEach>
</body>
</html>