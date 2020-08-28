package ${class.typePackage};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${class.typePackage?keep_before_last(".")}.service.*;
import ${class.typePackage?keep_before_last(".")}.model.*;
import ${class.typePackage?keep_before_last(".")}.repository.*;




@Service
${class.visibility} class ${class.name}ServiceImpl implements ${class.name}Service{ 

	@Autowired
	protected ${class.name}Repository ${class.name?uncap_first}Repository;

	@Override
	${class.visibility} ${class.name} findOne(Long id){
		return ${class.name?uncap_first}Repository.findOneById(id);
	}
	
	@Override
	${class.visibility} List<${class.name}> findAll(){  
		return ${class.name?uncap_first}Repository.findAll();
	}

<#if methods?? >
<#assign x="false">
<#list methods as m>
<#if (m.name == 'create' && m.value == true && x == "false") || (m.name == 'update' && m.value == true && x == "false")>   
	<#assign x="true">
	@Override
	${class.visibility} ${class.name} save${class.name}(${class.name} ${class.name?uncap_first}){
		return ${class.name?uncap_first}Repository.save(${class.name?uncap_first});
	}
</#if>

<#if m.name == 'delete' && m.value==true>  
	@Override 
	public void remove${class.name}(Long id){
		${class.name?uncap_first}Repository.deleteById(id);  
	}
</#if>  
</#list>
</#if>


}