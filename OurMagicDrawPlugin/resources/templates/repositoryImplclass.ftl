package ${class.typePackage};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ${class.typePackage?keep_before_last(".")}.model.*;
import ${class.typePackage?keep_before_last(".")}.repository.*;


@Repository
public interface ${class.name}ImplRepository extends ${class.name}Repository {

	
}
