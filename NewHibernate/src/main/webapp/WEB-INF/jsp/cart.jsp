<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Корзина</title>
</head>
<body>
<table>
    <c:forEach items="${allBasketProduct}" var="basketProduct">
      <tr>
        <td>${basketProduct.product.article}</td>
        <td>${basketProduct.product.name}</td>
        <td>${basketProduct.product.description}</td>
        <td>${basketProduct.product.vendor}</td>
        <td>${basketProduct.product.discount}</td>
        <td>${basketProduct.product.avability}</td>
        <td>${basketProduct.quantity}</td>
      </tr>
    </c:forEach>
     </table>
<div>
    <h2>Корзина <br> Только для залогинившихся пользователей.</h2>
    <a href="/">Главная</a>
</div>
</body>
</html>