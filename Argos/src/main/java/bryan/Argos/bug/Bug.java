package bryan.Argos.bug;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("bugs")
public class Bug {

  @Id
  private String bugID;
  private String ProjectID;
  private ArrayList<String> assignedDevelopersID;
  private String creatorID;
  private String description;
  private LocalDateTime dateCreated;
  private Date dateResolved;
  private Boolean resolved;

  public Bug(
      @JsonProperty("bugID") String bugID,
      @JsonProperty("ProjectID")String ProjectID,
      @JsonProperty("DevelopersID")String DevelopersID,
      @JsonProperty("creatorID")String creatorID,
      @JsonProperty("description")String description,
      @JsonProperty("dateResolved")Date dateResolved,
      @JsonProperty("resolved")Boolean resolved) {
    this.bugID = bugID;
    this.ProjectID = ProjectID;
    this.assignedDevelopersID = setAssignedDevelopersID(DevelopersID);
    this.creatorID = creatorID;
    this.description = description;
    this.dateCreated = LocalDateTime.now();
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
    return ProjectID;
  }

  public void setProjectID(String ProjectID) {
    this.ProjectID = ProjectID;
  }

  public ArrayList<String> getAssignedDevelopersID() {
    return assignedDevelopersID;
  }

  public ArrayList<String> setAssignedDevelopersID(String developersID) {
    assignedDevelopersID.add(developersID);
    return assignedDevelopersID;
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

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
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
