package test;

import ejbEntity.roomManager;
import ejbSession.gestionRoomManagerRemote;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class testRoomManagerBD {
    public static void main(String[] args) {
        try{
            gestionRoomManagerRemote remote= lookupRemoteStatelessGestionRoomManager();
            roomManager p = remote.addRoomManager(new roomManager("Tomate", "test"));
            System.out.println(p);
        } catch (Exception e) {e.printStackTrace();}
    }

    // Connexion au serveur et lookup du bean
    private static gestionRoomManagerRemote lookupRemoteStatelessGestionRoomManager() throws NamingException {
        gestionRoomManagerRemote remote=null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            InitialContext ctx = new InitialContext(jndiProps);
            remote = (gestionRoomManagerRemote) ctx.lookup("ejb://project_theater/project_theater_final/ejb/src/main/java/ejbSession/gestionRoomManager!ejbSession.gestionRoomManagerRemote");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remote;
    }
}