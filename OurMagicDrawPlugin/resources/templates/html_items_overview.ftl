<!DOCTYPE html>
<html lang="en">
<title>HomePage</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<script src="jquery.min.js"></script>
<script type="text/javascript" src="js/${cl.name?uncap_first}.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  padding-left: 200px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
/* Modal Content */

</style>
<body onload="initializePage()">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-bar-block">
    <a href="./index.html" id="homeHref"  onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <#list classes as cl>
	  <a href="./${cl.name}.html" id = "${cl.name?lower_case}Option"   class="w3-bar-item w3-button w3-hover-white">${cl.name}</a> 
 	</#list>
  </div>
</nav>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

<!-- Welcome content-->
	<div class="w3-container" style="margin-top:80px" id="showcase">
	    <h1 class="w3-xxxlarge w3-text-red"><b>${cl.name} items</b></h1>
	    <hr style="width:50px;border:5px solid red" class="w3-round">
	    <#if cl.uiAdd == true>
	    <a href="./${cl.name}Form.html" class="w3-button w3-red w3-margin-bottom">Add new ${cl.name}</a>
	    </#if>
	    <div class="table-wrapper">
			<table id="${cl.name?uncap_first}Table">
			  <tr id="tableHeaders">
				  <#list properties as prop>
				  <#if prop.upper == 1>
				  <#if prop.label??>
				  <th>${prop.label}</th>
				  <#else>
				  <th>${prop.name}</th>
				  </#if>
				  </#if>
				  </#list>
				  <#list properties as prop>
				  <#if prop.upper == -1>
				  <th>List of ${prop.name}s</th>
				  </#if>
				  </#list>
				  <th>Update</th>
				  <th>Delete</th>
			  </tr>
			  <tr id="tableRows">
			  </tr>
			  
			</table>
		</div>
	</div>
 
<!-- End page content -->
	<div id="modalDiv" class="modal">	
		<!-- Modal content -->
		<div class="modal-content">
		    <span class="close" id="closeBtn">&times;</span>
		    <h1 class="w3-xxxlarge w3-text-red" id="modalLabel"></h1>
			<table id="modalTable">
		</div>
	</div>
</div>

<script>
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