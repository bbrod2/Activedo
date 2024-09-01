<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activedo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/normalize.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/Queries.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap"
        rel="stylesheet">
</head>
<body>
 <section class="login-section">
        <div class="row shadow login-con">
            <div class="col span-1-of-2 login-side h">
                <div class="survey">
                    <div>
                        <img src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_white.png" alt="Activedo-logo"
                            class="login-logo">
                    </div>
                    <form method="post" action="${pageContext.request.contextPath}/login">
                        <div class="row">
                            <div>
                                <label>
                                    <p class="login-title">Welcome</p>
                                </label>
                            </div>
                            <div>
                                <input type="text" name="username" id="Username" placeholder="Username" required>
                            </div>
                            <div class="row">
                                <div>
                                    <input type="password" name="password" id="name"
                                        placeholder="&middot; &middot; &middot; &middot; &middot; &middot; &middot; &middot; &middot;"
                                        required>
                                </div>
                            </div>
                            <div class="row">
                                <div>
                                    <button type="submit" id="submit" class="login-button">
                                        Login
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div>
                                    <a class="sign-up-link" href="${pageContext.request.contextPath}/signup">Don't have an account? Sign up</a>
                                </div>
                            </div>

                            <div class="row">
                                <div>
                                    <a class="sign-up-link1" href="${pageContext.request.contextPath}/index">Home Page</a>
                                </div>
                            </div>
                        </div>
                    </form>
            </div>
            </div>

            <div class="col span-1-of-2 login-pic">
                <p> </p>
            </div>

        </div>
    </section>

</body>
</html>