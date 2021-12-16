package in.gosoftware.apimis.misapimaven.calc.repo;

import org.springframework.data.repository.CrudRepository;

import in.gosoftware.apimis.misapimaven.calc.model.Twowheelerpcv;




public interface TwoWheelerPcvRepo extends CrudRepository<Twowheelerpcv, String>{
	Iterable<Twowheelerpcv> findAllById(final String id);

}
