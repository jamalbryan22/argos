package bryan.Argos.developer;

import bryan.Argos.bug.Bug;
import java.util.List;
import java.util.UUID;

public class Developer {

  private final UUID developerID;
  private final String firstName;
  private final String email;
  private String lastName;
  private String password;

  private List <Bug> workingBugs;

  public Developer( String firstName, String lastName, String email,
      String password) {
    this.developerID = UUID.randomUUID();
    this.firstName = firstName;
    this.email = email;
    this.lastName = lastName;
    this.password = password;
  }

  public UUID getDeveloperID() {
    return developerID;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getEmail() {
    return email;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPassword() {
    return password;
  }

  public List<Bug> getWorkingBugs() {
    return workingBugs;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
