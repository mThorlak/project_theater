package ejbSession;

import ejbEntity.place;
import ejbEntity.roomManager;
import ejbEntity.spectacle;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionRoomManagerRemote {
    public roomManager addRoomManager(roomManager roomManager) throws Exception;
    public roomManager findRoomManager(String Name);
    public List<roomManager> listAllRoomManager();
    public List<place> listAllBoughtPlaceSpectacle(spectacle spectacle);
    public List<place> listAllAvailablePlaceSpectacle(spectacle spectacle);
}
