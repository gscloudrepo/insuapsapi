package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadProfilePic;
import reactor.core.publisher.Mono;


public interface ProfilepicRepo extends MongoRepository<UploadProfilePic, String> {
	
	List<UploadProfilePic> findByUserid(String userid);
	
	void deleteByEmail(String email);
	Boolean existsByEmail(String email);
	UploadProfilePic findByEmail(String email);
}
