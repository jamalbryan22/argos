package bryan.Argos.developer;

import bryan.Argos.security.LoginCredentials;
import bryan.Argos.user.User;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperController {

  @Autowired
  DeveloperService developerService;

  public DeveloperController (DeveloperService developerService){this.developerService=developerService;}

  @PostMapping("/login")
  public String loginIn(@CookieValue(name = "developerID", defaultValue = "null") String developerIDCookie, @RequestBody LoginCredentials loginCredentials, HttpServletResponse response) {

    Developer developer = null;
    Cookie cookie = null;

    if(developerIDCookie != "null"){
      developer = developerService.login(developerIDCookie);
      if(developer != null)
        return developer.toString();
    }

    developer = developerService.login(loginCredentials);

    if (developer != null){
      cookie = new Cookie("developerID",developer.getDeveloperID());
      response.addCookie(cookie);
      return developer.toString();
    }
    else
      return "Bad Email or Password";
  }

  @PostMapping("/signup")
  public Developer addNewDeveloper(@RequestBody Developer developer, HttpServletResponse response){

    Developer newDeveloper = null;
    Cookie cookie = null;
    try{
      developer.setDeveloperID(UUID.randomUUID().toString());
      cookie = new Cookie("developerID",developer.getDeveloperID());
      response.addCookie(cookie);
      return developerService.createNewDeveloper(developer);
    }
    catch (Exception e){
      System.out.println("Something went wrong with the add new method:" + e);
    }
    return developer;
  }

  @GetMapping()
  public Developer getDeveloper(@RequestParam String developerID){
    return developerService.getDeveloper(developerID);
  }

  @PatchMapping("/update")
  public Developer updateDeveloper(@CookieValue(name = "developerID", defaultValue = "null") String developerIDCookie,@RequestBody Developer developer){
    developer.setDeveloperID(developerIDCookie);
    return developerService.updateDeveloper(developer);
  }

  @DeleteMapping
  public void deleteDeveloper(@RequestParam String developerID){
    developerService.deleteDeveloper(developerID);
  }

}
