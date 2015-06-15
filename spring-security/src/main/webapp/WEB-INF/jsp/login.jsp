<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SpringSecurity Test</title>
    </head>
    <body>

        <h2>Můj login formulář</h2>

        <c:if test="${param.error != null}">
            <div style="color: red; font-weight: bold;">Login se nezdařil!</div>
        </c:if>
        
        <c:if test="${param.logout != null}">
            <div style="color: blue; font-weight: bold;">Odhlášení proběhlo úspěšně.</div>
        </c:if>

        <c:url value="/login" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <div>
                <label for="username">Uživatelské jméno</label>
                <input id="username" name="username" type="text" />
            </div>
            <div>
                <label for="password">Heslo</label>
                <input id="password" name="password" type="password" />
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Přihlásit" />
        </form>

    </body>
</html>

