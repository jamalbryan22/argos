package bryan.Argos.mongodb.repositories;

import bryan.Argos.administrator.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministratorRepository extends MongoRepository<Administrator,String> {

  Administrator findByEmail(String email);
  Administrator findByAdministratorID(String administratorID);
}
