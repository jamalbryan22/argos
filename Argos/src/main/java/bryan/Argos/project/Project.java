package bryan.Argos.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("projects")
public class Project {

  @Id
  private String projectID;
  private String projectName;
  private String creatorUserID;
  private Date createdAt;


  public Project(
      @JsonProperty("projectID") String projectID,
      @JsonProperty("projectName") String projectName,
      @JsonProperty("creatorUserID") String creatorUserID) {
      this.projectID = projectID;
      this.projectName = projectName;
      this.creatorUserID = creatorUserID;
      this.createdAt = new Date();
  }

  public String getProjectID() {
    return projectID;
  }

  public String getProjectName() {
    return projectName;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setProjectID(String projectID) {
    this.projectID = projectID;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  @Override
  public String toString() {
    return "Project{" +
        "projectID='" + projectID + '\'' +
        ", projectName='" + projectName + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}

