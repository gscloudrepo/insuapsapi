package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.Employee;
import in.gosoftware.apimis.misapimaven.repository.EmployeeRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService{

	 @Autowired
	    EmployeeRepo employeeRepo;

	@Override
	public String create(Employee userGroup) {
		employeeRepo.save(userGroup).subscribe();
		
		return "user created";
	}

	@Override
	public Mono<Employee> findById(String id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}

	@Override
	public Flux<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		  return employeeRepo.findByName(name);
	}

	@Override
	public Flux<Employee> findAll() {

		return employeeRepo.findAll();
	}

	@Override
	public Mono<Employee> update(Employee userGroup) {
		
		 return employeeRepo.save(userGroup);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return employeeRepo.deleteById(id);
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
