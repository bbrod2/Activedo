<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activedo Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!----content below is a place holder until I get real name-->
    <meta name="description" content="Get Fit and Get Healthy">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/normalize.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/Queries.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap"
        rel="stylesheet">

</head>
<body>
  <nav>
        <div>
            <ul class="landing-nav">
                <li><a href="${pageContext.request.contextPath}/prescreen"> Pre-screen</a> </li>
                <li><a href="${pageContext.request.contextPath}/hhqForm">HHQ Form</a> </li>
                <li><a href="${pageContext.request.contextPath}/foodlog">Food-Log</a> </li>
                <li><a href="${pageContext.request.contextPath}/logout"> Log-Out</a> </li>
            </ul>
        </div>
    </nav>


    <section class="profile-section">
        <div>
            <h2>Profile:</h2>
            <p class="form-description" style="text-align: center;">Welcome to your profile! Track your progress and
                fitness goals here!</p>
        </div>
        <div class="outerprofile box shadow">
            <div>
                <h4 class="profile-title">Profile</h4>
                <p class="profile-description">Hello ${user.fullName}, you are looking fit!</p>
            </div>
            <div class="info-container box shadow">
                <div class="box info Q1">
                <p>${user.age}</p>
                    <p>Age</p>
                </div>
                <div class="box info Q2">
                <p>${user.getPrescreen().getRmr()}</p>
                    <p>RMR</p>
                </div>
                <div class="box info Q3">
                <p>${user.getPrescreen().getWeight()}</p>
                    <p>Weight</p>
                </div>
                <div class="box info Q4">
                <p>${user.getPrescreen().getBmi()}</p>
                    <p>BMI</p>
                </div>

            </div>
            <div class="box">
                <p class="steps-paragraph">Time To Goal Completion:</p>
                <div class="progress-wrap progress" data-progress-percent="25">
                    <div class="progress-bar progress"></div>
                </div>
            </div>
            <div class="box">
                <p>Calories:</p>
                <div class="progress-wrap progress">
                    <div class="progress-bar progress"></div>
                </div>
            </div>
        </div>

    </section>
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
            <div class=" col span span-1-of-2">
                <div>
                    <img src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_white.png" alt="Activedo-logo"
                        class="nav-logo">
                </div>
            </div>
        </div>
        <div class="row">
            <p>Copyright &copy; 2021 by Activedo. All rights reserved. </p>
        </div>
    </footer>

</body>
</html>