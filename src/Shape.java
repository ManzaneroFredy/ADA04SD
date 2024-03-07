//package examples.RMIShape;
import java.rmi.*;
import java.util.Vector;

// Definición de la interfaz remota
public interface Shape extends Remote {
   int getVersion() throws RemoteException;
   GraphicalObject getAllState() throws RemoteException;
}
