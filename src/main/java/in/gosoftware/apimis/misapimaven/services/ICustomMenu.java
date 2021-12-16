package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import in.gosoftware.apimis.misapimaven.model.CustomMenu;


public interface ICustomMenu {
	String create(CustomMenu customMenu);
    
  	Optional<CustomMenu> findById(String id);
 
  	CustomMenu findByName(String name);
 
    List<CustomMenu> findAll();
 
    CustomMenu update(CustomMenu customMenu);
 
    Void delete(String id);

}
