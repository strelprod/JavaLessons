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
            A <input type="number" name="A" value="0"/> 
            <select name="Operation">
                <option value="" selected>---</option>
                <option value="1">X + Y</option>
                <option value="2">X - Y</option>
                <option value="3">X * Y</option>
                <option value="4">X / Y</option>
                <option value="5">X ^ Y</option>
                <option value="6">bin</option>
                <option value="7">oct</option>
                <option value="8">hex</option>
            </select>
            <input type="number" name="B" value="0"/> B 
            <!-- Использовать класс Beans, A - ссылается на этот класс, класс доступен только н аэтой страницу -->
            <jsp:useBean id="calc" scope="request" class="Servlets.Calculator_3">
                <!-- используем A, которая ссылается на нужный класс 
                    указываем какие св-ва из класса используем - property
                    указываем, как определить свойства (что записать в него, вызвав Set) - param
                -->
                <jsp:setProperty name="calc" property="a" param="A" />
                <jsp:setProperty name="calc" property="b" param="B" />
                <jsp:setProperty name="calc" property="operation" param="Operation" />
            </jsp:useBean>
            <button name="button" value="Calculate">Calculate</button>
        </form>
        <b><jsp:getProperty name="calc" property="result"/></b>
    </body>
</html>