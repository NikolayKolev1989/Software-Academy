$(document).ready(
	function() {
		$("#profile").change(function() {
			$("#calculateButton").show();
			$(".selector").prop("disabled", false);
		});
	});