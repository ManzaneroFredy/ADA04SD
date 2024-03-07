
import java.rmi.*;
import java.util.Vector;

//Interfaz remota para la lista de objetos
public interface ShapeList extends Remote {
    Shape newShape(GraphicalObject g) throws RemoteException;  	    
    Vector allShapes()throws RemoteException;
    int getVersion() throws RemoteException;
    int deleteShape(int version) throws RemoteException;
}
