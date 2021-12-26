package bryan.Argos.user;

import bryan.Argos.bug.Bug;
import bryan.Argos.security.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {

  @Id
  private String userID;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  private String password;
  @DBRef
  private Set<Role> roles = new HashSet<>();


  public User(
      @JsonProperty("username") String userName,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password){
        this.userName = userName;
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

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

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

    public Set<Role> getRoles() {
      return roles;
    }

    public void setRoles(Set<Role> roles) {
      this.roles = roles;
    }

}
