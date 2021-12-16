package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.repository.CrudRepository;

import in.gosoftware.apimis.misapimaven.model.VehicleInfo;

public interface VehicleBulkRepo extends CrudRepository<VehicleInfo,String> {
	

}
