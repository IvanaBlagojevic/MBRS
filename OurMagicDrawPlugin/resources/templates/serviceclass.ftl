package ${class.typePackage};

import java.util.List;
import java.util.Date;

${class.visibility} interface ${class.name}Service { 

	${class.name} findOne(Long id);
	
	List<${class.name}> findAll();

<#if methods?? >
<#assign x="false">
<#list methods as m>
<#if (m.name == 'create' && m.value == true && x == "false") || (m.name == 'update' && m.value == true && x == "false")>
	<#assign x="true">   
	${class.name} save${class.name}(${class.name} ${class.name?uncap_first});
</#if>

<#if m.name == 'delete' && m.value==true>   
	void remove${class.name}(Long id);
</#if>  
</#list>
</#if>

}