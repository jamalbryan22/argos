package bryan.Argos.mongodb.repositories;

import bryan.Argos.user.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

  Optional<User> findByuserName(String username);

  Boolean existsByuserName(String username);

  Boolean existsByEmail(String email);
}