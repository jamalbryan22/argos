package bryan.Argos.bug;

import java.util.Date;
import java.util.UUID;

public class Bug {

  private final UUID BugID;
  private final UUID projectID;
  private final String description;
  private final Date dateCreated;
  private UUID developerId;
  private Date dateResolved;
  private Boolean resolved;


  public Bug(UUID projectID, String description, Date dateCreated) {
    BugID = UUID.randomUUID();
    this.projectID = projectID;
    this.description = description;
    this.dateCreated = dateCreated;
  }

  public UUID getBugID() {
    return BugID;
  }

  public UUID getProjectID() {
    return projectID;
  }

  public String getDescription() {
    return description;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public UUID getDeveloperId() {
    return developerId;
  }

  public Date getDateResolved() {
    return dateResolved;
  }

  public Boolean getResolved() {
    return resolved;
  }

  public void setDeveloperId(UUID developerId) {
    this.developerId = developerId;
  }

  public void setDateResolved(Date dateResolved) {
    this.dateResolved = dateResolved;
  }

  public void setResolved(Boolean resolved) {
    this.resolved = resolved;
  }


}
