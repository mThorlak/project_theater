package connect_db;

import ejbSession.gestionPlaceRemote;
import ejbSession.gestionRoomManagerRemote;
import ejbSession.gestionSpectacleRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class connexionDB {

    private gestionRoomManagerRemote connexionManagerRoomManager;
    private gestionSpectacleRemote connexionManagerSpectacle;
    private gestionPlaceRemote connexionManagerPlace;

    public connexionDB () throws NamingException {
        this.connexionManagerRoomManager = lookupRemoteStatelessGestionRoomManager();
        this.connexionManagerSpectacle = lookupRemoteStatelessGestionSpectacle();
        this.connexionManagerPlace = lookupRemoteStatelessGestionPlace();
    }

    public gestionRoomManagerRemote getconnexionManagerRoomManager() {
        return connexionManagerRoomManager;
    }

    public gestionSpectacleRemote getConnexionManagerSpectacle() {
        return connexionManagerSpectacle;
    }

    public gestionPlaceRemote getConnexionManagerPlace() { return connexionManagerPlace; }

    public static gestionRoomManagerRemote lookupRemoteStatelessGestionRoomManager() throws NamingException {
        gestionRoomManagerRemote fct = null;
        try{
            Properties jndiProps = new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx= new InitialContext(jndiProps);
            fct = (gestionRoomManagerRemote) ctx.lookup("ejb:/project_theater_final_war_exploded/gestionRoomManager!ejbSession.gestionRoomManagerRemote");

        }catch(Exception ignored){

        }
        return fct;
    }

    public static gestionSpectacleRemote lookupRemoteStatelessGestionSpectacle() throws NamingException {
        gestionSpectacleRemote fct = null;
        try{
            Properties jndiProps=new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx= new InitialContext(jndiProps);
            fct=(gestionSpectacleRemote) ctx.lookup("ejb:/project_theater_final_war_exploded/gestionSpectacle!ejbSession.gestionSpectacleRemote");

        }catch(Exception ignored){

        }
        return fct;
    }

    public static gestionPlaceRemote lookupRemoteStatelessGestionPlace() throws NamingException {
        gestionPlaceRemote fct = null;
        try{
            Properties jndiProps=new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx= new InitialContext(jndiProps);
            fct=(gestionPlaceRemote) ctx.lookup("ejb:/project_theater_final_war_exploded/gestionPlace!ejbSession.gestionPlaceRemote");

        }catch(Exception ignored){

        }
        return fct;
    }

}
