<!DOCTYPE html>
<html lang="en">
<title>${class.name}</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<script src="jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<!-- selection -->


<script type="text/javascript" src="js/${class.name}Form.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}

.modal {
  width: auto; 
  height: auto;
  min-width: 50vw;
 }
 
.modal-content {
  left: 0;
  top: 0;
  width: 100%;
  height: auto;
}

table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  
}

th, td {
  padding: 15px;
}

table tbody tr:hover {
    background-color: #dddddd;
    cursor: pointer;
}

#modal-table {
	width: auto; 
  	height: 100%;
	table-layout: fixed;
	word-wrap: break-word;
}

.highlight { background-color: grey; }


</style>
<body>

<!-- MODAL -->
<div id="ex1" class="modal">
	<div class="modal-content">
		<div id="modal-header" class="modal-header">
			<h4 id="modal-h4"></h4>
		</div>
	
		<div class="modal-body">
			<form id="modalForm">
				<div class="form-group">
					<table id="modal-table" class="table table-bordered">
	                    
	                    
					</table>
				</div>
				</br>
				<a  href="#" rel="modal:close" class="w3-button w3-red w3-margin-bottom close">Close</a>
				<a href="#" id="PositiveBtnId" rel="modal:close" class="w3-button w3-red w3-margin-bottom" style="float: right;">Choose</a>
			</form>
	                        
		</div>
	</div>
  
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-bar-block">
    <a href="./index.html"  onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <#list classes as cl>
	  <a href="./${cl.name?lower_case}.html" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">${cl.name}</a> 
 	</#list>
  </div>
</nav>

<!-- !PAGE CONTENT! -->
<div id = "page" class="w3-main" style="margin-left:340px;margin-right:40px">
  
  <!-- Form -->
  <div class="w3-container" id="services" style="margin-top:75px">
    <h1 class="w3-xxxlarge w3-text-red"><b>Add ${class.name}</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
    <form id="${class.name?lower_case}Form" action="./index.html">
    	<#list properties as p>
    		<#if p.component??>
		    	<#if p.component == 'TEXT_FIELD'>
		    	<label>${p.label}</label>
		    	<input class="w3-input w3-border" type="text" id="${p.name}Input" name="${p.name}" required>
		    	<#elseif p.component == 'NUMERIC_FIELD'>
		    	<label>${p.label}</label>
		    	<input class="w3-input w3-border" type="number" id="${p.name}Input" name="${p.name}" required>
		    	<#elseif p.component == 'PASSWORD_FIELD'>
		    	<label>${p.label}</label>
		    	<input class="w3-input w3-border" type="number" id="${p.name}Input" name="${p.name}" required>
		    	<#elseif p.component == 'DATE_FIELD'>
		    	<label>${p.label}</label>
		    	<input class="w3-input w3-border" type="date" id="${p.name}Input" name="${p.name}" required>
		    	<#elseif p.component == 'SELECT'>
		    	<label>${p.label}</label>
		    	<select class="w3-input w3-border" id="${p.name}Input" name="${p.name}">
		    	
		     	<#list enumerations as enum>
		    		<#if enum.name == p.type.name>
		    		<#list enum.values as val>
		    			<option value="${val}">${val}</option>
		    		</#list>
		    		</#if>
		    	</#list>
		
		    	</select>
		    	</#if>
		   </#if>
	    	<#if p.linkedCharacteristics??>
	    		<#if p.upper == 1 && p.linkedCharacteristics.oppositeUpper == -1>
	    			<!-- FORM FIELDS FOR LINKED PROPERTIES -->
	    			
			           	<label for="name">${p.name?cap_first} id:</label>
			           	<input class="w2-input" type="text" id="${p.name?lower_case}Input" readonly>
			           	<p><a href="#ex1" onclick="showModal(this)" class="w3-button w3-red w3-margin-bottom" rel="modal:open" id="${p.name?lower_case}">Choose ${p.name}</a></p>
			          
	    		</#if>
	    	</#if>
    	</#list>
    	
      <input type="submit" class="w3-button w3-block w3-padding-large w3-red w3-margin-bottom" id="Add" value="Add">
    </form>  
  </div>
  
  
 
<!-- End page content -->
</div>

<script>
$(document).ready(function(){
    $('table tbody tr').click(function(){
        alert($(this).text());
    });
});

// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>

</body>
</html>
