
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
</head>
<body>
	<nav>
		<div>
			<ul class="landing-nav">
				<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
				<li><a href="${pageContext.request.contextPath}/hhqForm">HHQ Form</a></li>
				<li><a href="${pageContext.request.contextPath}/foodlog">Food-Log</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"> Log-Out</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<div>
			<h2>Fitness Pre-Screen:</h2>
			<p class="form-description" style="text-align: center;">Thank you
				for taking the time to fill out the fitness screen form</p>
		</div>
		<div class="form-box">
			<div>
				<h3 class="form-name">Health-Form</h3>
			</div>
			<div class="survey">
				<form method="post" action="${pageContext.request.contextPath}/prescreen">
					<div class="row">
						<div>
							<label>
								<p class="name-paragraph">RMR Calculator:</p>
							</label>
						</div>
						<div>
							<input type="text" name="gender" id="gender" placeholder="Gender" value ="${user.gender}"
								required > 
							<input type="text" name="age" id="age"
								placeholder="Age"  value = "${user.age}" required> 
							<input type="text"
								name="height" id="height" placeholder="Your Height in cm " value= "${form.height}" required>
							
							<input type="text" name="weight" id="weight"
								placeholder="Your Weight in kg" value = "${form.weight}"  required> 
													</div>
					</div>
					</div>
					<div class="row">
						<div>
							<label>
								<p class="name-paragraph">Goal Weight:</p>
							</label>
						</div>
						<div>
							<input type="text" name="goalWeight" id="goalWeight"
								placeholder="Your Goal Weight" value = "${form.goalWeight}"  required>
						</div>
					</div>
					<div class=button>
						<button type="submit" id="submit" class="form-button" value = "Redirect Page">
							Submit</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<footer>
		<div class="row">
			<div class="col span-1-of-2">
				<ul class="footer-nav">
					<li><a href="#">About Us</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Press</a></li>
					<li><a href="#">ios App</a></li>
					<li><a href="#">Android App</a></li>
					<li><a href="#">About Us</a></li>
				</ul>
			</div>
			<div class=" col span span-1-of-2">
				<div>
					<img
						src="${pageContext.request.contextPath}pub/css/IMG/Activedo-logos/Activedo-logos_white.png"
						alt="Activedo-logo" class="nav-logo">
				</div>
			</div>
		</div>
		<div class="row">
			<p>Copyright &copy; 2021 by Activedo. All rights reserved.</p>
		</div>
	</footer>

</body>
</html>