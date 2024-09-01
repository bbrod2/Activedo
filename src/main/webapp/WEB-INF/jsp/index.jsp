<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Get Fit and Get Healthy">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/normalize.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/Queries.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">
    <title>Activedo</title>
</head>

<body>
<nav>
    <div>
        <ul class="main-nav">
            <li><a href="${pageContext.request.contextPath}/signup">Get started</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        </ul>
    </div>
</nav>
<header>
    <div>
        <img src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_black.png" alt="Activedo-logo" class="main-logo">
    </div>
    <div class="hero-text-box">
        <h1>Be healthy<br> Be active</h1>
        <p class="main-paragraph"><strong>Achieve</strong> your fitness goals today through the aid of<br> the Activedo personal trainer virtual assistant.<br>
            With the best in the class diet and training advice<br> achieve <strong>the perfect body</strong> you have always dreamt of <strong>today!</strong>
        </p>
        <a class="btn btn-full" href="/signup">Get Started</a>
        <a class="btn btn-ghost" href="/login">Login</a>
    </div>
</header>
<footer>
    <div class="row">
        <div class="col span-1-of-2">
            <ul class="footer-nav">
                <li><a href="#">Facebook</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">Press</a></li>
                <li><a href="#">ios App</a></li>
                <li><a href="#">Android App</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </div>
        <div class="col span-1-of-2">
            <img src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_white.png" alt="Activedo-logo" class="nav-logo">
        </div>
    </div>
    <div class="row">
        <p>Copyright &copy; 2021 by Activedo. All rights reserved. </p>
    </div>
</footer>
</body>
</html>
