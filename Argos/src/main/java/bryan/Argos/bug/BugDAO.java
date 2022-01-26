package bryan.Argos.bug;

import bryan.Argos.mongodb.repositories.BugRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BugDAO {

  @Autowired
  private BugRepository bugRepository;

  public Bug createNewBug(Bug bug) {
    return bugRepository.save(bug);
  }

  public List<Bug> findByCreatorID(String creatorID) {
    return bugRepository.findByCreatorID(creatorID);
  }

  public List<Bug> findByReferenceProjectID(String referenceProjectID) {
    return bugRepository.findByProjectID(referenceProjectID);
  }

  public Optional<Bug> findByBugID(String bugID){
    return bugRepository.findById(bugID);
  }

  public Bug updateBug(Bug bugUpdates) {
    return bugRepository.save(bugUpdates);
  }

  public void deleteBug(String bugID) {
    bugRepository.deleteById(bugID);
  }

}
