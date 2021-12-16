package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import in.gosoftware.apimis.misapimaven.model.User;



public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

	User findByCid(String cmpid);
	User findByPin(String pin);
	//User findAllByCid(String cmpid);

	boolean existsByPin(String pin);
	User findByCidAndPin(String cid,String pin);

	void deleteByCmpid(String cmpid);

	void deleteByEmail(String email);
}