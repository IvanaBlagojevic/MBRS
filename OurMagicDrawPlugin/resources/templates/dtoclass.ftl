package ${class.typePackage};

<#list imports as i>
import ${i};
</#list>

public class ${class.name}DTO {
<#list properties as property>
<#if property.upper == 1 >
	<#if property.persistentCharacteristics??>
			${property.visibility} ${property.type.name} ${property.name};
		<#else>
			${property.visibility} ${property.type.name}DTO ${property.name};
		</#if>   
	<#elseif property.upper == -1 > 
	${property.visibility} List<${property.type.name}> ${property.name} = new ArrayList<${property.type.name}>();
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
			this.${property.name} = ${class.name?uncap_first}.${property.name};
		<#else>
			this.${property.name} = new ${property.type.name}DTO(${class.name?uncap_first}.${property.name});
		</#if>
	</#if> 	
	</#list>
				
	}
	
<#list properties as property>
<#if property.upper == 1>
	public ${property.type.name} get${property.name?cap_first}(){
		return ${property.name};
	}
	
	public void set${property.name?cap_first}(${property.type.name} ${property.name}){
		this.${property.name} = ${property.name};
	}
<#elseif property.upper = -1>
	public Set<${property.type.name}> get${property.name?cap_first}(){
		return ${property.name};
	}
	
	public void set ${property.name?cap_first}(Set<${property.type.name}> ${property.name}){
		this.${property.name} = ${property.name};
	}
</#if>
	
	
</#list>
}