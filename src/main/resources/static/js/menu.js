$(function() {
	$.get("/menu", function(data) {
		$("#menuHolder").html(data);
	});
});