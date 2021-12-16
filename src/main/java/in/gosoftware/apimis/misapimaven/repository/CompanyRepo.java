package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Company;
import in.gosoftware.apimis.misapimaven.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyRepo extends ReactiveMongoRepository<Company, String> {
	@Query("{ 'name': ?0 }")
	Flux<Company> findByName(final String name);

	Mono<Company> findByEmail(String email);

	Mono<Boolean> existsByCid(String cmpid);
	Mono<Boolean> existsByEmail(String email);
	Mono<Company> findAllByCid(String cid);
	

}
