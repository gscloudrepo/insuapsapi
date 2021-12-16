package in.gosoftware.apimis.misapimaven.services;


import java.util.Date;

import in.gosoftware.apimis.misapimaven.model.Makeproposal;

import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMakeProposalService
{
	
	Mono<Makeproposal> create(Makeproposal makeProposal);
	
		void createprop(UploadProposalFile uploadProposalFile);
		
		UploadProposalFile updateprop(UploadProposalFile uploadProposalFile);
		Flux<Makeproposal> findByCreatedon(Date sdate,Date edate);
	 	Mono<Makeproposal> findById(String id);
	    Flux<Makeproposal> findAll();
	    Mono<Makeproposal> update(Makeproposal makeproposal);
	    Mono<Void> delete(String id);
	    void deleteFile(String id);
}
