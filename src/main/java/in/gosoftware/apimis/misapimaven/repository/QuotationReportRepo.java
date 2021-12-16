package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.repository.CrudRepository;

import in.gosoftware.apimis.misapimaven.model.Quotation;

public interface QuotationReportRepo extends CrudRepository<Quotation, String> {
	 Iterable<Quotation> findAllById(final String id);
}
