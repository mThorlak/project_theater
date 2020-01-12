package connect_db;

import ejbSession.gestionRoomManagerRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class connexionDB {

    private gestionRoomManagerRemote connexionManagerRoomManager;

    public connexionDB () throws NamingException {
        this.connexionManagerRoomManager = lookupRemoteStatelessGestionRoomManager();
    }

    public gestionRoomManagerRemote getconnexionManagerRoomManager() {
        return connexionManagerRoomManager;
    }

    public static gestionRoomManagerRemote lookupRemoteStatelessGestionRoomManager() throws NamingException {
        gestionRoomManagerRemote fct = null;
        System.out.println("dans le lookup0");
        try{
            System.out.println("dans le lookup1");
            Properties jndiProps=new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx= new InitialContext(jndiProps);
            System.out.println("dans le lookup: ");
            fct=(gestionRoomManagerRemote) ctx.lookup("ejb:/project_theater_final_war_exploded/gestionRoomManager!ejbSession.gestionRoomManagerRemote");
            System.out.println("voici la fct:" );

        }catch(Exception ignored){

        }
        return fct;
    }
}
