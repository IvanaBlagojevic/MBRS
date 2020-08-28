package ${class.typePackage};
<#-- IMPORTS -->
<#list importedPackages as imports>
	<#if !imports?starts_with(class.typePackage)>
import ${imports};
	</#if>
</#list>
import ${class.typePackage?keep_before_last(".")}.model.*;
import javax.persistence.*;
import java.util.*;

${class.visibility} class ${class.name}Impl extends ${class.name} {  

}
