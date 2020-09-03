function initializePage(){
	

	$.ajax({
			url: 'http://localhost:${port}/${class.name?lower_case}',
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				str ="";
				for (i in data) {
					console.log(i);
					str += '<tr>';
					<#list class.FMProperties as prop>
					<#if prop.upper == 1>
					str += '<td>' + data[i].${prop.name} + '</td>';
					</#if>
					</#list>
					<#list class.FMProperties as prop>
					<#if prop.upper == -1>
					str += '<td><a href="#"  id="${prop.name}Next" onclick="showModal(this)" name="controller=${prop.name},id=' + data[i].id + '">${prop.name}s</a></td>';
					</#if>
					</#list>
					str += '</tr>';
				}
				$("#${class.name?uncap_first}Table").append(str);

			},
			error: function (message) {
				console.log(message.responseText);
			}
		});
}

<#-- <#list class.FMProperties as prop>
<#if prop.upper == -1>
$(document).on('click','#${prop.name}Next',function(e){
	
	$('#${prop.name}ModalLabel').append(${prop.name});
	$.ajax({
			url: 'http://localhost:${port}/${prop.name}/${class.name?uncap_first}/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				str ="";
				headers = "";
				for (i in data) {
					console.log(i);
					str += '<tr>';
					header += '<th></th>';
					<#list class.FMProperties as prop>
					<#if prop.upper == 1>
					str += '<td>' + data[i].${prop.name} + '</td>';
					</#if>
					</#list>
					str += '</tr>';
				}
				
				$('#${prop.name}modalTable').append(str);

			},
			error: function (message) {
				console.log(message.responseText);
			}
		});
	
	
	var modal = document.getElementById("${prop.name}Modal");
	
	modal.style.display = "none";
});
</#if>
</#list> -->

function showModal(object){

	document.getElementById("modalLabel").innerHTML="";
	document.getElementById("modalTable").innerHTML="";
	var pom = object.name;
	var params = pom.split(',');
	var controllerParams = params[0].split('=');
	var idParams = params[1].split('=');
	
	var controller = controllerParams[1];
	var id = idParams[1];
	
	
	$('#modalLabel').append(capitalize(controller) + 's:');
	
	$.ajax({
			url: 'http://localhost:${port}/${class.name?lower_case}/' + controller + '/' + id,
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				str ="";
				headers = '<tr>';
				atributes = [];
				for(d in data[0])
				{
					if (Array.isArray(data[0][d]) == false){
						headers += '<th>' + d + '</th>';
						atributes.push(d);
					}
				}
				headers += '</tr>';
				$('#modalTable').append(headers);
				
				for (i in data) {
					
					str += '<tr>';
					for (a in atributes)
					{
						str += '<td>' + data[i][atributes[a]] + '</td>';
					}
					str += '</tr>';
				}
				
				$('#modalTable').append(str);

			},
			error: function (message) {
				console.log(message.responseText);
			}
		});
	
	
	var modal = document.getElementById("modalDiv");
	modal.style.display = "block";
}

$(document).on('click','#closeBtn',function(e){
	
	var modal = document.getElementById("modalDiv");
	modal.style.display = "none";
});

const capitalize = (s) => {
  if (typeof s !== 'string') return ''
  return s.charAt(0).toUpperCase() + s.slice(1)
}
