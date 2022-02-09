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
  private String projectID;
  private ArrayList<String> assigneddevelopersID = new ArrayList<String>();
  private String creatorID;
  private String description;
  private LocalDateTime dateCreated;
  private Date dateResolved;
  private Boolean resolved;

  public Bug(
      @JsonProperty("bugID") String bugID,
      @JsonProperty("projectID")String projectID,
      @JsonProperty("creatorID")String creatorID,
      @JsonProperty("description")String description,
      @JsonProperty("dateResolved")Date dateResolved) {
    this.bugID = bugID;
    this.projectID = projectID;
    this.creatorID = creatorID;
    this.description = description;
    this.dateCreated = LocalDateTime.now();
    this.dateResolved = null;
    this.resolved = false;
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

  public ArrayList<String> getAssigneddevelopersID() {
    return assigneddevelopersID;
  }

  public ArrayList<String> setAssigneddevelopersID(String developersID) {
    assigneddevelopersID.add(developersID);
    return assigneddevelopersID;
  }

  public ArrayList<String> removeAssigneddevelopersID(String developersID) {
    assigneddevelopersID.remove(developersID);
    return assigneddevelopersID;
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
