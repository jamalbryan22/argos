package bryan.Argos.user;

import bryan.Argos.mongodb.repositories.UserRepository;
import bryan.Argos.security.LoginCredentials;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

  @Autowired
  UserRepository userRepository;

  public User createNewUser(User user) {
    return userRepository.save(new User(user.getUserID(), user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()));
  }

  public User login(LoginCredentials loginCredentials) {
    User user = userRepository.findByEmail(loginCredentials.getEmail());
    return user;
  }

  public User login(String userIDCookie) {
    User user = userRepository.findByUserID(userIDCookie);
    return user;
  }

  public void deleteUser(String userID) {
userRepository.deleteById(userID);
  }

  public void updateUser(User user) {
    userRepository.save(user);
  }
}
