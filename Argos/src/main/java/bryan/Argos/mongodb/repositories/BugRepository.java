package bryan.Argos.mongodb.repositories;

import bryan.Argos.bug.Bug;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BugRepository extends MongoRepository<Bug,String> {
  List<Bug> findByCreatorID(String creatorID);
  List<Bug> findByProjectID(String ProjectID);
}
