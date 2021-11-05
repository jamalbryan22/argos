package bryan.Argos.project;

import bryan.Argos.mongodb.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {

  @Autowired
  ProjectRepository projectRepository;

  Project createProject(Project newProject){
   return projectRepository.save( newProject);
  }

  public void deleteProject(String projectID) {
    projectRepository.deleteById(projectID);
  }

  public void updateProject(Project project) {
    projectRepository.save(project);
  }

  public Project getProject(String projectID) {
    return projectRepository.findByProjectID(projectID);
  }
}
