$(document).on('submit','#${class.name?lower_case}Form',function(e){
<#-- DODATI VALIDNU PUTANJU ENDPOINT-A NA BACKENDU -->
	$.ajax({
			type: 'POST',
			url: "http://localhost:${port}/${class.name?lower_case}/add'",
			contentType : 'application/json',
			dataType : "json",
			data:formatJSON(),
			success:function(data){
				
				window.location.href="${class.name}.html";
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
				window.location.href="index.html";
			}
		});
});

$(document).on('click', 'table tbody tr', function(){
   	var id = $(this).attr('id');
   	var type = $(this).attr('name');

   	
   	var selected = $(this).hasClass("highlight");
   	console.log(selected);
    $("table tbody tr").removeClass("highlight");
    if(!selected)
            $(this).addClass("highlight");
            
    selected = $(this).hasClass("highlight");
    console.log(selected);
   	
   	$("#PositiveBtnId").click(function(){
   		var where = "#" + type + "Id";
   		console.log(where);
   		
   		$(document).ready(function(){
   			console.log(where);
   			console.log(id);
   			console.log(selected);
   			if (selected == true) 
   				$(where).val(id);
   		});
        
    });
   	
});

$(document).ready(function(){

	var properties = [];
	var r = $('a[href="#ex1"]').attr('id');
	console.log(r);
	
	var title = r.toLowerCase().replace(/\b[a-z]/g, function(letter) {
    	return letter.toUpperCase();
	});

	$('a[href="#ex1"]').click(function(){
		$(this).modal({
			fadeDuration: 1000,
			fadeDelay: 0.50
		});
		
		$("#modal-h4").text(title);
		
		$.ajax({
			type: 'GET',
			url: "http://localhost:${port}/" + r,
			contentType : 'application/json',
			dataType : "json",
			success:function(data){
				
				if (data != undefined || data != null) {
				
					var row = "";
					row += "<thead><tr>";
					properties = [];
					for(p in data[0]) { 
    					if (Array.isArray(data[0][p]) == false){
    						row += '<th>' + p + '</th>';
    						properties.push(p);
    					}
					}
					
					row += "</tr></thead><tbody>";
					for (i in data) {
						row += '<tr id="' + data[i].id + '" name="' + r + '">';
       		 			for (p in properties) {
       		 				
       		 				var value =  properties[p];
       		 				row += '<td>' + data[i][value] + '</td>';
       		 			}
        				row += '</tr>';
    				}
    				row += "</tbody>";
    				$('#modal-table').html(row);
    				
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
				window.location.href="index.html";
			}
		});
		
		
		return false;
	});
	
	
});

$(document).on('submit','#${class.name?lower_case}Form',function(e){
<#-- DODATI VALIDNU PUTANJU ENDPOINT-A NA BACKENDU -->

	$.ajax({
			type: 'POST',
			url: "http://localhost:${port}/${class.name?lower_case}/add'",
			contentType : 'application/json',
			dataType : "json",
			data:formatJSON(),
			success:function(data){
				
				window.location.href="${class.name}.html";
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
				window.location.href="index.html";
			}
		});
});

function formatJSON(){
	return JSON.stringify({
		<#list properties as prop>
		"${prop.name}":$('${prop.name}').val(),
		</#list>
});
	
	
}