package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.VehicleInfo;
import reactor.core.publisher.Flux;

public interface VehicleInfoRepo extends ReactiveMongoRepository<VehicleInfo, String> {

	

	 @Query("{ 'name': ?0 }")
	    Flux<VehicleInfo> findByName(final String name);
	 
	 @Query("{ 'cid': ?0 }")
	 	Flux<VehicleInfo> findByCid(String cid);

	    Flux<VehicleInfo> findByNidBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNsdBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNpucdBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNttdBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findBySldedBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNfdBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNcidBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByTrexpdBetween(Date sdate, Date edate);
	    Flux<VehicleInfo> findByNpdBetween(Date sdate, Date edate);
}
