package bryan.Argos.mongodb.repositories;

import bryan.Argos.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

  User findByEmail(String email);

  User findByUserID(String userID);
}