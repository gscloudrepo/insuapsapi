package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICompanyService {

	Mono<Company> create(Company company);
    
    Mono<Company> findById(String id);
 
    Flux<Company> findByName(String name);
 
    Flux<Company> findAll();
 
    Mono<Company> update(Company company);
 
    Mono<Void> delete(String id);
    
	
}
