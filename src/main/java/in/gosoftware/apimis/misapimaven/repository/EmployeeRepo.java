package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Employee;
import reactor.core.publisher.Flux;

public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {

	 @Query("{ 'name': ?0 }")
	    Flux<Employee> findByName(final String name);
}
