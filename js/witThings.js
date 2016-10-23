


/**$(document).ready(
	function(){
		if (window.location.href==="file:///C:/Users/Deniza/Codestuff/harvambe/index.html") {
		// Lets login to harvambe
		$("input[name='jid']").val("Harambe");
		$("input[name='password']").val("Harambe");
		$("input[value='Log In']").submit();
	}
}
);*/

/** =====================================================================================*/

var WANDA_TOKEN = "L2DXIUQS67QS47U4AL7WCJL4FJ3I7BE7";
var CURL = "https://api.motion.ai/getConversations?key=L2DXIUQS67QS47U4AL7WCJL4FJ3I7BE7&direction=in";

$(".message-input-wrap").onclick = function(CURL){

	var messages = null;
	$.ajax({
		type: "GET",
		dataType: "messageJSON",
		url: CURL,
		async: false,
		success: function(data){
			messages = data.messages;
		}
	});

for (var i=0;i<messages.length;i++){
	if (messages[i].result == "Great! Your location was just added to the trip!" || "I added that to your list")
{
	console.log(messages[i].result);
}}

var currentMessage = null;
currentMessage = (messages).getValues({text}); //"Great! Your location was just added to the trip!" || "I added that to your list"});
		if (currentMessage){
			console.log(currentMessage["result"]);
		}
		else{
				console.log("Error retrieving messages");
			};
		};
