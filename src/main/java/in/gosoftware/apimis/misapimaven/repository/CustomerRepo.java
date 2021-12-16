package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepo extends ReactiveMongoRepository<Customer, String>{
	
	 @Query("{ 'name': ?0 }")
	    Flux<Customer> findByName(final String name);

	 Mono<Customer> findByCustid(  String cid);

}
