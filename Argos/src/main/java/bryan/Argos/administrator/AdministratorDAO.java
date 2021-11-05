package bryan.Argos.administrator;

import bryan.Argos.mongodb.repositories.AdministratorRepository;
import bryan.Argos.security.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdministratorDAO {

  @Autowired
  AdministratorRepository administratorRepository;

  public AdministratorDAO (AdministratorRepository administratorRepository){this.administratorRepository=administratorRepository;}

  public Administrator login(String administratorIDCookie) {
  return administratorRepository.findByAdministratorID(administratorIDCookie);
  }

  public Administrator login(LoginCredentials loginCredentials) {
    return administratorRepository.findByEmail(loginCredentials.getEmail());
  }
}
