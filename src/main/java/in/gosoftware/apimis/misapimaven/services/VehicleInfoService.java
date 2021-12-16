package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.VehicleInfo;
import in.gosoftware.apimis.misapimaven.repository.VehicleBulkRepo;
import in.gosoftware.apimis.misapimaven.repository.VehicleInfoRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class VehicleInfoService implements IVehicleInfoService{

	
	 @Autowired
	    VehicleInfoRepo vehicleInfoRepo;
	 @Autowired
	 	VehicleBulkRepo vehicleBulkRepo;
	 public void save(List<VehicleInfo> vehicles) {
		 vehicleBulkRepo.saveAll(vehicles);
	    }
	@Override
	public Mono<VehicleInfo> findById(String id) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findById(id);
	}

	@Override
	public Flux<VehicleInfo> findByName(String name) {
		// TODO Auto-generated method stub
		  return vehicleInfoRepo.findByName(name);
	}

	@Override
	
	public Flux<VehicleInfo> findAll() {

		return vehicleInfoRepo.findAll().cache();
	}

	@Override
	public Mono<VehicleInfo> update(VehicleInfo vehicleInfo) {
		
		 return vehicleInfoRepo.save(vehicleInfo);
	}

	@Override
	
	public void delete(String id) {
		// TODO Auto-generated method stub
	 vehicleInfoRepo.deleteById(id);
	}

	
	@Override
	public String create(VehicleInfo vehicleInfo) {
		
		vehicleInfoRepo.save(vehicleInfo).subscribe();
		
		return "user created";
	}

	@Override
	public Flux<VehicleInfo> findByCid(String cid) {
		// TODO Auto-generated method stub
		 return vehicleInfoRepo.findByCid(cid);
	}

	@Override
	public Flux<VehicleInfo> findByNidon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNidBetween(sdate,edate);
	}

	@Override
	public Flux<VehicleInfo> findByNpdon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNpdBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByNsdon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNsdBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByNpucdon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNpucdBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findBySldedon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findBySldedBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByNfdon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNfdBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByNcidon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNcidBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByTruckexpon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByTrexpdBetween(sdate, edate);
	}

	@Override
	public Flux<VehicleInfo> findByNttdon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return vehicleInfoRepo.findByNttdBetween(sdate, edate);
	}
}
