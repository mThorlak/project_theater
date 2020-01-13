package ejbSession;

import ejbEntity.place;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionPlaceRemote {
    public place buyPlace(place place);
}
