package bryan.Argos.project;

import bryan.Argos.mongodb.repositories.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {

  @Autowired
  ProjectRepository projectRepository;

  Project createProject(Project newProject){
   return projectRepository.save(newProject);
  }

  public void deleteProject(String projectID) {
    projectRepository.deleteById(projectID);
  }

  public void updateProject(Project project) {
    projectRepository.save(project);
  }

  public Optional<Project> getProject(String projectID) {
    System.out.println(projectID);
    System.out.println(projectRepository.findById(projectID));
    return projectRepository.findById(projectID);
  }

  public List<Project> getAllUserProjects(String userID){return projectRepository.findAllProjectsByCreatorUserID(userID);}
}
