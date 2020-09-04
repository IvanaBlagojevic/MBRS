$(document).on('submit','#${class.name?lower_case}Form',function(e){
	var pom = {};
	<#list properties as prop>
		pom.${prop.name} = $('#${prop.name}').val();
	</#list>
	$(function () {
		var decide_url =$('#Add').val();
		if(decide_url == "Add"){
			$.ajax({
				type: 'POST',
				url: "http://localhost:${port}/${class.name?lower_case}/create",
				contentType : 'application/json',
				dataType : "json",
				data:formatJSON(),
				success:function(data){
					
					window.location.href="${class.name?uncap_first}.html";
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
					window.location.href="index.html";
				}
			});
		}else{
			$.ajax({
				type: 'PUT',
				url: "http://localhost:${port}/${class.name?lower_case}/update",
				contentType : 'application/json',
				dataType : "json",
				data:formatJSON(),
				success:function(data){
					
					window.location.href="${class.name?uncap_first}.html";
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
					window.location.href="index.html";
				}
			});
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
   		var where = "#" + type+'Input';
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


function formatJSON(){
	var decide_button =$('#Add').val();

	if(decide_button == "Add"){
		return JSON.stringify({
				<#list properties as prop>
				"${prop.name}":$('#${prop.name}Input').val(),
				</#list>
			});
	}else{
		params = getParams();
		return JSON.stringify({
			"id":params["id"],
			<#list properties as prop>
			"${prop.name}":$('#${prop.name}Input').val(),
			</#list>
		});
	}
	
}

function getParams(){
	   var idx = document.URL.indexOf('?'); 
	   var params = new Array();   
	   if (idx != -1 ) {
	        var pairs = document.URL.substring(idx+1, document.URL.length).split('&');
	        for (var i=0; i<pairs.length; i++){
	        	nameVal = pairs[i].split('=');
	            params[nameVal[0]] = nameVal[1];
	            $(function () {
	          	  $('#'+nameVal[0]).val(nameVal[1]);
	          	});
	        }
	        if (params["id"] != undefined ) {
		        $.ajax({
		            type: 'GET',
		            url: 'http://localhost:${port}/${class.name?lower_case}/' + params["id"],
		            contentType: 'application/json',
		            success: function (data)
		    		{
		            	
		            	for (const [key, value] of Object.entries(data)) {
		            		  
		            		  $(function () {
		                      	  $('#'+key+'Input').val(value);
		                      	});
		            		}
		    		}
		        });	
		        $(function () {
			    	$("#Add").prop('value', 'Update');
		        	});
		     } 
	   }
	    console.log(params["id"]);
	    
	    return params;
	}

params = getParams();
	
	
