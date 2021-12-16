package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.ChannelPartner;
import in.gosoftware.apimis.misapimaven.repository.ChannelPartnerRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChannelPartnetService implements IChannelPartnerService {

	 @Autowired
	    ChannelPartnerRepo channelPartnerRepo;


	@Override
	public Mono<ChannelPartner> findById(String id) {
		// TODO Auto-generated method stub
		return channelPartnerRepo.findById(id);
	}

	@Override
	public Flux<ChannelPartner> findByName(String name) {
		// TODO Auto-generated method stub
		  return channelPartnerRepo.findByName(name);
	}

	@Override
	public Flux<ChannelPartner> findAll() {

		return channelPartnerRepo.findAll();
	}

	@Override
	public Mono<ChannelPartner> update(ChannelPartner userGroup) {
		
		 return channelPartnerRepo.save(userGroup);
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		channelPartnerRepo.deleteByEmail(email).subscribe();
		
	}

	
	@Override
	public String create(ChannelPartner userGroup) {
		
		channelPartnerRepo.save(userGroup).subscribe();
		
		return "user created";
	}

}
