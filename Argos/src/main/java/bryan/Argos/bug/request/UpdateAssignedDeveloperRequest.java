package bryan.Argos.bug.request;

import javax.validation.constraints.NotBlank;

public class UpdateAssignedDeveloperRequest {

  @NotBlank
  private String bugID;

  @NotBlank
  private String developerID;

  public String getBugID() {
    return bugID;
  }

  public void setBugID(String bugID) {
    this.bugID = bugID;
  }

  public String getDeveloperID() {
    return developerID;
  }

  public void setDeveloperID(String developerID) {
    this.developerID = developerID;
  }
}
