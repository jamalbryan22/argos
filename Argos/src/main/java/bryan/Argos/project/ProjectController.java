package bryan.Argos.project;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

  @Autowired
  ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping("/create-project")
  @PreAuthorize("hasRole('USER') or hasRole('DEVELOPER') or hasRole('ADMIN')")
  public Project createProject(@RequestBody Project newProject) {
    return projectService.createProject(newProject);
  }

  @GetMapping("/get-all-projects")
  @PreAuthorize("hasRole('USER') or hasRole('DEVELOPER') or hasRole('ADMIN')")
  public List<Project> getAllProjects(@RequestBody String creatorUserID) {
    if (StringUtils.hasText(creatorUserID)) {
      creatorUserID = creatorUserID.substring(20, creatorUserID.length()-5);
    }
    System.out.println(creatorUserID);
    return projectService.getAllUserProjects(creatorUserID);
  }

  @GetMapping("/get-project")
  @PreAuthorize("hasRole('USER') or hasRole('DEVELOPER') or hasRole('ADMIN')")
  public Optional<Project> getProject(@RequestBody String projectID) {
    if (StringUtils.hasText(projectID)) {
      projectID = projectID.substring(16, projectID.length()-4);
    }
    System.out.println(projectID);
    return projectService.getProject(projectID);
  }

  @PatchMapping("/update-project")
  @PreAuthorize("hasRole('USER') or hasRole('DEVELOPER') or hasRole('ADMIN')")
  public void updateProject(@RequestBody Project project) {
    projectService.updateProject(project);
  }

  @DeleteMapping("/delete-project")
  @PreAuthorize("hasRole('USER') or hasRole('DEVELOPER') or hasRole('ADMIN')")
  public void deleteProject(@RequestBody String projectID) {
    if (StringUtils.hasText(projectID)) {
      projectID = projectID.substring(15, projectID.length()-3);
    }
    System.out.println(projectID);
    projectService.deleteProject(projectID);
  }
}