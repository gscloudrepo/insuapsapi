package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
	
	String create(Customer userGroup);
    
    Mono<Customer> findById(String id);
    Mono<Customer> findByCid(String id);
 
    Flux<Customer> findByName(String name);
 
    Flux<Customer> findAll();
 
    Mono<Customer> update(Customer userGroup);
 
    Mono<Void> delete(String id);

}
