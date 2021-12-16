package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadClaimInfoFile;



public interface UploadClaimInfoFileRepo extends MongoRepository<UploadClaimInfoFile, String> {

	void deleteByClaiminfoid(String claiminfoid);

	List<UploadClaimInfoFile> findByClaiminfoid(String claiminfoid);
	List<UploadClaimInfoFile> findByClaiminfoidAndFilenametype(String claiminfoid,String filenametype );

	void deleteByClaiminfoidAndFilenametype(String claiminfoid, String filenametype);
	
}
