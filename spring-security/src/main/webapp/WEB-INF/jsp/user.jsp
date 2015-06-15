<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<! DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>SECURED page!</title>
</head>
<body>

    <h1>User UI</h1>
    
    <p>For all authenticated users...</p>
    
    <c:url value="/logout" var="logoutUrl" />
    <p><a href="${logoutUrl}">Sign out</a></p>

</body>
</html>
