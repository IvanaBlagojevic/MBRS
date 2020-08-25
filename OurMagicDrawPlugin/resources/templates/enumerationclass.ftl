package ${enum.typePackage};

public enum ${enum.name?cap_first} {
<#list enum.values as value>
	${value}<#sep>,</#sep>
</#list>
}