<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/normalize.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/grid.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pub/css/IMG/Queries.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link
			href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap"
			rel="stylesheet">
	<title>Activedo</title>
</head>
<body>
<nav>
	<div>
		<ul class="landing-nav">
			<li class="firstNav-link"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
			<li><a href="${pageContext.request.contextPath}/prescreen"> Pre-screen</a></li>
			<li><a href="${pageContext.request.contextPath}/foodlog">Food-Log</a></li>
			<li><a href="${pageContext.request.contextPath}/logout">Log-Out</a></li>
		</ul>
	</div>
</nav>
<section class="form-section">
	<div>
		<h2>Sign and Symptom Pre-Screen</h2>
		<p class="form-description" style="text-align: center;">Thank you
			for taking the time to fill out the health screen form</p>
	</div>
	<div class="form-box">
		<div>
			<h3 class="form-name">HHQ-Form</h3>
		</div>
		<div class="survey">
			<form method="post" action="${pageContext.request.contextPath}/hhqSubmit">
				<div class="row">
					<!--If any are marked then you should consult your physician before dieting or starting training, you may need a facility with a medically qualified staff, move to STOP page-->
					<div class="row">
						<div class="drop-down">
							<p class="form-paragraph">History</p>
						</div>
						<div class="response-checkbox">
							<label><input name="1"  type="checkbox"
										  class="input-checkbox" />Heart Attack
							</label>
							<label><input
									name="2"  type="checkbox"
									class="input-checkbox" />Heart Surgery
							</label>
							<label><input
									name="3"  type="checkbox" class="input-checkbox" />Cardiac
								Catherization
							</label>
							<label><input name="4"
										  type="checkbox" class="input-checkbox" />Cornary
								Angioplasty(PTCA)</label>
							<label><input name="5"
										  type="checkbox" class="input-checkbox" />Pacemaker/Implantable
								Cardiac Defibrillator/Rhythm Disturbance</label> <label><input
								name="6"  type="checkbox" class="input-checkbox" />Heart
							Valve Disease</label>
							<label><input name="7"
										  type="checkbox" class="input-checkbox" />Heart Failure</label> <label><input
								name="8"  type="checkbox" class="input-checkbox" />Heart
							Transplantation</label>
							<label><input name="9"
										  type="checkbox" class="input-checkbox" />Congenital Heart
								Disease</label>
						</div>
					</div>
					<!--If any are marked then you should consult your physician before dieting or starting training, move to STOP page, you may need a facility with a medically qualified staff-->
					<div class="row">
						<div class="drop-down">
							<p class="form-paragraph">Symptoms</p>
						</div>
						<div class="response-checkbox">
							<label><input name="10" type="checkbox"
										  class="input-checkbox" />You Experience Chest Discomfort With
								Exertion</label>
							<label><input name="11"
										  type="checkbox" class="input-checkbox" />You Experience
								Unreasonable Breathlesness</label>
							<label><input name="12"
										  type="checkbox" class="input-checkbox" />You
								Experience dizziness, Fainting, or Blackouts</label>
							<label><input
									name="13"  type="checkbox" class="input-checkbox" />You
								Experience Ankle Swelling</label>
							<label><input name="14"
										  type="checkbox" class="input-checkbox" />You
								Experience Unpleasant Awareness of a Forceful or Rapid Heart
								Rate</label>
							<label><input name="15"  type="checkbox"
										  class="input-checkbox" />You Take Heart Medications</label>
						</div>
					</div>
					<!--If any are marked then you should consult your physician before dieting or starting training, You may need a facility with a medically qualified staff, move to STOP page-->
					<div class="row">
						<div class="drop-down">
							<p class="form-paragraph">Other Health Issues</p>
						</div>
						<div class="response-checkbox">
							<label><input name="16"
										  type="checkbox" class="input-checkbox" />You Have Diabetes</label>
							<label><input
									name="17"  type="checkbox" class="input-checkbox" />You
								Have Asthma or Other Lung Disease</label>
							<label><input
									name="18"  type="checkbox" class="input-checkbox" />You
								Have Burning or Cramping Sensation In Your Lower Legs When
								Walking Short Distance
							</label>
							<label><input name="19"
										  type="checkbox"
										  class="input-checkbox" />You Have Musculoskeletal Problems
								That Limit Your Physical Activity</label>
							<label><input
									name="20"  type="checkbox"
									class="input-checkbox" />You Have Concerns About the Safety of
								Exercise</label>
							<label><input name="21"
										  type="checkbox"
										  class="input-checkbox" />You Take Prescription Medications</label>
							<label><input
									name="22" type="checkbox"
									class="input-checkbox" />You Are Pregnant</label>
						</div>
					</div>
					<!--If two or more are marked then you should consult your physician before dieting or starting training, You might benefit from using a facility with a professional exercise staff to guide your exercise program, move to STOP page, move to personal trainer page-->
					<div class="row">
						<div class="drop-down">
							<p class="form-paragraph">Cardiovascular Risk Factors</p>
						</div>
						<div class="response-checkbox">
							<label><input name="23"
										  type="checkbox" class="input-checkbox" />You Are a Man
								&GreaterEqual; 45 YR </label>
							<label><input name="24"
										  type="checkbox"
										  class="input-checkbox" />You Are a Woman &GreaterEqual; 55 YR</label>
							<label><input name="25"
										  type="checkbox" class="input-checkbox" />You Smoke or Quit
								Smoking Within The Previous 6 MO </label>
							<label><input
									name="26"  type="checkbox"
									class="input-checkbox" />Your Blood Pressure is &GreaterEqual;
								140/90 mm Hg</label>
							<label><input name="prefer"
										  type="checkbox"
										  class="input-checkbox" />You Do Not Know Your Blood Pressure</label>
							<label><input
									name="27"  type="checkbox"
									class="input-checkbox" />You Take Blood Pressure Medications</label>
							<label><input
									name="28"  type="checkbox"
									class="input-checkbox" />Your Blood Cholesterol Level is
								&GreaterEqual; 200 mg &#x2022; dL<sup>-1</sup> </label>
							<label><input
									name="29"  type="checkbox"
									class="input-checkbox" />You Do Not Know Your Cholseterol
								Level</label>
							<label><input name="30"
										  type="checkbox"
										  class="input-checkbox" />You Have A Close Blood Relative Who
								Had A Heart Attack or Heart Surgery Before<br> Age
								55(Father or Brother) or Age 65 (Mother or Sister)</label>
							<label><input
									name="31"  type="checkbox"
									class="input-checkbox" />You Are Physically Inactive (i.e.,
								You Get &lt; 30 Min Of Physical Activity on at Least 3 Days Per
								Week)</label>
							<label><input name="32"
										  type="checkbox"
										  class="input-checkbox" />You Have A Body Mass Index
								&GreaterEqual; 30 Kg &#x2022; m <sup> -2 </sup></label>
							<label><input
									name="33"  type="checkbox"
									class="input-checkbox" />You Have Prediabetes</label>
							<label><input
									name="34"  type="checkbox"
									class="input-checkbox" />You Do Not Know If You Have
								Prediabetes</label>
							<label><input name="35"
										  type="checkbox"
										  class="input-checkbox" />None of the Above </label>
						</div>
					</div>
					<!-- -If none of the above is checked proceed to next page you are able to exercise safely on your own
                    <div class="row">
                        <div class="drop-down">
                            <p class="form-paragraph">None</p>
                        </div>
                        <div class="response-checkbox">
                            <label><input name="36"
                                type="checkbox" class="input-checkbox" />None of the Above </label>
                        </div>
                    </div>
                </div> -->
					<div class="button">
						<button type="submit" id="submit" class="form-button">
							Submit</button>
					</div>
			</form>
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
				<img src="${pageContext.request.contextPath}pub/css/IMG/Activedo-logos/Activedo-logos_white.png"
					 alt="Activedo-logo" class="nav-logo">
			</div>
		</div>
	</div>
	<div class="row">
		<p>Copyright &copy; 2021 by Activedo. All rights reserved.</p>
	</div>
</footer>
</body>