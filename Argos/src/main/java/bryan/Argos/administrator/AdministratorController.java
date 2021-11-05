package bryan.Argos.administrator;

import bryan.Argos.security.LoginCredentials;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/administrator")
public class AdministratorController {

  @Autowired
  AdministratorService administratorService;

  public AdministratorController(AdministratorService administratorService){this.administratorService = administratorService;}

  @PostMapping("/login")
  public String loginIn(@CookieValue(name = "administratorID", defaultValue = "null") String administratorIDCookie, @RequestBody LoginCredentials loginCredentials, HttpServletResponse response) {

    Administrator administrator = null;
    Cookie cookie = null;

    if(administratorIDCookie != "null"){
      administrator = administratorService.login(administratorIDCookie);
      if(administrator != null)
        return administrator.toString();
    }

    administrator = administratorService.login(loginCredentials);

    if (administrator != null){
      cookie = new Cookie("administratorID",administrator.getAdministratorID());
      response.addCookie(cookie);
      return administrator.toString();
    }
    else
      return "Bad Email or Password";
  }

}
