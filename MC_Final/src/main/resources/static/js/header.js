
$(document).ready(function(){
	
let navToggle = document.querySelector(".nav__toggle");
let navWrapper = document.querySelector(".nav__wrapper");

 navToggle.addEventListener("click", function() {
	if (navWrapper.classList.contains("active")) {
		this.setAttribute("aria-expanded", "false");
		this.setAttribute("aria-label", "menu");
		navWrapper.classList.remove("active");
	} else {
		navWrapper.classList.add("active");
		this.setAttribute("aria-label", "close menu");
		this.setAttribute("aria-expanded", "true");
	}
});
<<<<<<< HEAD

<<<<<<< HEAD
=======
});
>>>>>>> a9494f34b61dedf2897ac581a86633d468291ad2
=======
>>>>>>> soohyun1
