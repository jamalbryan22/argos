package bryan.Argos.developer;

import bryan.Argos.bug.Bug;
import bryan.Argos.project.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("developers")
public class Developer {

  @Id
  private String developerID;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private List<Project> activeProjects;

  public Developer(
      @JsonProperty("developerID") String developerID,
      @JsonProperty ("firstName") String firstName,
      @JsonProperty("lastName")String lastName,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password) {
    this.developerID = developerID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public String getDeveloperID() {
    return developerID;
  }

  public void setDeveloperID(String developerID) {
    this.developerID = developerID;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Project> getActiveProjects() {
    return activeProjects;
  }

  public void setActiveProjects(List<Project> activeProjects) {
    this.activeProjects = activeProjects;
  }

  @Override
  public String toString() {
    return "Developer{" +
        "developerID='" + developerID + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
