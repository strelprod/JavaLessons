<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            A <input type="text" name="a"><br>
            B <input type="text" name="b"><br>
            <select name="select">
                <option value="1">X + Y</option>
                <option value="2">X - Y</option>
                <option value="3">X * Y</option>
                <option value="4">X / Y</option>
                <option value="5">X ^ Y</option>
                <option value="6">bin</option>
                <option value="7">oct</option>
                <option value="8">hex</option>
              </select>
            <input type="submit" name="btn_submit"> 
        </form>
        <c:if test="${param.btn_submit != null}">
            <!-- Использовать класс Beans, A - ссылается на этот класс, класс доступен только н аэтой страницу -->
            <jsp:useBean id="A" class="Servlets.Calculator_3" scope="page">
                <!-- используем A, которая ссылается на нужный класс 
                    указываем какие св-ва из класса используем - property
                    указываем, как определить свойства (что записать в него, вызвав Set) - param
                <h2>Result: ${A.a / A.b}</h2>
                -->
                <jsp:setProperty name="A" 
                         property="a" 
                         param="a" /> 
                <jsp:setProperty name="A" 
                         property="b" 
                         param="b" />
            </jsp:useBean>
            <c:set var="selection" scope="page" value="${param.select}"/>
            <c:choose>
                <c:when test="${selection == 1}">
                   <c:out value="${A.a + A.b}" />
                </c:when>
                <c:when test="${selection == 2}">
                    <c:out value="${A.a - A.b}" />
                </c:when>
                <c:when test="${selection == 3}">
                    <c:out value="${A.a * A.b}" />
                </c:when>
                <c:when test="${selection == 4}">
                    <c:out value="${A.a / A.b}" />
                </c:when>
                <c:when test="${selection == 5}">
                    A^2: <c:out value="${A.a * A.a}" /><br>
                    B^2: <c:out value="${A.b * A.b}" />
                </c:when>
                <c:when test="${selection == 6}">
                    A^2: <c:out value="${Integer.toBinaryString(A.a)}" /><br>
                    B^2: <c:out value="${Integer.toBinaryString(A.b)}" />
                </c:when>
                <c:when test="${selection == 7}">
                    A^2: <c:out value="${Integer.toOctalString(A.a)}" /><br>
                    B^2: <c:out value="${Integer.toOctalString(A.b)}" />
                </c:when>
                <c:when test="${selection == 8}">
                    A^2: <c:out value="${Integer.toHexString(A.a)}" /><br>
                    B^2: <c:out value="${Integer.toHexString(A.b)}" />
                </c:when>
                <c:otherwise>
                    Не выбрано действие!
                </c:otherwise>
            </c:choose>
        </c:if>
    </body>
</html>
