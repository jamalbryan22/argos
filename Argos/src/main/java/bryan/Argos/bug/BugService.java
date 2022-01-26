package bryan.Argos.bug;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {

  @Autowired
  private BugDAO bugDAO;

  public BugService(BugDAO bugDAO){this.bugDAO=bugDAO;}

  public Bug createNewBug(Bug bug) {
    return bugDAO.createNewBug(bug);
  }

  public List<Bug> findByCreatorID(String creatorID){
    return bugDAO.findByCreatorID(creatorID);
  }

  public List<Bug> findBugsByReferenceProjectID(String referenceProjectID) {
    return bugDAO.findByReferenceProjectID(referenceProjectID);
  }

  public Optional<Bug> findByBugID(String bugID){
    return bugDAO.findByBugID(bugID);
  }

  public Bug updateBug(Bug bugUpdates) {
    return bugDAO.updateBug(bugUpdates);
  }

  public void deleteBug(String bugID) {
    bugDAO.deleteBug(bugID);
  }
}
