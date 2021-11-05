package bryan.Argos.user;

import bryan.Argos.security.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserDAO userDAO;

  @Autowired
  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public User createNewUser(User user) {
    return userDAO.createNewUser(user);
  }

  public User login(LoginCredentials loginCredentials){
   User user = userDAO.login(loginCredentials);
    return user;
  }

  public User login(String userIDCookie) {
    User user = userDAO.login(userIDCookie);
    return user;
  }

  public User getUser(String userID) {
    return userDAO.getUser(userID);
  }

  public User updateUser(User user) {
    return userDAO.updateUser(user);
  }

  public void deleteUser(String userID) {
    userDAO.deleteUser(userID);
  }


}
