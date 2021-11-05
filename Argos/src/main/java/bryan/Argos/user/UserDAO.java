package bryan.Argos.user;

import bryan.Argos.mongodb.repositories.UserRepository;
import bryan.Argos.security.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

  @Autowired
  private final UserRepository userRepository;

 public UserDAO( UserRepository userRepository) {this.userRepository = userRepository;}

  public User createNewUser(User user) {
    return userRepository.save(new User(user.getUserID(), user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword()));
  }

  public User login(LoginCredentials loginCredentials) {
   return userRepository.findByEmail(loginCredentials.getEmail());
  }

  public User login(String userIDCookie) {
    return userRepository.findByUserID(userIDCookie);
  }

  public User getUser(String userID) {
    return userRepository.findByUserID(userID);
  }

  public User updateUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String userID) {
userRepository.deleteById(userID);
  }
}

