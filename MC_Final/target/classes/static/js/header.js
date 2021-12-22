$(document).ready(function(){
	
	let navToggle = document.querySelector(".nav__toggle");
	let navWrapper = document.querySelector(".nav__wrapper");
	let navWrapper2 = document.querySelector(".nav__wrapper2");
	
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
	
	 navToggle.addEventListener("click", function() {
		if (navWrapper2.classList.contains("active")) {
			this.setAttribute("aria-expanded", "false");
			this.setAttribute("aria-label", "menu");
			navWrapper2.classList.remove("active");
		} else {
			navWrapper2.classList.add("active");
			this.setAttribute("aria-label", "close menu");
			this.setAttribute("aria-expanded", "true");
		}
	});

});

