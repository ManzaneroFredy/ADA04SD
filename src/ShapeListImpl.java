//import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

// Implementación de objeto y sus métodos remotos, implementa la interfaz remota
public class ShapeListImpl extends UnicastRemoteObject implements ShapeList{
    private Vector theList;
    private int version;
    
    public ShapeListImpl()throws RemoteException{
        theList = new Vector();
        version = 0;
    }

    @Override
    public Shape newShape(GraphicalObject g) throws RemoteException{
  	version++;
       	Shape s = new ShapeImpl( g, version);
        theList.addElement(s);                
        return s;
    }

    @Override
    public  Vector allShapes()throws RemoteException{
        return theList;
    }

   @Override
    public int getVersion() throws RemoteException{
        return version;
    } 

    @Override
    public int deleteShape(int version) throws RemoteException {
        if (!this.theList.isEmpty()) {
            int indexShapeToDelete = 0;
            for (Object shape : this.theList) {
                Shape actualShape = (Shape) shape;
                if (actualShape.getVersion() != version) {
                    indexShapeToDelete++;
                    continue;
                }
                break;
            }

            if (indexShapeToDelete + 1 != this.theList.size()) {
                this.theList.remove(indexShapeToDelete);
                return version;
            }
            return 0;
        }else{
            return 0;
        }
    }
}
