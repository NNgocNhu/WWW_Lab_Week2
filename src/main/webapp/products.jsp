<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.services.ProductServices" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Product" %>
<%@ page import="java.util.List"%>
<%--

  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/09/2023
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Listing</title>
</head>
<body>
<%
    ProductServices productServices = new ProductServices();
    List<Product> lst = productServices.getActiveProducts();
%>
<table width="70%" align="center" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Util</th>
        <th>Manufacturer</th>
        <th>Status</th>
        <th colspan="2"><a href="./insertProducts.jsp">Insert</a></th>


    </tr>
    <%for (Product product: lst){%>
        <tr>
            <td><%=product.getProduct_id()%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getDescription()%></td>
            <td><%=product.getUnit()%></td>
            <td><%=product.getManufacturer()%></td>
            <td><%=product.getStatus()%></td>
            <td><a href="">Update</a></td>
            <td><a href="">Delete</a></td>


        </tr>
<%}%>
</table>
</body>
</html>
