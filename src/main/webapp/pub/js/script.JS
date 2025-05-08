/**
 * 
 */
/*------------------------------------------------------*/
/*--------------sign-up-form---------------------------*/
/*-----------------------------------------------------*/

document.addEventListener("DOMContentLoaded", function() {
    // Sign-Up Form Validation

    const form = document.querySelector("form[name='sign-up']");
    const email = document.getElementById("Username");
    const password = document.getElementById("password");
    const gender = document.getElementById("gender");
    const age = document.getElementById("age");

    // Real-time validation
    email.addEventListener("input", () => validateEmail(email));
    password.addEventListener("input", () => validatePassword(password));
    gender.addEventListener("input", () => validateGender(gender));
    age.addEventListener("input", () => validateAge(age));

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent form submission

        let valid = validateEmail(email) & validatePassword(password) & validateGender(gender) & validateAge(age);

        if (valid) {
            form.submit();
        }
    });

    function validateEmail(element) {
        if (!element.value.includes("@")) {
            displayError(element, "Username must be a valid email");
            return false;
        } else {
            clearError(element);
            return true;
        }
    }

    function validatePassword(element) {
        const passwordRegex = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{5,25}$/;
        if (!passwordRegex.test(element.value)) {
            displayError(element, "Password must be 5-25 characters, include an uppercase letter, a number, and a special character.");
            return false;
        } else {
            clearError(element);
            return true;
        }
    }

    function validateGender(element) {
        if (element.value !== "Male" && element.value !== "Female") {
            displayError(element, "Input 'Male' or 'Female'.");
            return false;
        } else {
            clearError(element);
            return true;
        }
    }

    function validateAge(element) {
        if (parseInt(element.value) < 18) {
            displayError(element, "Age must be 18 or greater.");
            return false;
        } else {
            clearError(element);
            return true;
        }
    }

    function displayError(element, message) {
        clearError(element);
        const error = document.createElement("span");
        error.className = "error";
        error.textContent = message;
        element.insertAdjacentElement("afterend", error);
    }

    function clearError(element) {
        const error = element.nextElementSibling;
        if (error && error.classList.contains("error")) {
            error.remove();
        }
    }
});


/*------------------------------------------------------*/
/*--------------sign-up-form-end-----------------*/
/*-----------------------------------------------------*/

/*------------------------------------------------------*/
/*--------------FoodLog-Start-----------------*/
/*-----------------------------------------------------*/


function displayDayOne() {
   
    document.getElementById("dayOneInfo").style.display = "block";
   

}



/*-------------------------------DayOne-----------------------------------*/

function displayForm() {

    if (document.getElementById("breakFastForm").style.display == "none") {

        document.getElementById("breakFastForm").style.display = "block";
        document.getElementById("plusIcon").style.display = "none";
        document.getElementById("minusIcon").style.display = "block";
    } else {
        document.getElementById("breakFastForm").style.display = "none";
        document.getElementById("plusIcon").style.display = "block";
        document.getElementById("minusIcon").style.display = "none";

    }
}


function displaySearchBar() {
    if (document.getElementById("breakFastSearchBar").style.display == "none") {

        document.getElementById("breakFastSearchBar").style.display = "block";
        document.getElementById("breakFastplusIcon").style.display = "none";
        document.getElementById("breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("breakFastSearchBar").style.display = "none";
        document.getElementById("breakFastplusIcon").style.display = "block";
        document.getElementById("breakFastminusIcon").style.display = "none";

    }
}

function displaySearchBar1() {
    if (document.getElementById("lunchSearchBar").style.display == "none") {

        document.getElementById("lunchSearchBar").style.display = "block";
        document.getElementById("lunchplusIcon").style.display = "none";
        document.getElementById("lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("lunchSearchBar").style.display = "none";
        document.getElementById("lunchplusIcon").style.display = "block";
        document.getElementById("lunchminusIcon").style.display = "none";

    }
}

function displaySearchBar2() {
    if (document.getElementById("dinnerSearchBar").style.display == "none") {

        document.getElementById("dinnerSearchBar").style.display = "block";
        document.getElementById("dinnerplusIcon").style.display = "none";
        document.getElementById("dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("dinnerSearchBar").style.display = "none";
        document.getElementById("dinnerplusIcon").style.display = "block";
        document.getElementById("dinnerminusIcon").style.display = "none";

    }
}

function displaySearchBar3() {
    if (document.getElementById("snackSearchBar").style.display == "none") {

        document.getElementById("snackSearchBar").style.display = "block";
        document.getElementById("snackplusIcon").style.display = "none";
        document.getElementById("snackminusIcon").style.display = "block";
    } else {
        document.getElementById("snackSearchBar").style.display = "none";
        document.getElementById("snackplusIcon").style.display = "block";
        document.getElementById("snackminusIcon").style.display = "none";

    }
}
/*-------------------------------DayTwo-----------------------------------*/
function d2displayForm() {

    if (document.getElementById("d2breakFastForm").style.display == "none") {

        document.getElementById("d2breakFastForm").style.display = "block";
        document.getElementById("d2plusIcon").style.display = "none";
        document.getElementById("d2minusIcon").style.display = "block";
    } else {
        document.getElementById("d2breakFastForm").style.display = "none";
        document.getElementById("d2plusIcon").style.display = "block";
        document.getElementById("d2minusIcon").style.display = "none";

    }
}


function d2displaySearchBar() {
    if (document.getElementById("d2breakFastSearchBar").style.display == "none") {

        document.getElementById("d2breakFastSearchBar").style.display = "block";
        document.getElementById("d2breakFastplusIcon").style.display = "none";
        document.getElementById("d2breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d2breakFastSearchBar").style.display = "none";
        document.getElementById("d2breakFastplusIcon").style.display = "block";
        document.getElementById("d2breakFastminusIcon").style.display = "none";

    }
}

function d2displaySearchBar1() {
    if (document.getElementById("d2lunchSearchBar").style.display == "none") {

        document.getElementById("d2lunchSearchBar").style.display = "block";
        document.getElementById("d2lunchplusIcon").style.display = "none";
        document.getElementById("d2lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d2lunchSearchBar").style.display = "none";
        document.getElementById("d2lunchplusIcon").style.display = "block";
        document.getElementById("d2lunchminusIcon").style.display = "none";

    }
}

function d2displaySearchBar2() {
    if (document.getElementById("d2dinnerSearchBar").style.display == "none") {

        document.getElementById("d2dinnerSearchBar").style.display = "block";
        document.getElementById("d2dinnerplusIcon").style.display = "none";
        document.getElementById("d2dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d2dinnerSearchBar").style.display = "none";
        document.getElementById("d2dinnerplusIcon").style.display = "block";
        document.getElementById("d2dinnerminusIcon").style.display = "none";

    }
}

function d2displaySearchBar3() {
    if (document.getElementById("d2snackSearchBar").style.display == "none") {

        document.getElementById("d2snackSearchBar").style.display = "block";
        document.getElementById("d2snackplusIcon").style.display = "none";
        document.getElementById("d2snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d2snackSearchBar").style.display = "none";
        document.getElementById("d2snackplusIcon").style.display = "block";
        document.getElementById("d2snackminusIcon").style.display = "none";

    }
}

/*-------------------------------DayThree-----------------------------------*/

function d3displayForm() {

    if (document.getElementById("d3breakFastForm").style.display == "none") {

        document.getElementById("d3breakFastForm").style.display = "block";
        document.getElementById("d3plusIcon").style.display = "none";
        document.getElementById("d3minusIcon").style.display = "block";
    } else {
        document.getElementById("d3breakFastForm").style.display = "none";
        document.getElementById("d3plusIcon").style.display = "block";
        document.getElementById("d3minusIcon").style.display = "none";

    }
}


function d3displaySearchBar() {
    if (document.getElementById("d3breakFastSearchBar").style.display == "none") {

        document.getElementById("d3breakFastSearchBar").style.display = "block";
        document.getElementById("d3breakFastplusIcon").style.display = "none";
        document.getElementById("d3breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d3breakFastSearchBar").style.display = "none";
        document.getElementById("d3breakFastplusIcon").style.display = "block";
        document.getElementById("d3breakFastminusIcon").style.display = "none";

    }
}

function d3displaySearchBar1() {
    if (document.getElementById("d3lunchSearchBar").style.display == "none") {

        document.getElementById("d3lunchSearchBar").style.display = "block";
        document.getElementById("d3lunchplusIcon").style.display = "none";
        document.getElementById("d3lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d3lunchSearchBar").style.display = "none";
        document.getElementById("d3lunchplusIcon").style.display = "block";
        document.getElementById("d3lunchminusIcon").style.display = "none";

    }
}

function d3displaySearchBar2() {
    if (document.getElementById("d3dinnerSearchBar").style.display == "none") {

        document.getElementById("d3dinnerSearchBar").style.display = "block";
        document.getElementById("d3dinnerplusIcon").style.display = "none";
        document.getElementById("d3dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d3dinnerSearchBar").style.display = "none";
        document.getElementById("d3dinnerplusIcon").style.display = "block";
        document.getElementById("d3dinnerminusIcon").style.display = "none";

    }
}

function d3displaySearchBar3() {
    if (document.getElementById("d3snackSearchBar").style.display == "none") {

        document.getElementById("d3snackSearchBar").style.display = "block";
        document.getElementById("d3snackplusIcon").style.display = "none";
        document.getElementById("d3snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d3snackSearchBar").style.display = "none";
        document.getElementById("d3snackplusIcon").style.display = "block";
        document.getElementById("d3snackminusIcon").style.display = "none";

    }
}

/*-------------------------------DayFour-----------------------------------*/

function d4displayForm() {

    if (document.getElementById("d4breakFastForm").style.display == "none") {

        document.getElementById("d4breakFastForm").style.display = "block";
        document.getElementById("d4plusIcon").style.display = "none";
        document.getElementById("d4minusIcon").style.display = "block";
    } else {
        document.getElementById("d4breakFastForm").style.display = "none";
        document.getElementById("d4plusIcon").style.display = "block";
        document.getElementById("d4minusIcon").style.display = "none";

    }
}


function d4displaySearchBar() {
    if (document.getElementById("d4breakFastSearchBar").style.display == "none") {

        document.getElementById("d4breakFastSearchBar").style.display = "block";
        document.getElementById("d4breakFastplusIcon").style.display = "none";
        document.getElementById("d4breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d4breakFastSearchBar").style.display = "none";
        document.getElementById("d4breakFastplusIcon").style.display = "block";
        document.getElementById("d4breakFastminusIcon").style.display = "none";

    }
}

function d4displaySearchBar1() {
    if (document.getElementById("d4lunchSearchBar").style.display == "none") {

        document.getElementById("d4lunchSearchBar").style.display = "block";
        document.getElementById("d4lunchplusIcon").style.display = "none";
        document.getElementById("d4lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d4lunchSearchBar").style.display = "none";
        document.getElementById("d4lunchplusIcon").style.display = "block";
        document.getElementById("d4lunchminusIcon").style.display = "none";

    }
}

function d4displaySearchBar2() {
    if (document.getElementById("d4dinnerSearchBar").style.display == "none") {

        document.getElementById("d4dinnerSearchBar").style.display = "block";
        document.getElementById("d4dinnerplusIcon").style.display = "none";
        document.getElementById("d4dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d4dinnerSearchBar").style.display = "none";
        document.getElementById("d4dinnerplusIcon").style.display = "block";
        document.getElementById("d4dinnerminusIcon").style.display = "none";

    }
}

function d4displaySearchBar3() {
    if (document.getElementById("d4snackSearchBar").style.display == "none") {

        document.getElementById("d4snackSearchBar").style.display = "block";
        document.getElementById("d4snackplusIcon").style.display = "none";
        document.getElementById("d4snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d4snackSearchBar").style.display = "none";
        document.getElementById("d4snackplusIcon").style.display = "block";
        document.getElementById("d4snackminusIcon").style.display = "none";

    }
}


/*-------------------------------DayFive-----------------------------------*/

function d5displayForm() {

    if (document.getElementById("d5breakFastForm").style.display == "none") {

        document.getElementById("d5breakFastForm").style.display = "block";
        document.getElementById("d5plusIcon").style.display = "none";
        document.getElementById("d5minusIcon").style.display = "block";
    } else {
        document.getElementById("d5breakFastForm").style.display = "none";
        document.getElementById("d5plusIcon").style.display = "block";
        document.getElementById("d5minusIcon").style.display = "none";

    }
}


function d5displaySearchBar() {
    if (document.getElementById("d5breakFastSearchBar").style.display == "none") {

        document.getElementById("d5breakFastSearchBar").style.display = "block";
        document.getElementById("d5breakFastplusIcon").style.display = "none";
        document.getElementById("d5breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d5breakFastSearchBar").style.display = "none";
        document.getElementById("d5breakFastplusIcon").style.display = "block";
        document.getElementById("d5breakFastminusIcon").style.display = "none";

    }
}

function d5displaySearchBar1() {
    if (document.getElementById("d5lunchSearchBar").style.display == "none") {

        document.getElementById("d5lunchSearchBar").style.display = "block";
        document.getElementById("d5lunchplusIcon").style.display = "none";
        document.getElementById("d5lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d5lunchSearchBar").style.display = "none";
        document.getElementById("d5lunchplusIcon").style.display = "block";
        document.getElementById("d5lunchminusIcon").style.display = "none";

    }
}

function d5displaySearchBar2() {
    if (document.getElementById("d5dinnerSearchBar").style.display == "none") {

        document.getElementById("d5dinnerSearchBar").style.display = "block";
        document.getElementById("d5dinnerplusIcon").style.display = "none";
        document.getElementById("d5dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d5dinnerSearchBar").style.display = "none";
        document.getElementById("d5dinnerplusIcon").style.display = "block";
        document.getElementById("d5dinnerminusIcon").style.display = "none";

    }
}

function d5displaySearchBar3() {
    if (document.getElementById("d5snackSearchBar").style.display == "none") {

        document.getElementById("d5snackSearchBar").style.display = "block";
        document.getElementById("d5snackplusIcon").style.display = "none";
        document.getElementById("d5snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d5snackSearchBar").style.display = "none";
        document.getElementById("d5snackplusIcon").style.display = "block";
        document.getElementById("d5snackminusIcon").style.display = "none";

    }
}


/*-------------------------------DaySix-----------------------------------*/

function d6displayForm() {

    if (document.getElementById("d6breakFastForm").style.display == "none") {

        document.getElementById("d6breakFastForm").style.display = "block";
        document.getElementById("d6plusIcon").style.display = "none";
        document.getElementById("d6minusIcon").style.display = "block";
    } else {
        document.getElementById("d6breakFastForm").style.display = "none";
        document.getElementById("d6plusIcon").style.display = "block";
        document.getElementById("d6minusIcon").style.display = "none";

    }
}


function d6displaySearchBar() {
    if (document.getElementById("d6breakFastSearchBar").style.display == "none") {

        document.getElementById("d6breakFastSearchBar").style.display = "block";
        document.getElementById("d6breakFastplusIcon").style.display = "none";
        document.getElementById("d6breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d6breakFastSearchBar").style.display = "none";
        document.getElementById("d6breakFastplusIcon").style.display = "block";
        document.getElementById("d6breakFastminusIcon").style.display = "none";

    }
}

function d6displaySearchBar1() {
    if (document.getElementById("d6lunchSearchBar").style.display == "none") {

        document.getElementById("d6lunchSearchBar").style.display = "block";
        document.getElementById("d6lunchplusIcon").style.display = "none";
        document.getElementById("d6lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d6lunchSearchBar").style.display = "none";
        document.getElementById("d6lunchplusIcon").style.display = "block";
        document.getElementById("d6lunchminusIcon").style.display = "none";

    }
}

function d6displaySearchBar2() {
    if (document.getElementById("d6dinnerSearchBar").style.display == "none") {

        document.getElementById("d6dinnerSearchBar").style.display = "block";
        document.getElementById("d6dinnerplusIcon").style.display = "none";
        document.getElementById("d6dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d6dinnerSearchBar").style.display = "none";
        document.getElementById("d6dinnerplusIcon").style.display = "block";
        document.getElementById("d6dinnerminusIcon").style.display = "none";

    }
}

function d6displaySearchBar3() {
    if (document.getElementById("d6snackSearchBar").style.display == "none") {

        document.getElementById("d6snackSearchBar").style.display = "block";
        document.getElementById("d6snackplusIcon").style.display = "none";
        document.getElementById("d6snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d6snackSearchBar").style.display = "none";
        document.getElementById("d6snackplusIcon").style.display = "block";
        document.getElementById("d6snackminusIcon").style.display = "none";

    }
}


/*-------------------------------DaySeven-----------------------------------*/

function d7displayForm() {

    if (document.getElementById("d7breakFastForm").style.display == "none") {

        document.getElementById("d7breakFastForm").style.display = "block";
        document.getElementById("d7plusIcon").style.display = "none";
        document.getElementById("d7minusIcon").style.display = "block";
    } else {
        document.getElementById("d7breakFastForm").style.display = "none";
        document.getElementById("d7plusIcon").style.display = "block";
        document.getElementById("d7minusIcon").style.display = "none";

    }
}


function d7displaySearchBar() {
    if (document.getElementById("d7breakFastSearchBar").style.display == "none") {

        document.getElementById("d7breakFastSearchBar").style.display = "block";
        document.getElementById("d7breakFastplusIcon").style.display = "none";
        document.getElementById("d7breakFastminusIcon").style.display = "block";
    } else {
        document.getElementById("d7breakFastSearchBar").style.display = "none";
        document.getElementById("d7breakFastplusIcon").style.display = "block";
        document.getElementById("d7breakFastminusIcon").style.display = "none";

    }
}

function d7displaySearchBar1() {
    if (document.getElementById("d7lunchSearchBar").style.display == "none") {

        document.getElementById("d7lunchSearchBar").style.display = "block";
        document.getElementById("d7lunchplusIcon").style.display = "none";
        document.getElementById("d7lunchminusIcon").style.display = "block";
    } else {
        document.getElementById("d7lunchSearchBar").style.display = "none";
        document.getElementById("d7lunchplusIcon").style.display = "block";
        document.getElementById("d7lunchminusIcon").style.display = "none";

    }
}

function d7displaySearchBar2() {
    if (document.getElementById("d7dinnerSearchBar").style.display == "none") {

        document.getElementById("d7dinnerSearchBar").style.display = "block";
        document.getElementById("d7dinnerplusIcon").style.display = "none";
        document.getElementById("d7dinnerminusIcon").style.display = "block";
    } else {
        document.getElementById("d7dinnerSearchBar").style.display = "none";
        document.getElementById("d7dinnerplusIcon").style.display = "block";
        document.getElementById("d7dinnerminusIcon").style.display = "none";

    }
}

function d7displaySearchBar3() {
    if (document.getElementById("d7snackSearchBar").style.display == "none") {

        document.getElementById("d7snackSearchBar").style.display = "block";
        document.getElementById("d7snackplusIcon").style.display = "none";
        document.getElementById("d7snackminusIcon").style.display = "block";
    } else {
        document.getElementById("d7snackSearchBar").style.display = "none";
        document.getElementById("d7snackplusIcon").style.display = "block";
        document.getElementById("d7snackminusIcon").style.display = "none";

    }
}

/*-------------------------remove-item-----------------*/
function HideContent() {
    document.getElementById("rplusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('bRemoveItem','bRemoveItem1','lRemoveItem','lRemoveItem1','dRemoveItem','dRemoveItem1','sRemoveItem','sRemoveItem1', 'rminusIcon');
    } 


 function DisplayContent() {
    document.getElementById("rplusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('bRemoveItem','bRemoveItem1','lRemoveItem','lRemoveItem1','dRemoveItem','dRemoveItem1','sRemoveItem','sRemoveItem1', 'rminusIcon');
}

/*-------------------------day-two-----------------*/

function d2HideContent() {
    document.getElementById("r2plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d2bRemoveItem','d2bRemoveItem1','d2lRemoveItem','d2lRemoveItem1','d2dRemoveItem','d2dRemoveItem1','d2sRemoveItem','d2sRemoveItem1', 'r2minusIcon');
    } 


 function d2DisplayContent() {
    document.getElementById("r2plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d2bRemoveItem','d2bRemoveItem1','d2lRemoveItem','d2lRemoveItem1','d2dRemoveItem','d2dRemoveItem1','d2sRemoveItem','d2sRemoveItem1', 'r2minusIcon');
}

/*-------------------------day-three-----------------*/

function d3HideContent() {
    document.getElementById("r3plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d3bRemoveItem','d3bRemoveItem1','d3lRemoveItem','d3lRemoveItem1','d3dRemoveItem','d3dRemoveItem1','d3sRemoveItem','d3sRemoveItem1', 'r3minusIcon');
    } 


 function d3DisplayContent() {
    document.getElementById("r3plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d3bRemoveItem','d3bRemoveItem1','d3lRemoveItem','d3lRemoveItem1','d3dRemoveItem','d3dRemoveItem1','d3sRemoveItem','d3sRemoveItem1', 'r3minusIcon');
}

/*-------------------------day-four-----------------*/
function d4HideContent() {
    document.getElementById("r4plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d4bRemoveItem','d4bRemoveItem1','d4lRemoveItem','d4lRemoveItem1','d4dRemoveItem','d4dRemoveItem1','d4sRemoveItem','d4sRemoveItem1', 'r4minusIcon');
    } 


 function d4DisplayContent() {
    document.getElementById("r4plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d4bRemoveItem','d4bRemoveItem1','d4lRemoveItem','d4lRemoveItem1','d4dRemoveItem','d4dRemoveItem1','d4sRemoveItem','d4sRemoveItem1', 'r4minusIcon');

}

/*-------------------------day-five-----------------*/
function d5HideContent() {
    document.getElementById("r5plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d5bRemoveItem','d5bRemoveItem1','d5lRemoveItem','d5lRemoveItem1','d5dRemoveItem','d5dRemoveItem1','d5sRemoveItem','d5sRemoveItem1', 'r5minusIcon');
    } 


 function d5DisplayContent() {
    document.getElementById("r5plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d5bRemoveItem','d5bRemoveItem1','d5lRemoveItem','d5lRemoveItem1','d5dRemoveItem','d5dRemoveItem1','d5sRemoveItem','d5sRemoveItem1', 'r5minusIcon');

}

/*-------------------------day-six-----------------*/
function d6HideContent() {
    document.getElementById("r6plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d6bRemoveItem','d6bRemoveItem1','d6lRemoveItem','d6lRemoveItem1','d6dRemoveItem','d6dRemoveItem1','d6sRemoveItem','d6sRemoveItem1', 'r6minusIcon');
    } 


 function d6DisplayContent() {
    document.getElementById("r6plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d6bRemoveItem','d6bRemoveItem1','d6lRemoveItem','d6lRemoveItem1','d6dRemoveItem','d6dRemoveItem1','d6sRemoveItem','d6sRemoveItem1', 'r6minusIcon');

}


/*-------------------------day-seven-----------------*/

function d7HideContent() {
    document.getElementById("r7plusIcon").style.display = "block";
 
   
      for(let i=0; i < arguments.length; i++){
        document.getElementById(arguments[i]).style.display = "none";
      }
      HideContent('d7bRemoveItem','d7bRemoveItem1','d7lRemoveItem','d7lRemoveItem1','d7dRemoveItem','d7dRemoveItem1','d7sRemoveItem','d7sRemoveItem1', 'r7minusIcon');
    } 


 function d7DisplayContent() {
    document.getElementById("r7plusIcon").style.display = "none";
  
          for(let i=0; i < arguments.length; i++ ){
            document.getElementById(arguments[i]).style.display = "block";
       
    }
    DisplayContent('d7bRemoveItem','d7bRemoveItem1','d7lRemoveItem','d7lRemoveItem1','d7dRemoveItem','d7dRemoveItem1','d7sRemoveItem','d7sRemoveItem1', 'r7minusIcon');

}







/*------------------------------------------------------*/
/*--------------FoodLog-End-----------------*/
/*-----------------------------------------------------*/

/*------------------------------------------------------*/
/*--------------FoodLog-End-----------------*/
/*-----------------------------------------------------*/