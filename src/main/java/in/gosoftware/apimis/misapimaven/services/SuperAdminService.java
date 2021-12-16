package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.SuperAdmin;
import in.gosoftware.apimis.misapimaven.repository.SuperAdminRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuperAdminService implements ISuperAdminService {

	 @Autowired
	    SuperAdminRepo  superadminRepo;

	@Override
	public String create(SuperAdmin superadmin) {
		superadminRepo.save(superadmin).subscribe();
		
		return "user created";
	}

	@Override
	public Mono<SuperAdmin> findById(String id) {
		// TODO Auto-generated method stub
		return superadminRepo.findById(id);
	}

	@Override
	public Flux<SuperAdmin> findByName(String name) {
		// TODO Auto-generated method stub
		  return superadminRepo.findByName(name);
	}

	@Override
	public Flux<SuperAdmin> findAll() {

		return superadminRepo.findAll();
	}

	@Override
	public Mono<SuperAdmin> update(SuperAdmin superadmin) {
		
		 return superadminRepo.save(superadmin);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return superadminRepo.deleteById(id);
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
