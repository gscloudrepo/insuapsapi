package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.repository.CustomerRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService implements ICustomerService {

	 @Autowired
	    CustomerRepo customerRepo;



	@Override
	public Mono<Customer> findById(String id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id);
	}
	@Override
	public Mono<Customer> findByCid(String cid) {
		// TODO Auto-generated method stub
		return customerRepo.findByCustid(cid);
	}
	@Override
	public Flux<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		  return customerRepo.findByName(name);
	}

	@Override
	public Flux<Customer> findAll() {

		return customerRepo.findAll();
	}

	@Override
	public Mono<Customer> update(Customer userGroup) {
		
		 return customerRepo.save(userGroup);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return customerRepo.deleteById(id);
	}

	
	@Override
	public String create(Customer userGroup) {
		
		customerRepo.save(userGroup).subscribe();
		
		return "user created";
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
