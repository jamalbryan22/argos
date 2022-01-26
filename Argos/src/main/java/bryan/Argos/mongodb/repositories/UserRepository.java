package bryan.Argos.mongodb.repositories;

import bryan.Argos.user.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

  Boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);
}