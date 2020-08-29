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