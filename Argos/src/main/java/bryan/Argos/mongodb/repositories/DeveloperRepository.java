package bryan.Argos.mongodb.repositories;


import bryan.Argos.developer.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeveloperRepository extends MongoRepository<Developer,String> {
  Developer findByEmail(String developerEmail);

  Developer findByDeveloperID(String developerID);
}
