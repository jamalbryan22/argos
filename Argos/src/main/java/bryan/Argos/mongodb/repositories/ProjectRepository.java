package bryan.Argos.mongodb.repositories;

import bryan.Argos.project.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project,String> {
  Project findByProjectID(String projectID);
}
