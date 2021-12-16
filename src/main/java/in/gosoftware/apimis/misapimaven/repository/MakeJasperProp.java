package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.repository.CrudRepository;

import in.gosoftware.apimis.misapimaven.model.Makeproposal;


public interface MakeJasperProp extends CrudRepository<Makeproposal, String> {

	Iterable<Makeproposal> findAllById(final String id);
}
