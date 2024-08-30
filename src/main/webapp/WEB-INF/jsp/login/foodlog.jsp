<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activedo</title>
<link rel="stylesheet" type="text/css" href="pub/css/IMG/normalize.css">
<link rel="stylesheet" type="text/css" href="pub/css/IMG/grid.css">
<link rel="stylesheet" type="text/css" href="pub/css/IMG/style.css">
<link rel="stylesheet" type="text/css" href="pub/css/IMG/Queries.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap"
	rel="stylesheet">
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<script type="text/javascript" src="pub/js/script.JS"></script>

</head>
<body>
	<nav>
		<div>
			<ul class="landing-nav">
				<li><a href="/hhqForm">Hhq Form</a></li>
				<li><a href="/prescreen">Pre-screen</a></li>
				<li><a href="/profile"> Profile</a></li>
				<li><a href="/logout"> Log-out</a></li>
			</ul>
		</div>
	</nav>

	<section class="food-log-section">
		<div>
			<h2>7-Day Food-Log:</h2>
			<p class="form-description" style="text-align: center;">Track
				Your Calorie In-take for 7-Days!</p>
		</div>
		<div class=food-background-container>
			<p></p>
		</div>

		<div class="row food-btn-container">


			<div class="col span-1-of-7 food-box shadow"
				onclick="displayDayOne()">
				<a class="food-btn" style= "text-decoration: none;" href="/foodlog?day=1">
					<p>Day 1</p>
				</a>
			</div>


			<div class="col span-1-of-7  food-box shadow"
				onclick="displayDayTwo()">
				<a class="food-btn" href="/foodlog?day=2">
					<p>Day 2</p>
				</a>
			</div>


			<div class="col span-1-of-7  food-box shadow">
				<a class="food-btn" href="/foodlog?day=3">
					<p>Day 3</p>
				</a>
			</div>


			<div class="col span-1-of-7  food-box shadow "
				onclick="displayDayFour()" >
				<a class="food-btn" href="/foodlog?day=4">
					<p>Day 4</p>
				</a>
			</div>


			<div class="col span-1-of-7 food-box shadow"
				onclick="displayDayFive()">
				<a class="food-btn" href="/foodlog?day=5">
					<p>Day 5</p>
				</a>
			</div>


			<div class="col span-1-of-7  food-box shadow"
				onclick="displayDaySix()">
				<a class="food-btn" href="/foodlog?day=6">
					<p>Day 6</p>
				</a>
			</div>


			<div class="col span-1-of-7 food-box shadow"
				onclick="displayDaySeven()">
				<a class="food-btn" href="/foodlog?day=7">
					<p>Day 7</p>
				</a>
			</div>

		</div>
		<div class=food-background-container2>
			<p></p>
		</div>
		
	</section>
	<!-- /*------------------------------------------------------*/
    /*--------------DayOne-----------------*/
    /*-----------------------------------------------------*/ -->

    <section class="table-section" id="dayOneInfo">
        <div>
            <h2>Day ${day}:</h2>
            <p class="form-description" style=" text-align: center;" id="sub-header">Track Your Calorie
                In-take for
                7-Days!</p>
        </div>
        <table class="button1-table">
            <tbody>
                <tr>
                    <td>
                        <h3>Input Food Item:</h3>
                    </td>
                    <td>
                        <ion-icon name="add-circle" class="add-circle" id="plusIcon" onclick="displayForm()"></ion-icon>
                        <ion-icon name="remove-circle" style="display: none;" class="add-circle" id="minusIcon"
                            onclick="displayForm()">
                    </td>
                    <td style="max-width: 300px; display: none;" id="breakFastForm">
                        <form method="post" action="/foodlog">
                            <input type="text" name="foodName" id="foodName" placeholder="Food Item"  required>
                            <input type="text" name="quantity" id="quantity" placeholder="Quantity"   required>
                            <input type="text" name="calories" id="calories" placeholder="Calories"  required>
                            <button type="submit" id="submit" class="form-button1">
                                Add
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
        <table class="button-table">
            <tbody>
                <tr>
                    <td>
                        <h3>Add Breakfast Item:</h3>
                    </td>
                    <td>
                        <ion-icon name="add-circle" class="add-circle" id="breakFastplusIcon"
                            onclick="displaySearchBar()">
                        </ion-icon>
                        <ion-icon name="remove-circle" style="display: none;" class="add-circle" id="breakFastminusIcon"
                            onclick="displaySearchBar()">
                        </ion-icon>
                    </td>
                    <td style="max-width: 300px; display: none;" id="breakFastSearchBar">
                        <form method="post" action="/breakFast">
                        <Input type = "hidden" name= "mealType" value ="breakfast">
                        <Input type = "hidden" name= "day" value ="${day}">
                        <input type="text" name="foodName" id="search" placeholder="Search" required>
                            <button type="submit" id="submit" class="form-button1">
                                Add
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="dummy-table row shadow" id="breakFastOneTable">
            <thead>
                <tr>
                    <th>Breakfast Item:</th>
                    <th>Quantity:</th>
                    <th>Calories:</th>
                    <th id="bRemoveItem" style="display: none;">Remove Item:</th>

                </tr>
            </thead>
            <tbody>
            <c:forEach items="${breakfastlog}" var="userfoodLog">
                <tr>          
                    <td>${userfoodLog.getFoodName()}</td>
                    <td>${userfoodLog.getQuantity()} </td>
                    <td>${userfoodLog.getCalories()}</td>
                    <td id="bRemoveItem1" style="display: none;"> <button type="submit" id="submit" class="form-button2"
                            style="max-width:150px;">
                            Remove
                        </button></td>
                </tr>
             </c:forEach>
            </tbody>
        </table>
        <table class="button-table">
            <tbody>
                <tr>
                    <td>
                        <h3>Add Lunch Item:</h3>
                    </td>
                    <td>
                        <ion-icon name="add-circle" class="add-circle" id="lunchplusIcon" onclick="displaySearchBar1()">
                        </ion-icon>
                        <ion-icon name="remove-circle" style="display: none;" class="add-circle" id="lunchminusIcon"
                            onclick="displaySearchBar1()">
                        </ion-icon>
                    </td>
                    <td id="lunchSearchBar" style="display: none;">
                       <form method="post" action="/lunch">
                        <Input type = "hidden" name= "mealType" value ="lunch">
                        <Input type = "hidden" name= "day" value ="${day}">
                         <input type="text" name="foodName" id="search" placeholder="Search" required>
                            <button type="submit" id="submit" class="form-button1">
                                Add
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
        <table class="dummy-table row shadow">
            <thead>
                <tr>
                    <th>Lunch Item:</th>
                    <th>Quantity:</th>
                    <th>Calories:</th>
                    <th id="lRemoveItem" style="display: none;">Remove Item:</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lunchlog}" var="userLunchLog">
                <tr>
                    <td>${userLunchLog.getFoodName()}</td>
                    <td>${userLunchLog.getQuantity()}</td> 
                    <td>${userLunchLog.getCalories()}</td>
                    <td id="lRemoveItem1" style="display: none;"> <button type="submit" id="submit" class="form-button2"
                            style="max-width:150px;">
                            Remove
                        </button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="button-table">
            <tbody>
                <tr>
                    <td>
                        <h3>Add Dinner Item:</h3>
                    </td>
                    <td>
                        <ion-icon name="add-circle" class="add-circle" id="dinnerplusIcon"
                            onclick="displaySearchBar2()"></ion-icon>
                        <ion-icon name="remove-circle" style="display: none;" class="add-circle" id="dinnerminusIcon"
                            onclick="displaySearchBar2()">
                        </ion-icon>
                    </td>
                    <td id="dinnerSearchBar" style="display: none;">
                        <form method="post" action="/dinner">
                        <Input type = "hidden" name= "mealType" value ="dinner">
                        <Input type = "hidden" name= "day" value ="${day}">
                        <input type="text" name="foodName" id="search" placeholder="Search" required>

                            <button type="submit" id="submit" class="form-button1">
                                Add
                            </button>
                        </form>
                    </td>
                </tr>

            </tbody>
        </table>
        <table class="dummy-table row shadow">
            <thead>
          
                <tr>
                    <th>Dinner Item:</th>
                    <th>Quantity:</th>
                    <th>Calories:</th>
                    <th id="dRemoveItem" style="display: none;">Remove Item:</th>
                </tr>
            </thead>
            <tbody>
             <c:forEach items="${dinnerlog}" var="userDinnerLog">
                <tr>
                    <td>${userDinnerLog.getFoodName()}</td>
                    <td>${userDinnerLog.getQuantity()} </td>
                    <td>${userDinnerLog.getCalories()}</td>
                    <td id="dRemoveItem1" style="display: none;"> <button type="submit" id="submit" class="form-button2"
                            style="max-width:150px;">
                            Remove
                        </button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <table class="button-table">
            <tbody>
                <tr>
                    <td>
                        <h3>Add Snack Item:</h3>
                    </td>
                    <td>
                        <ion-icon name="add-circle" class="add-circle" id="snackplusIcon" onclick="displaySearchBar3()">
                        </ion-icon>
                        <ion-icon name="remove-circle" style="display: none;" class="add-circle" id="snackminusIcon"
                            onclick="displaySearchBar3()">
                        </ion-icon>
                    </td>
                    <td id="snackSearchBar" style="display: none;">
                        <form method="post" action="/snack">
                        <Input type = "hidden" name= "mealType" value ="snack">
                         <Input type = "hidden" name= "day" value ="${day}">
                        <input type="text" name="foodName" id="search" placeholder="Search" required>

                            <button type="submit" id="submit" class="form-button1">
                                Add
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="dummy-table row shadow ">
            <thead>
                <tr>
                    <th>Snack Item:</th>
                    <th>Quantity:</th>
                    <th>Calories:</th>
                    <th id="sRemoveItem" style="display: none;">Remove Item:</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${snacklog}" var="userSnackLog">
                <tr>
                    <td>${userSnackLog.getFoodName()}</td>
                    <td>${userSnackLog.getQuantity()} </td>
                    <td>${userSnackLog.getCalories()}</td>
                    <td id="sRemoveItem1" style="display: none;"> <button type="submit" id="submit" class="form-button2"
                            style="max-width:150px;">
                            Remove
                        </button></td>
                </tr>
           </c:forEach>
            </tbody>
        </table>
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
					<img src="pub/css/IMG/Activedo-logos/Activedo-logos_white.png"
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