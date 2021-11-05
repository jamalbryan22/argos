package bryan.Argos.developer;

import bryan.Argos.security.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

  DeveloperDAO developerDAO;

  @Autowired
  public DeveloperService(DeveloperDAO developerDAO) {
    this.developerDAO = developerDAO;
  }

  public Developer createNewDeveloper(Developer developer) {
    return developerDAO.createNewDeveloper(developer);
  }

  public Developer login(LoginCredentials loginCredentials){
    Developer developer = developerDAO.login(loginCredentials);
    return developer;
  }

  public Developer login(String developerIDCookie) {
    Developer developer = developerDAO.login(developerIDCookie);
    return developer;
  }

  public Developer getDeveloper(String developerID) {
    return developerDAO.getDeveloper(developerID);
  }

  public Developer updateDeveloper(Developer developer) {
     return developerDAO.updateDeveloper(developer);
  }

  public void deleteDeveloper(String developerID) {
    developerDAO.deleteDeveloper(developerID);
  }

}
