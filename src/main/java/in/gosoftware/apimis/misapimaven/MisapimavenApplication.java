package in.gosoftware.apimis.misapimaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


import in.gosoftware.apimis.misapimaven.services.MakeProposalService;
import in.gosoftware.apimis.misapimaven.services.UserGroupService;

@SpringBootApplication

public class MisapimavenApplication implements CommandLineRunner{

	@Autowired
	 UserGroupService userGroupService;
	@Autowired
	MakeProposalService makeProposalService;
	
	public static void main(String[] args) {

		SpringApplication.run(MisapimavenApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {


		
		
		

	}

}
