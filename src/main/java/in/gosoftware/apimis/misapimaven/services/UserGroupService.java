package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.UserGroupRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserGroupService implements IUserGroupService {
	
	 @Autowired
	    UserGroupRepository userGroupRepository;

@Override
public String create(UserGroup userGroup) {
	// TODO Auto-generated method stub
	 userGroupRepository.save(userGroup);
	 return "user group created";
//	
//	return "user created";
}

@Override
public UserGroup findByName(String name) {
	// TODO Auto-generated method stub
	return userGroupRepository.findByName(name);
}

@Override
public List<UserGroup> findAll() {
	// TODO Auto-generated method stub
	return  userGroupRepository.findAll();
}

@Override
public UserGroup update(UserGroup userGroup) {
	// TODO Auto-generated method stub
	return userGroupRepository.save(userGroup);
}

@Override
public Void delete(String id) {
	// TODO Auto-generated method stub
userGroupRepository.deleteById(id);;
return null;
}

@Override
public Optional<UserGroup> findById(String id) {
	// TODO Auto-generated method stub
	return userGroupRepository.findById(id);
}
	 
//	    public void create(UserGroup userGroup) {
//	    	userGroupRepository.save(userGroup).subscribe();
//	    }
//	 
//	    public Mono<UserGroup> findById(String id) {
//	        return userGroupRepository.findById(id);
//	    }
//	 
//	    public Flux<UserGroup> findByName(String name) {
//	        return userGroupRepository.findByName(name);
//	    }
//	 
//	    public Flux<UserGroup> findAll() {
//	        return userGroupRepository.findAll();
//	    }
//	 
//	    public Mono<UserGroup> update(UserGroup e) {
//	        return userGroupRepository.save(e);
//	    }
//	 
//	    public Mono<Void> delete(String id) {
//	        return userGroupRepository.deleteById(id);
//	    }

		

}
