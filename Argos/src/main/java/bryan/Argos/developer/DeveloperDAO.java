package bryan.Argos.developer;

import bryan.Argos.mongodb.repositories.DeveloperRepository;
import bryan.Argos.mongodb.repositories.UserRepository;
import bryan.Argos.security.LoginCredentials;
import bryan.Argos.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeveloperDAO {

  @Autowired
  DeveloperRepository developerRepository;

  public DeveloperDAO(DeveloperRepository developerRepository) {this.developerRepository = developerRepository;}

  public Developer createNewDeveloper(Developer developer) {
    return developerRepository.save(new Developer(developer.getDeveloperID(),developer.getFirstName(),developer.getLastName(),developer.getEmail(),developer.getPassword()));
  }

  public Developer login(LoginCredentials loginCredentials) {
    Developer developer = developerRepository.findByEmail(loginCredentials.getEmail());
    return developer;
  }

  public Developer login(String developerIDCookie) {
    Developer developer = developerRepository.findByDeveloperID(developerIDCookie);
    return developer;
  }

  public Developer updateDeveloper(Developer developer) {
    return developerRepository.save(developer);
  }

  public void deleteDeveloper(String developerID) {
    developerRepository.deleteById(developerID);
  }

  public Developer getDeveloper(String developerID) {
    return developerRepository.findByDeveloperID(developerID);
  }
}
