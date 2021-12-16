package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.Company;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.repository.CompanyRepo;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService implements  ICompanyService {

	
	 @Autowired
	    CompanyRepo companyRepo;

		@Autowired
	    UserRepository userRepository;

	@Override
	public Mono<Company> findById(String id) {
		
		return companyRepo.findById(id);
	}

	@Override
	public Flux<Company> findByName(String name) {
		
		  return companyRepo.findByName(name);
	}

	@Override
	public Flux<Company> findAll() {

		return companyRepo.findAll();
	}

	@Override
	public Mono<Company> update(Company company) {
		
		 return companyRepo.save(company);
	}

	@Override
	public Mono<Void> delete(String id) {
		
		return companyRepo.deleteById(id);
	}

	@Override
	public Mono<Company> create(Company company) {
		
		return	companyRepo.save(company);
		
	}

	public User findByEmail(String emailid) {
		return userRepository.findByEmail(emailid);
	}

	 public Mono<Boolean> findUserBycmpid(String cmpid) {
	        return companyRepo.existsByCid(cmpid);
	    }
		public Mono<Boolean> findUserByemailid(String email) {
	        return companyRepo.existsByEmail(email);
	    }
	public Mono<Company> findByAllCid(String cid) {
		return companyRepo.findAllByCid(cid);
	}
	
//	@Override
//	public String create(Customer userGroup) {
//		
//		companyRepo.save(userGroup).subscribe();
//		
//		return "user created";
//	}
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
