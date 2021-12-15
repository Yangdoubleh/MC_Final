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


function insertChat(who, text){
    
    var control = "";;
    
    if (who == "me"){
        control = '<li style="width:100%">' +
                        '<div class="msj macro">' +
                            '<div class="text text-l">' +
                                '<p>'+ text +'</p>' +
                            '</div>' +
                        '</div>' +
                    '</li>';                    
    }else{
        control = '<li style="width:100%;">' +
                        '<div class="msj-rta macro">' +
                            '<div class="text text-r">' +
                                '<p>'+text+'</p>' +
                            '</div>' +
                         '</li>';
    }
    setTimeout(
        function(){                        
            $("ul").append(control).scrollTop($("ul").prop('scrollHeight'));
        }, time);
    
}

function resetChat(){
    $("ul").empty();
}

$(".mytext").on("keydown", function(e){
    if (e.which == 13){
        var text = $(this).val();
        if (text !== ""){
            insertChat("me", text);              
            $(this).val('');
        }
    }
});

$('send_Btn').click(function(){
    $(".mytext").trigger({type: 'keydown', which: 13, keyCode: 13});
})

//-- Clear Chat
resetChat();

//-- Print Messages
insertChat("me", "Hello Tom...");  
insertChat("you", "Hi, Pablo");
insertChat("me", "What would you like to talk about today?");
insertChat("you", "Tell me a joke");
insertChat("me", "Spaceman: Computer! Computer! Do we bring battery?!");
insertChat("you", "LOL");