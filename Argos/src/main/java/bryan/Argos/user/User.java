package bryan.Argos.user;

import bryan.Argos.security.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {

  @Id
  private String user_id;

  @NotBlank
  @Size(min = 2, max = 25)
  private String first_name;

  @NotBlank
  @Size(min = 2, max = 25)
  private String last_name;

  @NotBlank
  @Size(max = 40)
  @Email
  private String email;

  @NotBlank
  @Size(min = 6, max = 25)
  private String password;

  @NotBlank
  @Min(value = 13, message = "must be at least 13 years old")
  @Max(value = 120, message = "must be at under 120 years old")
  private String age;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_state;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_country;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_city;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_zip;

  @DBRef
  private Set<Role> roles = new HashSet<>();
  private List<String> user_bugs;
  private LocalDateTime user_created;



  public User(
      @JsonProperty("first_name") String first_name,
      @JsonProperty("last_name") String last_name,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password,
      @JsonProperty("age") String age,
      @JsonProperty("user_country") String user_country,
      @JsonProperty("user_state") String user_state,
      @JsonProperty("user_city") String user_city,
      @JsonProperty("user_zip") String user_zip) {
      this.user_id = UUID.randomUUID().toString();
      this.email = email;
      this.password = password;
      this.age = age;
      this.user_country = user_country;
      this.user_state = user_state;
      this.user_city = user_city;
      this.user_zip = user_zip;
      this.user_created = LocalDateTime.now();
    }

    public String getUser_id () {
      return user_id;
    }

    public void setUser_id (String user_id){
      this.user_id = user_id;
    }

    public String getFirst_name () {
      return first_name;
    }

    public void setFirst_name (String first_name){
      this.first_name = first_name;
    }

    public String getLast_name () {
      return last_name;
    }

    public void setLast_name (String last_name){
      this.last_name = last_name;
    }

    public String getEmail () {
      return email;
    }

    public void setEmail (String email){
      this.email = email;
    }

    public String getPassword () {
      return password;
    }

    public void setPassword (String password){
      this.password = password;
    }

    public String getAge () {
      return age;
    }

    public void setAge (String age){
      this.age = age;
    }

    public String getUser_state () {
      return user_state;
    }

    public void setUser_state (String user_state){
      this.user_state = user_state;
    }

    public String getUser_country () {
      return user_country;
    }

    public void setUser_country (String user_country){
      this.user_country = user_country;
    }

    public String getUser_city () {
      return user_city;
    }

    public void setUser_city (String user_city){
      this.user_city = user_city;
    }

    public String getUser_zip () {
      return user_zip;
    }

    public void setUser_zip (String user_zip){
      this.user_zip = user_zip;
    }

    public Set<Role> getRoles () {
      return roles;
    }

    public void setRoles (Set < Role > roles) {
      this.roles = roles;
    }

    public List<String> getBugs_created () {
      return user_bugs;
    }

    public void setBugs_created (List <String> user_bugs) {
      this.user_bugs = user_bugs;
    }

    public LocalDateTime getUser_created () {
      return user_created;
    }

    public void setUser_created (LocalDateTime user_created){
      this.user_created = user_created;
    }
  }

