package bryan.Argos.bug;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Bugs")
public class Bug {

  @Id
  private String bugID;
  private String projectID;
  private String assignedDeveloperID;
  private String creatorID;
  private String description;
  private Date dateCreated;
  private Date dateResolved;
  private Boolean resolved;

  public Bug(
      @JsonProperty("bugID") String bugID,
      @JsonProperty("projectID")String projectID,
      @JsonProperty("assignedDeveloperID")String assignedDeveloperID,
      @JsonProperty("creatorID")String creatorID,
      @JsonProperty("description")String description,
      @JsonProperty("dateCreated")Date dateCreated,
      @JsonProperty("dateResolved")Date dateResolved,
      @JsonProperty("resolved")Boolean resolved) {
    bugID = bugID;
    this.projectID = projectID;
    this.assignedDeveloperID = assignedDeveloperID;
    this.creatorID = creatorID;
    this.description = description;
    this.dateCreated = dateCreated;
    this.dateResolved = dateResolved;
    this.resolved = resolved;
  }

  public String getBugID() {
    return bugID;
  }

  public void setBugID(String bugID) {
    this.bugID = bugID;
  }

  public String getProjectID() {
    return projectID;
  }

  public void setProjectID(String projectID) {
    this.projectID = projectID;
  }

  public String getAssignedDeveloperID() {
    return assignedDeveloperID;
  }

  public void setAssignedDeveloperID(String assignedDeveloperID) {
    this.assignedDeveloperID = assignedDeveloperID;
  }

  public String getCreatorID() {
    return creatorID;
  }

  public void setCreatorID(String creatorID) {
    this.creatorID = creatorID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateResolved() {
    return dateResolved;
  }

  public void setDateResolved(Date dateResolved) {
    this.dateResolved = dateResolved;
  }

  public Boolean getResolved() {
    return resolved;
  }

  public void setResolved(Boolean resolved) {
    this.resolved = resolved;
  }
}
