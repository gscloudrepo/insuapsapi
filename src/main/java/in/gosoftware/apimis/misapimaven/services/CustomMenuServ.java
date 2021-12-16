package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.gosoftware.apimis.misapimaven.model.CustomMenu;
import in.gosoftware.apimis.misapimaven.repository.CustomMenuRepo;

public class CustomMenuServ implements ICustomMenu {
	
	@Autowired
	CustomMenuRepo custommenurepo;

	@Override
	public String create(CustomMenu customMenu) {
		// TODO Auto-generated method stub
		custommenurepo.save(customMenu);
		return "created";
	}

	@Override
	public Optional<CustomMenu> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMenu findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomMenu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomMenu update(CustomMenu customMenu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
