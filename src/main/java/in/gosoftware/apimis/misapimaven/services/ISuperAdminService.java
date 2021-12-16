package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.SuperAdmin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ISuperAdminService {
	
	String create(SuperAdmin superAdmin);
    
    Mono<SuperAdmin> findById(String id);
 
    Flux<SuperAdmin> findByName(String name);
 
    Flux<SuperAdmin> findAll();
 
    Mono<SuperAdmin> update(SuperAdmin superAdmin);
 
    Mono<Void> delete(String id);
}
