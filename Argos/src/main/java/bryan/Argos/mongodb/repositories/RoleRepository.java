package bryan.Argos.mongodb.repositories;

import bryan.Argos.security.ERole;
import bryan.Argos.security.Role;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
  Optional<Role> findByName(ERole name);

}
