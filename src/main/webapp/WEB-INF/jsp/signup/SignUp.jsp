

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
<link
	href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap"
	rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}pub/js/script.JS"></script>
</head>
<body>
	<section class="login-section">
		<div class=" row shadow sign-up-con">
			<div class="col span-1-of-2 login-side s">
				<div class="survey">
					<form method="post" action="${pageContext.request.contextPath}/submitsignup" name="sign-up"
						  onsubmit="return validateGender() && validateUsername() && validateAge()">
				
						<div class="row">
							<div>
								<img
									src="${pageContext.request.contextPath}/pub/css/IMG/Activedo-logos/Activedo-logos_white.png"
									alt="Activedo-logo" class="login-logo">
							</div>
							<div>
								<label>
									<p class="sign-up-title">Sign-up-now</p>
								</label>
							</div>
							<div>
								<input type="text" name="email" id="Username"
									placeholder="Username" value="${form.email}" class= "username" required>
							</div>
							<c:forEach items="${errorFields}" var="errorField">
								<c:if test='${errorField.getField().equals("email") }'>
								
									<span style='color: white'>${errorField.defaultMessage}</span>
								</c:if>
							</c:forEach>
					
							<div class="row">
								<div>
									<input type="password" name="password" id="password"
										placeholder="&middot; &middot; &middot; &middot; &middot; &middot;"
										value="${form.password}" required>
									<c:forEach items="${errorFields}" var="errorField">
										<c:if test='${errorField.field == "password" }'>
										
											<span style='color: white'>${errorField.defaultMessage}</span>
										</c:if>
									</c:forEach>
								
								</div>
							</div>
							<div>
								<input type="text" name="full_name" id="FullName"
									placeholder="Full Name" value="${form.full_name}" required>
							</div>
							<div>
								<input type="text" name="gender" id="gender"
									placeholder="Gender" value="${form.gender}" required>
							</div>
							<div>
								<input type="number" name="age" id="age" placeholder="Age"
									value="${form.age}" required>
							</div>
							<div class="row">
								<div>
									<button type="submit" id="submit" class="login-button" value= "Redirect Page">
										Sign-up</button>
								</div>
							</div>
							<div class="row">
								<div>
									<a class="sign-up-link" href="/login">Already have an
										account? Login</a>
								</div>
							</div>
						</div>
						<div class="row">
							<div>
								<a class="sign-up-link1" href="/index">Home Page</a>
							</div>
						</div>
				</div>
				</form>
			</div>
			<div class="col span-1-of-2 login-pic">
				<p></p>
			</div>
		</div>
	</section>
</body>
</html>