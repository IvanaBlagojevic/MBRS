package ${class.typePackage};

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
<#list importedPackages as imports>
	<#if !imports?starts_with(class.typePackage)>
import ${imports};
	</#if>
</#list>
import java.utils.*;
import ${class.typePackage?keep_before_last(".")}.model.*;

@RestController
@RequestMapping(${class.name?lower_case})
public class ${class.name}Controller {

<#-- Dodati sve ono za servise -->
}

