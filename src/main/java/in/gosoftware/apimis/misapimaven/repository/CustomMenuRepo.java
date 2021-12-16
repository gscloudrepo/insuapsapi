package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import in.gosoftware.apimis.misapimaven.model.CustomMenu;
public interface CustomMenuRepo extends MongoRepository<CustomMenu, String> {

}
