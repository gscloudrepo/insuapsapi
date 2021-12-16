package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Appointment;
import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import reactor.core.publisher.Flux;

public interface UploadPropRepo extends MongoRepository<UploadProposalFile, String> {

	
	void deleteByPropid(String id);
	List<UploadProposalFile> findByPropid(String id);
	void deleteByPropidAndFilenametype(String propid,String filenametype);
}
