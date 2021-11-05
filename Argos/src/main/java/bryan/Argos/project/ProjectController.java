package bryan.Argos.project;

import bryan.Argos.user.User;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    public ProjectController(ProjectService projectService){this.projectService=projectService;}

    @PostMapping()
    public Project createProject(@RequestBody String projectName) {
      Project newProject = new Project(UUID.randomUUID().toString(),projectName);
      return projectService.createProject(newProject);
    }

    @DeleteMapping()
    public void deleteProject(@RequestParam String projectID){
      projectService.deleteProject(projectID);
    }

    @GetMapping
    public Project getProject(@RequestParam String projectID){
      return projectService.getProject(projectID);
    }

  @PatchMapping("/update")
  public void updateProject(@RequestBody Project project){
   projectService.updateProject(project);
  }
}
