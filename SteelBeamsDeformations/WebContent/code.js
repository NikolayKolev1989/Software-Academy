$(document).ready(
			function(){
		$("#submit").click(function(){
			var name = $("#name").val();
			var email = $("#email").val();
			$.ajax({
				type: "post",
				url: "Servlet2",
				data: {name:name, email:email},
				success: function(res){
//					$("#result").text(result);
					//alert("Success");
					$("#result").text("Server sent: " + res)	//server answer
				},
				error: function(ex){
					//alert("Error");
					$("#result").text(ex)	//server answer
				}
			});
		});
	});