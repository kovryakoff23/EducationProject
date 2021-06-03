<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Введите адрес</title>
</head>
<body>
<div>
  <form:form method="POST" modelAttribute="Form">
    <h2>Введите данные</h2>
    <div>
      <form:input type="hidden" path="addressId" value="${Form.addressId}"></form:input>
    </div>
    <div>
      <form:input type="text" path="country" placeholder="Country"></form:input>
    </div>
    <div>
       <form:input type="text" path="region" placeholder="Region"></form:input>
    </div>
    <div>
       <form:input type="text" path="city" placeholder="City"></form:input>
    </div>
    <div>
       <form:input type="text" path="street" placeholder="Street"></form:input>
    </div>
    <div>
       <form:input type="text" path="index" placeholder="Index"></form:input>
    </div>
    <div>
       <form:input type="text" path="building" placeholder="Building"></form:input>
    </div>
    <div>
       <form:input type="text" path="flat" placeholder="Flat"></form:input>
    </div>
    <button type="submit">Сохранить</button>
  </form:form>
  <a href="/">Главная</a>
</div>
</body>
</html>