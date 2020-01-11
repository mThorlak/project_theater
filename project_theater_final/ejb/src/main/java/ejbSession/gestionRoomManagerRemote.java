package ejbSession;

import ejbEntity.roomManager;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionRoomManagerRemote {
    public roomManager addRoomManager(roomManager roomManager) throws Exception;
    public roomManager findRoomManager(String Name);
    public List<roomManager> listAllRoomManager();
}
