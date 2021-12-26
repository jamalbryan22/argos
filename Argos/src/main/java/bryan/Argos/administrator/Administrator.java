package bryan.Argos.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;


public class Administrator {

  private String administratorID;
  private String email;
  private String password;
  private String firstName;
  private String lastName;

  public Administrator(@JsonProperty("administratorID") String developerID,
      @JsonProperty ("firstName") String firstName,
      @JsonProperty("lastName")String lastName,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password) {
    this.administratorID = administratorID;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public String getAdministratorID() {
    return administratorID;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setAdministratorID(String administratorID) {
    this.administratorID = administratorID;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
