package bryan.Argos.administrator;

import bryan.Argos.security.LoginCredentials;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

  AdministratorDAO administratorDAO;

  public Administrator login(String administratorIDCookie) {
    return administratorDAO.login(administratorIDCookie);
  }

  public Administrator login(LoginCredentials loginCredentials) {
    return administratorDAO.login(loginCredentials);
  }
}
