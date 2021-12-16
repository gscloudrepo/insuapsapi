package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import in.gosoftware.apimis.misapimaven.model.UserGroup;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserGroupService {
	  	String create(UserGroup userGroup);
	     
	  	Optional<UserGroup> findById(String id);
	 
	    UserGroup findByName(String name);
	 
	    List<UserGroup> findAll();
	 
	    UserGroup update(UserGroup userGroup);
	 
	    Void delete(String id);
}
