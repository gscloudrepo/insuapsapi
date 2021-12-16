package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.ChannelPartner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChannelPartnerRepo extends ReactiveMongoRepository<ChannelPartner, String> {
	
	@Query("db.cp.find({\"name\": /?/})")
	    Flux<ChannelPartner> findByName(final String name);

	Mono<ChannelPartner> deleteByEmail(String email);

}
