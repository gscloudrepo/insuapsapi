package in.gosoftware.apimis.misapimaven.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gosoftware.apimis.misapimaven.model.Role;



public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}