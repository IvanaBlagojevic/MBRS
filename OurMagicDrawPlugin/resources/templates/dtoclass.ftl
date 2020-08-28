package ${class.typePackage};

<#-- IMPORTS -->
<#list imports as i>
	<#if !i?starts_with(class.typePackage)>
import ${i};
	</#if>
</#list>
import java.util.*;
import ${class.typePackage?keep_before_last(".")}.model.*;

public class ${class.name}DTO {
<#list properties as property>
<#if property.upper == 1 >
	<#if property.persistentCharacteristics?? >
		<#if property.linkedCharacteristics??>
		 	<#if property.linkedCharacteristics.oppositeUpper == -1>
	${property.visibility} ${property.type.name}DTO ${property.name};
			</#if>
		<#else>	 		
	${property.visibility} ${property.type.name} ${property.name};
		</#if>
	<#else>
	${property.visibility} ${property.type.name}DTO ${property.name};
	</#if>   
<#elseif property.upper == -1 > 
	${property.visibility} List<${property.type.name}DTO> ${property.name} = new ArrayList<${property.type.name}DTO>();
<#else>   
	<#list 1..property.upper as i>
		${property.visibility} ${property.type.name} ${property.name}${i};
	</#list>  
</#if>  
</#list>
	
	public ${class.name}DTO() {}

	public ${class.name}DTO(${class.name} ${class.name?uncap_first}){
	<#list properties as property>
	<#if property.upper == 1 >   
		<#if property.persistentCharacteristics??>
			this.${property.name} = ${class.name?uncap_first}.get${property.name?cap_first}();
		<#else>
			this.${property.name} = new ${property.type.name}DTO(${class.name?uncap_first}.get${property.name?cap_first}());
		</#if>
	</#if> 	
	</#list>
				
	}
	
<#list properties as property>
<#if property.upper == 1>
	<#if property.linkedCharacteristics??>
	 	<#if property.linkedCharacteristics.oppositeUpper == -1>
	public ${property.type.name}DTO get${property.name?cap_first}(){
		return ${property.name};
	}
	
	public void set${property.name?cap_first}(${property.type.name}DTO ${property.name}){
		this.${property.name} = ${property.name};
	}
		</#if>
	<#else>
	public ${property.type.name} get${property.name?cap_first}(){
		return ${property.name};
	}
	
	public void set${property.name?cap_first}(${property.type.name} ${property.name}){
		this.${property.name} = ${property.name};
	}
	</#if>		
<#elseif property.upper = -1>
	public List<${property.type.name}DTO> get${property.name?cap_first}(){
		return ${property.name};
	}
	
	public void set${property.name?cap_first}(List<${property.type.name}DTO> ${property.name}){
		this.${property.name} = ${property.name};
	}
</#if>
	
	
</#list>
	public ${class.name} convert(){
		${class.name} ${class.name?lower_case} = new ${class.name}();
		<#list properties as property>
			<#if property.upper == 1 >
				<#if property.persistentCharacteristics??>
		${class.name?lower_case}.set${property.name?cap_first}(this.${property.name});
				<#else>
		${class.name?lower_case}.set${property.name?cap_first}(this.${property.name}.convert());
				</#if>
			</#if> 	
		</#list>
		return ${class.name?lower_case};	
	}
}