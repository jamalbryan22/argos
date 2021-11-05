package bryan.Argos.mongodb.repositories;

import bryan.Argos.bug.Bug;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BugRepository extends MongoRepository<Bug,String> {

}
