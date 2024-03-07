//import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


// Implementación de objeto y sus métodos remotos, implementa interfaz remota
public class ShapeImpl extends UnicastRemoteObject implements Shape {
    int myVersion;
    GraphicalObject theG;
    
 
    public ShapeImpl(GraphicalObject g, int version)throws RemoteException{
    	theG = g;
 	myVersion = version;
    }
    
    @Override
    public int getVersion() throws RemoteException {
	return myVersion;
    }
    
    @Override
    public GraphicalObject  getAllState() throws RemoteException{
        return theG;
    }
    
}

