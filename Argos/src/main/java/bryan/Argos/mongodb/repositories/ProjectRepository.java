package bryan.Argos.mongodb.repositories;

import bryan.Argos.project.Project;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project,String> {
  List<Project> findAllProjectsByCreatorUserID(String creatorUserID);
}
