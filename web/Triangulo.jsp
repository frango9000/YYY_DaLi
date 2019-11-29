<%@ page import="lib.Geometry.SimplestTriangle" %>
Created by IntelliJ IDEA.
User: NarF
Date: 29/11/2019
Time: 7:13 p. m.
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Triangulo</title>
</head>
<body>

<% if ("GET".equals(request.getMethod())) { %>
<form action="Triangulo.jsp" method="post">
    Base <input type="text" name="base" value="0"/><br>
    Altura <input type="text" name="altura" value="0"/><br>
    <input type="submit"/>
</form>
<% } else if ("POST".equals(request.getMethod())) { %>
<% int base = Integer.parseInt(request.getParameter("base"));
    int altura = Integer.parseInt(request.getParameter("altura"));
    SimplestTriangle triangle = new SimplestTriangle();
    triangle.setBase(base);
    triangle.setAltura(altura);
    System.out.println(triangle.toString());%>
Altura:<%= triangle.getArea()%>
<%}%>

</body>
</html>