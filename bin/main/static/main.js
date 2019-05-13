$(document).ready(function() {
    $.ajax({
        url: "athletes"
    }).then(function(data) {
    	$.each(data, function(i, item) {
            var $tr = $('<tr>').append(
            	$('<td>').text(item.place),
                $('<td>').text(item.name+" "+item.surname),
                $('<td>').text(item.fencingWins),
                $('<td>').text(new Date(item.swimmingTime * 1000).toISOString().substr(14, 8)),
                $('<td>').text(item.ridingKnock),
                $('<td>').text(item.ridingRefusal),
                $('<td>').text(item.ridingDisobedience),
                $('<td>').text(item.shooting),
                $('<td>').text("-"+new Date(item.runTime * -1).toISOString().substr(14, 8)),
                $('<td>').text(item.totalScore)
            ).appendTo('#myTable');
        }); 
    });
});