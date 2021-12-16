package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.SuperAdmin;
import reactor.core.publisher.Flux;

/**
 * @author Go-Software
 *
 */
public interface SuperAdminRepo extends ReactiveMongoRepository<SuperAdmin, String> {
	
	 @Query("{ 'name': ?0 }")
	    Flux<SuperAdmin> findByName(final String name);

}
