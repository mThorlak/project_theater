package ejbSession;

import ejbEntity.place;
import ejbEntity.roomManager;
import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionRoomManagerRemote {
    public void addRoomManager(roomManager roomManager) throws Exception;
    public roomManager findRoomManager(roomManager roomManager);
    public List<roomManager> listAllRoomManager();
    public List<place> listAllBoughtPlaceSpectacle(spectacle spectacle);
    public List<place> listAllAvailablePlaceSpectacle(spectacle spectacle);
    public List<place> listAllAvailablePlace20Spectacle(spectacle spectacle);
    public List<place> listAllAvailablePlace40Spectacle(spectacle spectacle);
    public List<place> listAllAvailablePlace55Spectacle(spectacle spectacle);
}
