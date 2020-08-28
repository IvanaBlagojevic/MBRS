package ${class.typePackage};

<#-- IMPORTS -->
<#list imports as i>
	<#if !i?starts_with(class.typePackage)>
import ${i};
	</#if>
</#list>
import java.util.*;
import ${class.typePackage?keep_before_last(".")}.model.*;
import ${class.typePackage?keep_before_last(".")}.dto.*;

public class ${class.name}ImplDTO extends ${class.name}DTO {

}