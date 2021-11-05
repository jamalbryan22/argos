package bryan.Argos.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  ProjectDAO projectDAO;

  public Project createProject(Project newProject) {
    return projectDAO.createProject(newProject);
  }

  public void deleteProject(String projectID){
    projectDAO.deleteProject(projectID);
  }

  public void updateProject(Project project) {
    projectDAO.updateProject(project);
  }

  public Project getProject(String projectID) {
    return projectDAO.getProject(projectID);
  }
}
