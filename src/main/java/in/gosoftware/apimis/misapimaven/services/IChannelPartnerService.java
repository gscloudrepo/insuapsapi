package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.ChannelPartner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IChannelPartnerService {
	
String create(ChannelPartner channelPartner);
    
    Mono<ChannelPartner> findById(String id);
 
    Flux<ChannelPartner> findByName(String name);
 
    Flux<ChannelPartner> findAll();
 
    Mono<ChannelPartner> update(ChannelPartner channelPartner);
 
    void delete(String id);

}
