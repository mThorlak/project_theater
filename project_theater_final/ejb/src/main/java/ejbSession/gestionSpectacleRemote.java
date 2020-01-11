package ejbSession;

import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionSpectacleRemote {
    public spectacle addSpectacle(spectacle spectacle);
    public spectacle findSpectacle(String Name);
    public List<spectacle> listAllSpectacle();
}
