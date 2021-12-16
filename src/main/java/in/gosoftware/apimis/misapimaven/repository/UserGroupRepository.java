package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.UserGroup;
import reactor.core.publisher.Flux;

public interface UserGroupRepository extends MongoRepository<UserGroup, String>{
	
	 
		UserGroup findByNameAndCid(final String name, String cid);
		@Query("{ 'name': ?0 }")
	    UserGroup findByName(final String name);

		UserGroup findByCid(String ptype);

}
