package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.repository.CrudRepository;

import in.gosoftware.apimis.misapimaven.model.ClaimInfo;


public interface ClaimReportRepo extends CrudRepository<ClaimInfo, String> {
	Iterable<ClaimInfo> findAllById(final String id);
}
