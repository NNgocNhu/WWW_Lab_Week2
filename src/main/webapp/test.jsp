<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.repositories.EmployeeRepository" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.enums.EmployeeStatus" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.repositories.ProductRepository" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.enums.ProductStatus" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week2.backend.models.ProductImage" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%


    ProductRepository productRepository = new ProductRepository();
    Product product = new Product("Xe", "Oto", "chiec", "xeoto", ProductStatus.ACTIVE);

    ProductImage productImage = new ProductImage();
    productImage.setAlternative("xxx xxx");
    productImage.setProduct(product);

    product.getProductImageList().add(productImage);

    productRepository.insert(product);

    out.print("OK");
%>
</body>
</html>