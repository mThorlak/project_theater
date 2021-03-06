package ejbSession;

import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionSpectacleRemote {
    public spectacle addSpectacle(spectacle spectacle);
    public spectacle findSpectacle(Long id);
    public List<spectacle> listAllSpectacle();
    public void buyTicket(spectacle spectacle);
    public List<spectacle> listAllCategory ();
    public List<spectacle> listAllDate ();
    public List<spectacle> listAllSpectacleForCategory(String category);
    public List<spectacle> listAllSpectacleForDate(String date);
}
