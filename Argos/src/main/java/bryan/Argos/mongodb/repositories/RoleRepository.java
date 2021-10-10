package bryan.Argos.mongodb.repositories;

import bryan.Argos.security.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
//  Role findbByRole(String role);
}
