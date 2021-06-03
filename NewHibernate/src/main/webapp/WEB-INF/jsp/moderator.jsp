<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Товары</title>
</head>
<body>
<div>
  <table>
    <thead>
    <th>article</th>
    <th>name</th>
    <th>description</th>
    <th>vendor</th>
    <th>avability</th>
    </thead>
    <c:forEach items="${allProduct}" var="product">
      <tr>
        <td>${product.article}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.vendor}</td>
        <td>${product.avability}</td>
        <td>
          <form action="${pageContext.request.contextPath}/moderator" method="post">
            <input type="hidden" name="productId" value="${product.article}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
     </table>
    <h2>Редактирование товаров
    <br> Только для модераторов.</h2>
    <a href="/">Главная</a>
</div>
</body>
</html>