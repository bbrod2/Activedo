

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activedo - Sign Up</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/normalize.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/grid.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/Queries.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap">
<style>
  span.error { color: red; font-size: 0.9rem; display: block; }
</style>
</head>
<body>
<section class="login-section">
    <div class="row shadow sign-up-con">
        <div class="col span-1-of-2 login-side s">
            <div class="survey">
                <form method="post" action="${pageContext.request.contextPath}/submitsignup" name="sign-up">
                    <img src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_white.png" alt="Activedo-logo" class="login-logo">
                    <p class="sign-up-title">Sign Up Now</p>

                    <input type="text" name="email" placeholder="Email" value="${form.email}" required>
                    <c:forEach items="${errorFields}" var="errorField">
                        <c:if test='${errorField.field == "email" }'>
                            <span class="error">${errorField.defaultMessage}</span>
                        </c:if>
                    </c:forEach>

                    <input type="password" name="password" placeholder="Password" value="${form.password}" required>
                    <c:forEach items="${errorFields}" var="errorField">
                        <c:if test='${errorField.field == "password" }'>
                            <span class="error">${errorField.defaultMessage}</span>
                        </c:if>
                    </c:forEach>

                    <input type="text" name="full_name" placeholder="Full Name" value="${form.full_name}" required>
                    <c:forEach items="${errorFields}" var="errorField">
                        <c:if test='${errorField.field == "full_name" }'>
                            <span class="error">${errorField.defaultMessage}</span>
                        </c:if>
                    </c:forEach>

                    <input type="text" name="gender" placeholder="Gender" value="${form.gender}" required>
                    <c:forEach items="${errorFields}" var="errorField">
                        <c:if test='${errorField.field == "gender" }'>
                            <span class="error">${errorField.defaultMessage}</span>
                        </c:if>
                    </c:forEach>

                    <input type="number" name="age" placeholder="Age" value="${form.age}" required>
                    <c:forEach items="${errorFields}" var="errorField">
                        <c:if test='${errorField.field == "age" }'>
                            <span class="error">${errorField.defaultMessage}</span>
                        </c:if>
                    </c:forEach>

                    <button type="submit" class="login-button">Sign Up</button>

                    <div class="row">
                        <a class="sign-up-link" href="${pageContext.request.contextPath}/login">Already have an account? Login</a>
                    </div>
                    <div class="row">
                        <a class="sign-up-link1" href="${pageContext.request.contextPath}/index">Home Page</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>