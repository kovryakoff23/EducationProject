<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Регистрация</title>
</head>

<body>
<div>
  <form:form method="POST" modelAttribute="Form">
    <h2>Введите данные</h2>
     <div>
       <form:input type="hidden" path="userId" value="${Form.userId}"></form:input>
    </div>
    <div>
      <form:input type="text" path="name" placeholder="Name"></form:input>
    </div>
    <div>
       <form:input type="text" path="surname" placeholder="Surname"></form:input>
    </div>
    <div>
       <form:input type="text" path="phoneNumber" placeholder="PhoneNumber"></form:input>
    </div>
    <div>
       <form:input type="text" path="email" placeholder="Email"></form:input>
    </div>
    <div>
       <form:input type="text" path="birthdate" placeholder="Birthdate"></form:input>
    </div>
    <button type="submit">Сохранить</button>
  </form:form>
  <a href="/">Главная</a>
</div>
</body>
</html>