package bryan.Argos.bug;

import bryan.Argos.mongodb.repositories.BugRepository;
import java.util.Collections;
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

  public List<Bug> findByProjectID(String ProjectID) {
//    return bugsRepository.findByProjectID(ProjectID);
        System.out.println(bugRepository.findAllById(Collections.singleton("3")));
        return bugRepository.findAll();



  }

  public Optional<Bug> findByBugID(String bugID){
    System.out.println("bug repo return:" + bugRepository.findById(bugID));
    return bugRepository.findById(bugID);
  }

  public Bug updateBug(Bug bugUpdates) {
    return bugRepository.save(bugUpdates);
  }

  public void deleteBug(String bugID) {
    bugRepository.deleteById(bugID);
  }

}
