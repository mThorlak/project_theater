package ejbSession;

import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionSpectacleRemote {
    public spectacle addSpectacle(spectacle spectacle);
    public spectacle findSpectacle(int id);
    public List<spectacle> listAllSpectacle();
    public void buyTicket(spectacle spectacle);
/*    public List<spectacle> listSpectacleName();
    public List<spectacle> listSpectacleCategory();
    public List<spectacle> listSpectacleDate();*/
}
