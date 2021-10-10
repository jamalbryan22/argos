package bryan.Argos.project;

import java.util.UUID;

public class Project {

  private final UUID projectID;
  private String projectName;

  public Project(String projectName) {
    this.projectID = UUID.randomUUID();
    this.projectName = projectName;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
}
