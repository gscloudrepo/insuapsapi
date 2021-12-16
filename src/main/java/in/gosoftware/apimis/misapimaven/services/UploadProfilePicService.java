package in.gosoftware.apimis.misapimaven.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.UploadProfilePic;
import in.gosoftware.apimis.misapimaven.repository.ProfilepicRepo;

@Service
public class UploadProfilePicService implements IUploadProfilePicService {

	@Autowired
	ProfilepicRepo profilepicrepo;
	
	@Override
	public String create(UploadProfilePic uploadProfilePic) {
		// TODO Auto-generated method stub
		 profilepicrepo.save(uploadProfilePic);
		return "Uploaded Successfully";
	}

	@Override
	public void delete(String id) {
		
		profilepicrepo.deleteById(id);
		
	}

	@Override
	public void deletebyemail(String email) {
		profilepicrepo.deleteByEmail(email);
	}

	@Override
	public UploadProfilePic findByEmail(String email) {
		// TODO Auto-generated method stub
		return profilepicrepo.findByEmail(email);
	}

//	public UploadProfilePic findByEmail(String emailid) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
