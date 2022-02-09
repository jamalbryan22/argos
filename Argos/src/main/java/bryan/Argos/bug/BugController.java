package bryan.Argos.bug;

import bryan.Argos.bug.request.UpdateAssignedDeveloperRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bugs")
public class BugController {

  private final BugService bugService;

  @Autowired
  public BugController(BugService bugService){this.bugService = bugService;}

  @PostMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('Developer') or hasRole('ADMIN')")
  public Bug createBug(@RequestBody Bug newBug){
    if(newBug.getDateResolved() == null){
      newBug.setDateResolved(null);
    }
    return bugService.createNewBug(newBug);
  }

  @GetMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('Developer') or hasRole('ADMIN')")
  public Optional<Bug> getBug(@RequestBody String bugID){
    if (StringUtils.hasText(bugID)) {
      bugID = bugID.substring(14, bugID.length()-2);
    }
    return bugService.findByBugID(bugID);
  }


  @GetMapping("/all-user-bugs")
  @PreAuthorize("hasRole('USER') or hasRole('Developer') or hasRole('ADMIN')")
  public List<Bug> getAllUserBugs(@RequestBody String creatorID){
    if (StringUtils.hasText(creatorID)) {
      creatorID = creatorID.substring(16, creatorID.length()-3);
    }
    return bugService.findByCreatorID(creatorID);
  }

  @GetMapping("/all-project-bugs")
  @PreAuthorize("hasRole('USER') or hasRole('Developer') or hasRole('ADMIN')")
  public List<Bug> getAllProjectBugs(@RequestBody String projectID){
    if (StringUtils.hasText(projectID)) {
      projectID = projectID.substring(19, projectID.length()-3);
    }
    return bugService.findBugsByProjectID(projectID);
  }

  @PatchMapping("")
  @PreAuthorize("hasRole('Developer') or hasRole('ADMIN')")
  public Bug updateBug(@RequestBody Bug bugUpdates){
    return bugService.updateBug(bugUpdates);
  }

  @DeleteMapping("")
  @PreAuthorize("hasRole('Developer') or hasRole('ADMIN')")
  public void deleteBug(@RequestBody String bugID){
    bugService.deleteBug(bugID);
  }

  @PostMapping("/add-assigned-developer")
  @PreAuthorize("hasRole('ADMIN')")
  public void addAssignedDev(@RequestBody UpdateAssignedDeveloperRequest updateDeveloperRequest){

    Optional bugToBeUpdated = bugService.findByBugID(updateDeveloperRequest.getBugID());
    if(bugToBeUpdated.isPresent()){
      Bug bug = (Bug) bugToBeUpdated.get();
      bug.setAssigneddevelopersID(updateDeveloperRequest.getDeveloperID());
      bugService.updateBug(bug);
    }
  }

  @PostMapping("/remove-assigned-developer")
  @PreAuthorize("hasRole('ADMIN')")
  public void removeAssignedDev(@RequestBody UpdateAssignedDeveloperRequest updateDeveloperRequest){

    Optional bugToBeUpdated = bugService.findByBugID(updateDeveloperRequest.getBugID());
    if(bugToBeUpdated.isPresent()){
      Bug bug = (Bug) bugToBeUpdated.get();
      bug.removeAssigneddevelopersID(updateDeveloperRequest.getDeveloperID());
      bugService.updateBug(bug);
    }
  }

}
