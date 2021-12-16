package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
	
	String create(Employee userGroup);
    
    Mono<Employee> findById(String id);
 
    Flux<Employee> findByName(String name);
 
    Flux<Employee> findAll();
 
    Mono<Employee> update(Employee userGroup);
 
    Mono<Void> delete(String id);

}
