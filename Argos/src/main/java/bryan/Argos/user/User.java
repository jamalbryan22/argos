package bryan.Argos.user;

import bryan.Argos.bug.Bug;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {

  @Id
  private String userID;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private List<Bug> workingBugs;

  public User(
      @JsonProperty("userID") String userID,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password) {
    this.userID = userID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

    public String getUserID() {
      return userID;
    }

    public void setUserID(String userID) {
      this.userID = userID;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public void setWorkingBugs(List<Bug> workingBugs) {
      this.workingBugs = workingBugs;
    }

    public List<Bug> getWorkingBugs() {
    return workingBugs;
  }

  @Override
  public String toString() {
    return "User{" +
        "userID='" + userID + '\'' +
        ", firstName='" + firstName + '\'' +
        ", email='" + email + '\'' +
        ", lastName='" + lastName + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
