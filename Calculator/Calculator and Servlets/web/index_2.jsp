<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET"  action="calc_2">
            <input type="text" name="a"><br>
            <input type="text" name="b"><br>
            <input type="submit" name="btn_pls" value="x+y"> 
            <input type="submit" name="btn_mns" value="x-y"> 
            <input type="submit" name="btn_dvd" value="x/y"> 
            <input type="submit" name="btn_mlt" value="x*y"> 
            <input type="submit" name="btn_exp" value="x^y"> 
            <input type="submit" name="btn_bin" value="bin"> 
            <input type="submit" name="btn_oct" value="oct"> 
            <input type="submit" name="btn_hex" value="hex"> 
        </form>
        
        <b>Result: </b><br>
        <%
        if(request.getAttribute("calcResult") != null)
        out.println(request.getAttribute("calcResult"));
        %>
    </body>
</html>
